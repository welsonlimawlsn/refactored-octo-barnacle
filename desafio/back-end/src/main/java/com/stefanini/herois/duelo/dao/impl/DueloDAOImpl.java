package com.stefanini.herois.duelo.dao.impl;

import com.stefanini.herois.duelo.dao.DueloDAO;
import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.generico.dao.impl.GenericDAOImpl;
import com.stefanini.herois.partida.entity.Partida;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class DueloDAOImpl extends GenericDAOImpl<Duelo> implements DueloDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public DueloDAOImpl() {
        super(Duelo.class);
    }

    @Override
    public List<Duelo> procuraPorPartida(Partida partida) {
        TypedQuery<Duelo> duelos = entityManager.createQuery("SELECT d FROM Duelo d where d.partida = :partida", Duelo.class)
                .setParameter("partida", partida);
        return duelos.getResultList();
    }
}
