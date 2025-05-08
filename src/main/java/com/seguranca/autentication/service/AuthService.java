package com.seguranca.autentication.service;

import com.seguranca.autentication.entities.User;
import com.seguranca.autentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class AuthService {
    @Autowired
    private UserRepository usuarioRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtEncoder jwtEncoder;

    public User buscarPorUsername(String username) {
        return usuarioRepo.findByUsername(username).orElse(null);
    }

    public boolean verificarSenha(String raw, String hashed) {
        return passwordEncoder.matches(raw, hashed);
    }

    public String gerarToken(User usuario) {
        var claims = JwtClaimsSet.builder()
                .subject(usuario.getUsername())
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
