package com.stefanini.herois.excecao;

import javax.ws.rs.core.Response;

public class NotFoundException extends RestException {

    public NotFoundException(String message) {
        super(message, Response.Status.NOT_FOUND);
    }

    public NotFoundException(MensagemErro mensagemErro) {
        super(mensagemErro, Response.Status.NOT_FOUND);
    }
}
