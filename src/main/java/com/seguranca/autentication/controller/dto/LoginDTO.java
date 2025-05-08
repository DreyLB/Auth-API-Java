package com.seguranca.autentication.controller.dto;

public class LoginDTO {
    private String username;
    private String senha;
    private String captcha;

    public LoginDTO(String username, String senha, String captcha) {
        this.username = username;
        this.senha = senha;
        this.captcha = captcha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
