package com.stefanini.herois.duelo.dao;

import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.generico.dao.GenericDAO;
import com.stefanini.herois.partida.entity.Partida;

import java.util.List;

public interface DueloDAO extends GenericDAO<Duelo> {

    List<Duelo> procuraPorPartida(Partida partida);
}
