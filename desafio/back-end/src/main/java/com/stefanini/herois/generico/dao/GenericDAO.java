package com.stefanini.herois.generico.dao;

import com.stefanini.herois.generico.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<E extends AbstractEntity> {

    void insere(E entity);

    List<E> listaTodos();

    Optional<E> procuraPorId(String id);
}
