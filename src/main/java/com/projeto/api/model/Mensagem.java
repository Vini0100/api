package com.projeto.api.model;

import org.springframework.stereotype.Component;

@Component // Isto será lido no momento do start no Spring
public class Mensagem {

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
