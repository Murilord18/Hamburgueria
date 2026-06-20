package com.hamburgueria.compartilhado.lanche;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class LancheTest {

    private FabricaIngredientes fabrica;
    private Lanche original;

    @Before
    public void preparar() {
        fabrica = new FabricaIngredientes();
        original = new LancheBuilder()
                .comNome("X")
                .comPrecoBase(new BigDecimal("10.00"))
                .adicionarIngrediente(fabrica.obter("pao", new BigDecimal("2.00")))
                .construir();
    }

    @Test
    public void cloneNaoEhMesmaInstancia() {
        assertNotSame(original, original.clonar());
    }

    @Test
    public void cloneMantemPreco() {
        assertEquals(original.preco(), original.clonar().preco());
    }

    @Test
    public void alterarCloneNaoAfetaOriginal() {
        Lanche copia = original.clonar();
        copia.adicionarIngrediente(fabrica.obter("bacon", new BigDecimal("5.00")));
        assertEquals(1, original.getIngredientes().size());
    }

    @Test
    public void cloneRecebeIngredienteNovo() {
        Lanche copia = original.clonar();
        copia.adicionarIngrediente(fabrica.obter("bacon", new BigDecimal("5.00")));
        assertEquals(2, copia.getIngredientes().size());
    }
}
