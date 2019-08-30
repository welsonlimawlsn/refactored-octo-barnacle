package com.stefanini.herois.personagem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NovoPersonagemDTO {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String alinhamento;

    @NotNull
    private Integer inteligencia;

    @NotNull
    private Integer forca;

    @NotNull
    private Integer destreza;

    @NotNull
    private Integer poder;

    @NotNull
    private Integer combate;

    @NotNull
    private Integer defesa;
}
