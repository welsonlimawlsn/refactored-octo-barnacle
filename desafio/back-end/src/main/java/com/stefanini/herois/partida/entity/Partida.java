package com.stefanini.herois.partida.entity;

import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.generico.entity.AbstractEntity;
import com.stefanini.herois.personagem.entity.Personagem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Partida extends AbstractEntity {

    @OneToMany(mappedBy = "partida", cascade = CascadeType.PERSIST)
    private List<Duelo> duelos;

    @OneToOne(optional = false, cascade = CascadeType.PERSIST)
    private Personagem heroiMutante;

    @ManyToOne(optional = false)
    private Personagem ganhador;

    public Partida() {
        duelos = new ArrayList<>();
    }

    public void addDuelo(Duelo duelo) {
        duelos.add(duelo);
    }
}
