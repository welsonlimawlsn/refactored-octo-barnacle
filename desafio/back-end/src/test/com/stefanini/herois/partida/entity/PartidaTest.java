package com.stefanini.herois.partida.entity;

import com.stefanini.herois.duelo.entity.Duelo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PartidaTest {

    private Partida partida;
    private Duelo duelo;

    @Before
    public void setUp() throws Exception {
        partida = new Partida();
        duelo = new Duelo();
        duelo.setId("1");
    }

    @Test
    public void addDueloDeveAdicionarUmNovoDueloAPartida() {
        partida.addDuelo(duelo);

        Assert.assertTrue(partida.getDuelos().contains(duelo));
    }
}
