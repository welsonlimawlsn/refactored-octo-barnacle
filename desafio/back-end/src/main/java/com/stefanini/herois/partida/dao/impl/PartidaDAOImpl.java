package com.stefanini.herois.partida.dao.impl;

import com.stefanini.herois.generico.dao.impl.GenericDAOImpl;
import com.stefanini.herois.partida.dao.PartidaDAO;
import com.stefanini.herois.partida.entity.Partida;

public class PartidaDAOImpl extends GenericDAOImpl<Partida> implements PartidaDAO {

    public PartidaDAOImpl() {
        super(Partida.class);
    }
}
