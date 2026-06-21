package com.hamburgueria.compartilhado.cozinha.preparo;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreparoLancheTest {

    private static final int TOTAL_ETAPAS = 4;

    @Test
    public void hamburguerTemQuatroEtapas() {
        assertEquals(TOTAL_ETAPAS, new PreparoHamburguer().preparar().size());
    }

    @Test
    public void hamburguerGrelhaOBlend() {
        List<String> etapas = new PreparoHamburguer().preparar();
        assertEquals("grelhando o blend", etapas.get(2));
    }

    @Test
    public void vegetarianoUsaCozinharPadrao() {
        List<String> etapas = new PreparoVegetariano().preparar();
        assertEquals("cozinhando no fogo", etapas.get(2));
    }

    @Test
    public void vegetarianoSobrescreveFinalizar() {
        List<String> etapas = new PreparoVegetariano().preparar();
        assertEquals("embalando em caixa biodegradavel", etapas.get(3));
    }
}
