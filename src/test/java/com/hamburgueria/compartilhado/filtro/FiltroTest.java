package com.hamburgueria.compartilhado.filtro;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FiltroTest {

    private ContextoItem itemBarato;
    private ContextoItem itemCaro;

    @Before
    public void preparar() {
        Set<String> ingredientes = new HashSet<>();
        ingredientes.add("queijo");
        itemBarato = criar(new BigDecimal("15.00"), true, 400, ingredientes);
        itemCaro = criar(new BigDecimal("40.00"), false, 900, ingredientes);
    }

    private ContextoItem criar(BigDecimal preco, boolean veg, int cal, Set<String> ing) {
        return new ContextoItem() {
            public BigDecimal preco() { return preco; }
            public boolean vegetariano() { return veg; }
            public int calorias() { return cal; }
            public boolean contemIngrediente(String n) { return ing.contains(n); }
        };
    }

    @Test
    public void precoMaximoAceitaBarato() {
        assertTrue(new FiltroPrecoMaximo(new BigDecimal("20.00")).interpretar(itemBarato));
    }

    @Test
    public void precoMaximoRejeitaCaro() {
        assertFalse(new FiltroPrecoMaximo(new BigDecimal("20.00")).interpretar(itemCaro));
    }

    @Test
    public void vegetarianoAceitaVeg() {
        assertTrue(new FiltroVegetariano().interpretar(itemBarato));
    }

    @Test
    public void caloriasMaximasFiltra() {
        assertTrue(new FiltroCaloriasMaximas(500).interpretar(itemBarato));
    }

    @Test
    public void contemIngredienteEncontra() {
        assertTrue(new FiltroContemIngrediente("queijo").interpretar(itemBarato));
    }

    @Test
    public void conjuncaoEExigeAmbos() {
        ExpressaoFiltro filtro = new FiltroE(new FiltroVegetariano(), new FiltroPrecoMaximo(new BigDecimal("20.00")));
        assertTrue(filtro.interpretar(itemBarato));
    }

    @Test
    public void conjuncaoEFalhaSeUmFalha() {
        ExpressaoFiltro filtro = new FiltroE(new FiltroVegetariano(), new FiltroPrecoMaximo(new BigDecimal("20.00")));
        assertFalse(filtro.interpretar(itemCaro));
    }

    @Test
    public void disjuncaoOuAceitaUm() {
        ExpressaoFiltro filtro = new FiltroOu(new FiltroVegetariano(), new FiltroPrecoMaximo(new BigDecimal("10.00")));
        assertTrue(filtro.interpretar(itemBarato));
    }

    @Test
    public void negacaoInverteResultado() {
        assertFalse(new FiltroNao(new FiltroVegetariano()).interpretar(itemBarato));
    }

    @Test
    public void expressaoCompostaComplexa() {
        ExpressaoFiltro filtro = new FiltroE(
                new FiltroContemIngrediente("queijo"),
                new FiltroNao(new FiltroPrecoMaximo(new BigDecimal("10.00"))));
        assertEquals(true, filtro.interpretar(itemBarato));
    }
}
