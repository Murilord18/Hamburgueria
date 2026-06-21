package com.hamburgueria.compartilhado.lanche;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class FabricaIngredientesTest {

    private FabricaIngredientes fabrica;

    @Before
    public void preparar() {
        fabrica = new FabricaIngredientes();
    }

    @Test
    public void devolveMesmaInstanciaParaMesmoNome() {
        Ingrediente a = fabrica.obter("queijo", new BigDecimal("3.00"));
        Ingrediente b = fabrica.obter("queijo", new BigDecimal("3.00"));
        assertSame(a, b);
    }

    @Test
    public void naoDuplicaIngredienteNoCache() {
        fabrica.obter("queijo", new BigDecimal("3.00"));
        fabrica.obter("queijo", new BigDecimal("3.00"));
        fabrica.obter("bacon", new BigDecimal("5.00"));
        assertEquals(2, fabrica.quantidadeDistintaCriada());
    }

    @Test
    public void mantemCustoDoIngrediente() {
        Ingrediente bacon = fabrica.obter("bacon", new BigDecimal("5.00"));
        assertEquals(new BigDecimal("5.00"), bacon.getCusto());
    }
}
