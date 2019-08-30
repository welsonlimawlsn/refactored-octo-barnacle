package com.stefanini.herois.partida.service;

import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.duelo.service.DueloService;
import com.stefanini.herois.excecao.DueloImpossivelException;
import com.stefanini.herois.excecao.MensagemErro;
import com.stefanini.herois.excecao.NotFoundException;
import com.stefanini.herois.partida.dao.PartidaDAO;
import com.stefanini.herois.partida.entity.Partida;
import com.stefanini.herois.personagem.entity.Personagem;
import com.stefanini.herois.personagem.service.PersonagemService;
import com.stefanini.herois.util.RandomUtil;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class PartidaService {


    @EJB
    private PersonagemService personagemService;

    @EJB
    private DueloService dueloService;

    @Inject
    private PartidaDAO partidaDAO;

    private List<Personagem> personagens;

    public Partida novaPartida() {
        personagens = personagemService.listaTodos();

        Partida partida = new Partida();

        Set<Personagem> heroisVitoriosos = new HashSet<>();

        Personagem heroiVitorioso = randomizaPersonagem();

        Personagem rival = escolheHeroiRival(heroiVitorioso);

        while (partida.getDuelos().size() < 10) {
            try {
                Duelo duelo = dueloService.novoDuelo(partida, heroiVitorioso, rival);
                heroiVitorioso = duelo.getGanhador();
                heroisVitoriosos.add(heroiVitorioso);
                partida.addDuelo(duelo);
                rival = escolheHeroiRival(heroiVitorioso);
            } catch (DueloImpossivelException e) {
                rival = escolheHeroiRival(heroiVitorioso);
            }
        }

        List<Personagem> listaOrdenada = ordenaPorNumeroDeVitorias(heroisVitoriosos);

        Personagem ganhador = listaOrdenada.get(0);

        Personagem heroiMutante;

        if (listaOrdenada.size() >= 2) {
            heroiMutante = criaHeroiMutante(ganhador, listaOrdenada.get(1));
        } else {
            heroiMutante = ganhador;
        }

        partida.setHeroiMutante(heroiMutante);
        partida.setGanhador(ganhador);

        partidaDAO.insere(partida);

        return partida;
    }

    private Personagem escolheHeroiRival(Personagem heroiVitorioso) {
        Personagem rival = randomizaPersonagem();
        while (heroiVitorioso.equals(rival) || heroiVitorioso.getAlinhamento().equals(rival.getAlinhamento())) {
            rival = randomizaPersonagem();
        }
        return rival;
    }

    private Personagem randomizaPersonagem() {
        int size = personagens.size();
        return personagens.get(RandomUtil.sorteaNumero(size));
    }

    private Personagem criaHeroiMutante(Personagem heroiVitorioso, Personagem segundoLugar) {

        Personagem heroiMutante = copiaHeroi(heroiVitorioso);
        heroiMutante.setNome(heroiMutante.getNome() + " Mutante");
        heroiMutante.combinaHabilidades(segundoLugar);

        return heroiMutante;
    }

    private ArrayList<Personagem> ordenaPorNumeroDeVitorias(Set<Personagem> heroisVitoriosos) {
        ArrayList<Personagem> heroisVitoriososOrdenados = new ArrayList<>(heroisVitoriosos);
        heroisVitoriososOrdenados.sort((o1, o2) -> -o1.getNumeroDeVitorias().compareTo(o2.getNumeroDeVitorias()));
        return heroisVitoriososOrdenados;
    }

    private Personagem copiaHeroi(Personagem personagem) {
        Personagem heroiCopiado = new Personagem();

        heroiCopiado.setAlinhamento(personagem.getAlinhamento());
        heroiCopiado.setCombate(personagem.getCombate());
        heroiCopiado.setDefesa(personagem.getDefesa());
        heroiCopiado.setDestreza(personagem.getDestreza());
        heroiCopiado.setForca(personagem.getForca());
        heroiCopiado.setInteligencia(personagem.getInteligencia());
        heroiCopiado.setPoder(personagem.getPoder());
        heroiCopiado.setNome(personagem.getNome());

        return heroiCopiado;
    }

    public Partida procuraPorId(String id) throws NotFoundException {
        return partidaDAO.procuraPorId(id).orElseThrow(() -> new NotFoundException(MensagemErro.PARTIDA_NAO_ENCONTRADA));
    }

    public List<Duelo> duelosPorPartida(String idPartida) throws NotFoundException {
        return dueloService.procuraPorPartida(procuraPorId(idPartida));
    }

    public List<Partida> listaTodas() {
        return partidaDAO.listaTodos();
    }
}
