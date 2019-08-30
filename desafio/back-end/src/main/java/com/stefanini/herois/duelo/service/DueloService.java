package com.stefanini.herois.duelo.service;

import com.stefanini.herois.duelo.dao.DueloDAO;
import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.excecao.DueloImpossivelException;
import com.stefanini.herois.excecao.EmpateException;
import com.stefanini.herois.partida.entity.Partida;
import com.stefanini.herois.personagem.Habilidade;
import com.stefanini.herois.personagem.entity.Personagem;
import com.stefanini.herois.util.RandomUtil;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DueloService {

    @Inject
    private DueloDAO dueloDAO;

    public Duelo novoDuelo(Partida partida, Personagem heroiUm, Personagem heroiDois) throws DueloImpossivelException {

        Duelo duelo = new Duelo(heroiUm, heroiDois);
        duelo.setHabilidadeComparada(randomizaHabilidade());
        duelo.setPartida(partida);

        try {
            Personagem ganhador = heroiUm.duela(heroiDois, duelo.getHabilidadeComparada());
            duelo.setGanhador(ganhador);
        } catch (EmpateException e) {
            return novoDuelo(partida, heroiUm, heroiDois);
        }
        return duelo;
    }

    private Habilidade randomizaHabilidade() {
        int index = RandomUtil.sorteaNumero(Habilidade.values().length);
        return Habilidade.values()[index];
    }

    public List<Duelo> procuraPorPartida(Partida partida) {
        return dueloDAO.procuraPorPartida(partida);
    }
}
