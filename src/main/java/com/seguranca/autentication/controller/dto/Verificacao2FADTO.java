package com.seguranca.autentication.controller.dto;

public class Verificacao2FADTO {
    private String username;
    private String codigo;

    public Verificacao2FADTO(String codigo, String username) {
        this.codigo = codigo;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
