package com.stefanini.herois.excecao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestExceptionMapper implements ExceptionMapper<RestException> {
    @Override
    public Response toResponse(RestException exception) {
        return Response.status(exception.getStatus()).entity(new Erro(exception.getMessage(), exception.getStatus())).build();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Erro {
        private String messagem;
        private Response.Status status;
    }
}
