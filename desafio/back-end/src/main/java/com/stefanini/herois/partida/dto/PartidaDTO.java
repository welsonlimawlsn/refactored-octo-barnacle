package com.stefanini.herois.partida.dto;

import com.stefanini.herois.personagem.entity.Personagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDTO {

    private String id;

    private Personagem heroiMutante;

    private Personagem ganhador;
}
