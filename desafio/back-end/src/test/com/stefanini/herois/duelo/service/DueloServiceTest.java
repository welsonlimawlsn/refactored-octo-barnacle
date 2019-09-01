package com.stefanini.herois.duelo.service;

import com.stefanini.herois.duelo.dao.DueloDAO;
import com.stefanini.herois.duelo.entity.Duelo;
import com.stefanini.herois.excecao.DueloImpossivelException;
import com.stefanini.herois.partida.entity.Partida;
import com.stefanini.herois.personagem.Habilidade;
import com.stefanini.herois.personagem.entity.Personagem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class DueloServiceTest {

    @InjectMocks
    private DueloService dueloService;

    @Mock
    private DueloDAO dueloDAO;

    @Mock
    private List<Duelo> duelos;

    private Partida partida;

    private Personagem personagemUm;

    private Personagem personagemDois;

    @Before
    public void setUp() {
        partida = new Partida();
        partida.setId("1");

        personagemUm = new Personagem("Welson", "bom", 1, 1, 1, 1, 5, 1, 7);

        personagemDois = new Personagem("Wilson", "mal", 1, 1, 1, 1, 3, 1, 1);

        Mockito.when(dueloDAO.procuraPorPartida(partida)).thenReturn(duelos);
    }

    @Test
    public void procuraPorPartidaDeveRetornarUmaListaDeDuelos() {
        List<Duelo> duelos = dueloService.procuraPorPartida(partida);

        assertEquals(this.duelos, duelos);
    }

    @Test
    public void novoDueloDeveRetornarOsValoresCorretos() {
        try {
            Duelo duelo = dueloService.novoDuelo(partida, personagemUm, personagemDois);

            assertEquals(personagemUm, duelo.getPersonagemUm());
            assertEquals(personagemDois, duelo.getPersonagemDois());
            assertEquals(partida, duelo.getPartida());
            assertEquals(personagemUm, duelo.getGanhador());
            assertEquals(Habilidade.COMBATE, duelo.getHabilidadeComparada());

        } catch (DueloImpossivelException e) {
            fail();
        }
    }

    @Test
    public void novoDueloDeveLancarExcecao() {
        personagemDois.setCombate(5);
        try {
            dueloService.novoDuelo(partida, personagemUm, personagemDois);
            fail();
        } catch (DueloImpossivelException e) {
            assertEquals("Impossivel algue ganhar esse duelo", e.getMessage());
        }
    }

}
