package com.stefanini.herois.generico.dao.impl;

import com.stefanini.herois.generico.dao.GenericDAO;
import com.stefanini.herois.generico.entity.AbstractEntity;
import com.stefanini.herois.util.GeradorId;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class GenericDAOImpl<E extends AbstractEntity> implements GenericDAO<E> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<E> aClass;

    public GenericDAOImpl(Class<E> aClass) {
        this.aClass = aClass;
    }

    @Override
    public void insere(E entity) {
        try {
            entityManager.persist(entity);
        } catch (EntityExistsException e) {
            entity.setId(GeradorId.gerar());
            insere(entity);
        }
    }

    @Override
    public List<E> listaTodos() {
        return entityManager.createQuery("SELECT e FROM " + aClass.getSimpleName() + " e", aClass).getResultList();
    }

    @Override
    public Optional<E> procuraPorId(String id) {
        return Optional.ofNullable(entityManager.find(aClass, id));
    }
}
