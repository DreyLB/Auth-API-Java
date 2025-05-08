package com.seguranca.autentication.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@Service
public class LogService {

    public void registrar(String mensagem) {
        try (PrintWriter out = new PrintWriter(new FileWriter("log.txt", true))) {
            out.println(LocalDateTime.now() + " - " + mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
