package com.stefanini.herois.personagem.service;

import com.stefanini.herois.csv.CarregadorCSV;
import com.stefanini.herois.personagem.dao.PersonagemDAO;
import com.stefanini.herois.personagem.entity.Personagem;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Stateless
public class PersonagemService {

    @Inject
    private PersonagemDAO personagemDAO;

    @Inject
    private CarregadorCSV<List<Personagem>> personagemCarregadorCSV;

    public List<Personagem> listaTodos() {
        return personagemDAO.listaTodos();
    }

    public void persisteDadosCSV() throws IOException {
        personagemCarregadorCSV.carregaCSV().forEach(personagem -> personagemDAO.insere(personagem));
    }

    public Personagem novoPersonagem(Personagem personagem) {
        personagemDAO.insere(personagem);
        return personagem;
    }
}
