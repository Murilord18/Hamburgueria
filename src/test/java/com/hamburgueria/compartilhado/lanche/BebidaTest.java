package com.hamburgueria.compartilhado.lanche;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BebidaTest {

    @Test
    public void bebidaNaoExigePreparo() {
        assertFalse(new Bebida("Coca-Cola", new BigDecimal("7.00"), 350).exigePreparo());
    }

    @Test
    public void preparoVazioParaBebida() {
        assertTrue(new Bebida("Coca-Cola", new BigDecimal("7.00"), 350).preparo().isEmpty());
    }

    @Test
    public void descricaoMostraVolume() {
        assertEquals("Coca-Cola (350ml)", new Bebida("Coca-Cola", new BigDecimal("7.00"), 350).descricao());
    }

    @Test
    public void mantemPreco() {
        assertEquals(new BigDecimal("7.00"), new Bebida("Coca-Cola", new BigDecimal("7.00"), 350).preco());
    }

    @Test
    public void lancheExigePreparo() {
        assertTrue(new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir().exigePreparo());
    }
}
