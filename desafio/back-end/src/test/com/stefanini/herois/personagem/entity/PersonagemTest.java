package com.stefanini.herois.personagem.entity;

import com.stefanini.herois.excecao.DueloImpossivelException;
import com.stefanini.herois.excecao.EmpateException;
import com.stefanini.herois.personagem.Habilidade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class PersonagemTest {

    private Personagem personagemUm;
    private Personagem personagemDois;

    @Before
    public void setUp() {
        personagemUm = new Personagem("Welson", "bom", 1, 1, 1, 1, 1, 1, 3);
        personagemUm.setId("1");

        personagemDois = new Personagem("Wilson", "neutro", 1, 2, 1, 1, 1, 1, 4);
        personagemDois.setId("2");
    }

    @Test
    public void duelaComPersonagensComHabilidadesIguaisDeveLancarExcecao() {
        personagemDois.setForca(1);
        try {
            personagemUm.duela(personagemDois, Habilidade.COMBATE);
            fail();
        } catch (EmpateException | DueloImpossivelException e) {
            if (!(e instanceof DueloImpossivelException)) {
                fail();
            }
        }
    }

    @Test
    public void duelaCaseDeEmpateDeveLancarExcecao() {
        try {
            personagemUm.duela(personagemDois, Habilidade.INTELIGENCIA);
            fail();
        } catch (EmpateException | DueloImpossivelException e) {
            if (!(e instanceof EmpateException)) {
                fail();
            }
        }
    }

    @Test
    public void duelaDeveDefinirTodosOsAtributosCorretamenteSituacaoUm() {
        try {
            Personagem ganhador = personagemUm.duela(personagemDois, Habilidade.FORCA);

            assertEquals(personagemDois, ganhador);
            assertEquals(Integer.valueOf(4), personagemDois.getForca());
            assertEquals(Integer.valueOf(0), personagemUm.getForca());
            assertEquals(Integer.valueOf(5), personagemDois.getNumeroDeVitorias());
            assertEquals(Integer.valueOf(3), personagemUm.getNumeroDeVitorias());

        } catch (EmpateException | DueloImpossivelException e) {
            fail();
        }
    }

    @Test
    public void duelaDeveDefinirTodosOsAtributosCorretamenteSituacaoDois() {
        personagemUm.setPoder(5);
        personagemDois.setPoder(4);
        try {
            Personagem ganhador = personagemUm.duela(personagemDois, Habilidade.PODER);

            assertEquals(personagemUm, ganhador);
            assertEquals(Integer.valueOf(2), personagemDois.getPoder());
            assertEquals(Integer.valueOf(7), personagemUm.getPoder());
            assertEquals(Integer.valueOf(4), personagemDois.getNumeroDeVitorias());
            assertEquals(Integer.valueOf(4), personagemUm.getNumeroDeVitorias());

        } catch (EmpateException | DueloImpossivelException e) {
            fail();
        }
    }

    @Test
    public void combinaHabilidadesDeveDefinirOsValoresCertos() {
        personagemUm = new Personagem("Welson", "bom", 50, 40, 60, 80, 10, 35, 0);
        personagemDois = new Personagem("Welson", "bom", 40, 70, 60, 79, 15, 35, 0);

        personagemUm.combinaHabilidades(personagemDois);

        assertEquals(Integer.valueOf(50), personagemUm.getInteligencia());
        assertEquals(Integer.valueOf(70), personagemUm.getForca());
        assertEquals(Integer.valueOf(60), personagemUm.getDestreza());
        assertEquals(Integer.valueOf(80), personagemUm.getPoder());
        assertEquals(Integer.valueOf(15), personagemUm.getCombate());
        assertEquals(Integer.valueOf(35), personagemUm.getDefesa());
    }

}
