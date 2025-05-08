package com.seguranca.autentication.controller.dto;

public record LoginResponse(String acessToken, Long expiresIn) {
}
