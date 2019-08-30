package com.stefanini.herois.duelo.entity;

import com.stefanini.herois.generico.entity.AbstractEntity;
import com.stefanini.herois.partida.entity.Partida;
import com.stefanini.herois.personagem.Habilidade;
import com.stefanini.herois.personagem.entity.Personagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Duelo extends AbstractEntity {

    @ManyToOne(optional = false)
    private Partida partida;

    @ManyToOne(optional = false)
    private Personagem personagemUm;

    @ManyToOne(optional = false)
    private Personagem personagemDois;

    @ManyToOne(optional = false)
    private Personagem ganhador;

    @Column(nullable = false)
    private Habilidade habilidadeComparada;

    public Duelo(Personagem personagemUm, Personagem personagemDois) {
        this.personagemUm = personagemUm;
        this.personagemDois = personagemDois;
    }
}
