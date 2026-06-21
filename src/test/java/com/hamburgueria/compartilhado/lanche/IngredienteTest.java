package com.hamburgueria.compartilhado.lanche;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IngredienteTest {

    @Test
    public void exposicaoDeNome() {
        assertEquals("pao", new Ingrediente("pao", new BigDecimal("2.00")).getNome());
    }

    @Test
    public void igualdadePorValor() {
        assertTrue(new Ingrediente("pao", new BigDecimal("2.00")).equals(new Ingrediente("pao", new BigDecimal("2.00"))));
    }

    @Test
    public void diferenteQuandoNomeMuda() {
        assertFalse(new Ingrediente("pao", new BigDecimal("2.00")).equals(new Ingrediente("blend", new BigDecimal("2.00"))));
    }

    @Test
    public void hashCodeConsistenteComEquals() {
        assertEquals(new Ingrediente("pao", new BigDecimal("2.00")).hashCode(), new Ingrediente("pao", new BigDecimal("2.00")).hashCode());
    }
}
