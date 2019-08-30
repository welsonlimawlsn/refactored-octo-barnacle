package com.stefanini.herois.personagem.dao.impl;

import com.stefanini.herois.generico.dao.impl.GenericDAOImpl;
import com.stefanini.herois.personagem.dao.PersonagemDAO;
import com.stefanini.herois.personagem.entity.Personagem;

public class PersonagemDAOImpl extends GenericDAOImpl<Personagem> implements PersonagemDAO {

    public PersonagemDAOImpl() {
        super(Personagem.class);
    }

}
