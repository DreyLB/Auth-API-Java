package com.seguranca.autentication.service;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TentativaLoginService {

    private final Map<String, Integer> tentativas = new ConcurrentHashMap<>();
    private final Map<String, String> captchas = new ConcurrentHashMap<>();

    public void registrarErro(String username) {
        tentativas.put(username, tentativas.getOrDefault(username, 0) + 1);
    }

    public boolean precisaCaptcha(String username) {
        return tentativas.getOrDefault(username, 0) >= 1;
    }

    public String gerarCaptcha(String username) {
        String captcha = String.valueOf(new Random().nextInt(900000) + 100000);
        captchas.put(username, captcha);
        return captcha;
    }

    public boolean validarCaptcha(String username, String captcha) {
        return captcha.equals(captchas.get(username));
    }

    public void limpar(String username) {
        tentativas.remove(username);
        captchas.remove(username);
    }
}
