package com.stefanini.herois.excecao;

import lombok.Getter;

@Getter
public enum MensagemErro {

    PARTIDA_NAO_ENCONTRADA("Partida não encontrada!");

    private String mensagem;

    MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }
}
