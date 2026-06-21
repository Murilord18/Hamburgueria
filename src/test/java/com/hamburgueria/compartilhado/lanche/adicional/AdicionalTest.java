package com.hamburgueria.compartilhado.lanche.adicional;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.Comestivel;
import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;
import com.hamburgueria.compartilhado.lanche.Lanche;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdicionalTest {

    private Lanche base;

    @Before
    public void preparar() {
        FabricaIngredientes f = new FabricaIngredientes();
        base = new LancheBuilder().comNome("X").comPrecoBase(new BigDecimal("10.00"))
                .adicionarIngrediente(f.obter("pao", new BigDecimal("2.00"))).construir();
    }

    @Test
    public void queijoExtraSomaPreco() {
        Comestivel comQueijo = new QueijoExtra(base);
        assertEquals(new BigDecimal("15.00"), comQueijo.preco());
    }

    @Test
    public void blendExtraSomaPreco() {
        Comestivel comBlend = new BlendExtra(base);
        assertEquals(new BigDecimal("19.00"), comBlend.preco());
    }

    @Test
    public void baconExtraSomaPreco() {
        assertEquals(new BigDecimal("17.00"), new BaconExtra(base).preco());
    }

    @Test
    public void decoradoresEmpilhamPreco() {
        Comestivel duplo = new QueijoExtra(new BlendExtra(base));
        assertEquals(new BigDecimal("22.00"), duplo.preco());
    }

    @Test
    public void decoradorAcrescentaDescricao() {
        Comestivel comQueijo = new QueijoExtra(base);
        assertEquals("X, pao + fatia de queijo", comQueijo.descricao());
    }
}
