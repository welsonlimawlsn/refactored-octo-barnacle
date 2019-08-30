package com.stefanini.herois.excecao;

import lombok.Getter;

import javax.ws.rs.core.Response;

@Getter
public class RestException extends Exception {

    private Response.Status status;

    public RestException(String message, Response.Status status) {
        super(message);
        this.status = status;
    }

    public RestException(MensagemErro mensagemErro, Response.Status status) {
        super(mensagemErro.getMensagem());
        this.status = status;
    }
}
