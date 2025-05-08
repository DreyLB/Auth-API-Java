package com.seguranca.autentication.controller;

import com.seguranca.autentication.controller.dto.LoginDTO;

import com.seguranca.autentication.entities.User;
import com.seguranca.autentication.service.AuthService;
import com.seguranca.autentication.service.LogService;
import com.seguranca.autentication.service.TentativaLoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private AuthService authService;
    @Autowired private TentativaLoginService tentativaLoginService;

    @Autowired private LogService logService;
    @Autowired private HttpServletRequest request;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDto) {
        String username = loginDto.getUsername();
        String senha = loginDto.getSenha();
        String captcha = loginDto.getCaptcha();

        User user = authService.buscarPorUsername(username);
        if (user == null) {
            logService.registrar("Login falhou: usuário não encontrado - " + username);
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }

        String ip = request.getRemoteAddr();
        if (!ip.equals(user.getIpAutorizado())) {
            logService.registrar("Login falhou: IP não autorizado - " + ip + " para " + username);
            return ResponseEntity.status(403).body("IP não autorizado");
        }

        if (tentativaLoginService.precisaCaptcha(username)) {
            if (captcha == null || !tentativaLoginService.validarCaptcha(username, captcha)) {
                String novoCaptcha = tentativaLoginService.gerarCaptcha(username);
                logService.registrar("Captcha exigido para " + username + " - Novo captcha gerado: " + novoCaptcha);
                return ResponseEntity.status(403).body("Captcha necessário: " + novoCaptcha);
            }
        }

        if (!authService.verificarSenha(senha, user.getPassword())) {
            tentativaLoginService.registrarErro(username);
            logService.registrar("Senha incorreta para " + username);
            return ResponseEntity.status(401).body("Senha incorreta");
        }

        // Gerar e enviar código 2FA
        logService.registrar("Senha correta, aguardando 2FA para " + username);
        return ResponseEntity.ok("Código de verificação enviado por e-mail");
    }


}
