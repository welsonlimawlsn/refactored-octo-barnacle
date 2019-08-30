package com.stefanini.herois.util;

import com.stefanini.herois.csv.CarregadorCSV;
import com.stefanini.herois.personagem.entity.Personagem;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@ApplicationScoped
public class BancoMemoria {

    @Getter
    private List<Personagem> personagens;

    @Inject
    private CarregadorCSV<List<Personagem>> personagemCSV;

    @PostConstruct
    private void postConstruct() throws IOException {
        personagens = personagemCSV.carregaCSV();
    }

}


