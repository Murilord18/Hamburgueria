package com.hamburgueria.compartilhado.lanche.ponto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PontoCarneTest {

    @Test
    public void malPassadoTempo() {
        assertEquals(120, new MalPassado().tempoCozimentoSegundos());
    }

    @Test
    public void aoPontoTempo() {
        assertEquals(240, new AoPonto().tempoCozimentoSegundos());
    }

    @Test
    public void bemPassadoTempo() {
        assertEquals(360, new BemPassado().tempoCozimentoSegundos());
    }

    @Test
    public void estrategiaIntercambiavelPelaInterface() {
        PontoCarne ponto = new BemPassado();
        assertEquals("bem passado", ponto.descricao());
    }
}
