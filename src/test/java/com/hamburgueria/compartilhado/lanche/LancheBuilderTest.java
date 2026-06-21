package com.hamburgueria.compartilhado.lanche;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.ponto.AoPonto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LancheBuilderTest {

    @Test
    public void somaPrecoBaseComIngredientes() {
        FabricaIngredientes f = new FabricaIngredientes();
        Lanche lanche = new LancheBuilder()
                .comNome("X-Burger")
                .comPrecoBase(new BigDecimal("15.00"))
                .adicionarIngrediente(f.obter("pao", new BigDecimal("2.00")))
                .adicionarIngrediente(f.obter("blend", new BigDecimal("8.00")))
                .construir();
        assertEquals(new BigDecimal("25.00"), lanche.preco());
    }

    @Test
    public void aplicaNome() {
        Lanche lanche = new LancheBuilder().comNome("X-Tudo").construir();
        assertEquals("X-Tudo", lanche.getNome());
    }

    @Test
    public void aplicaPonto() {
        Lanche lanche = new LancheBuilder().comPonto(new AoPonto()).construir();
        assertEquals("ao ponto", lanche.getPonto().descricao());
    }
}
