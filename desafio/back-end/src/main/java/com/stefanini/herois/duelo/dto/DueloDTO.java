package com.stefanini.herois.duelo.dto;

import com.stefanini.herois.personagem.Habilidade;
import com.stefanini.herois.personagem.entity.Personagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DueloDTO {

    private Personagem personagemUm;

    private Personagem personagemDois;

    private Personagem ganhador;

    private Habilidade habilidadeComparada;
}
