package com.hamburgueria.compartilhado.fabrica.lanche;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;
import com.hamburgueria.compartilhado.lanche.Lanche;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CriadorLancheTest {

    private FabricaIngredientes fabrica;

    @Before
    public void preparar() {
        fabrica = new FabricaIngredientes();
    }

    @Test
    public void xBurgerTemNomeCorreto() {
        Lanche l = new CriadorXBurger().produzir(fabrica);
        assertEquals("X-Burger", l.getNome());
    }

    @Test
    public void xBurgerSomaPreco() {
        Lanche l = new CriadorXBurger().produzir(fabrica);
        assertEquals(new BigDecimal("28.00"), l.preco());
    }

    @Test
    public void xSaladaTemNomeCorreto() {
        assertEquals("X-Salada", new CriadorXSalada().produzir(fabrica).getNome());
    }

    @Test
    public void produzirAplicaPontoPadrao() {
        Lanche l = new CriadorXBurger().produzir(fabrica);
        assertEquals("ao ponto", l.getPonto().descricao());
    }
}
