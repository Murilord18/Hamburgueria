package com.hamburgueria.compartilhado.cozinha;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.Bebida;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CozinhaPreparoTest {

    private static final int ETAPAS_POR_COMIDA = 4;

    private Cozinha cozinha;

    @Before
    public void preparar() {
        cozinha = Cozinha.obterInstancia();
        cozinha.limparFila();
    }

    @Test
    public void preparaComidaGerandoEtapas() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(new ItemPedido(
                new LancheBuilder().comNome("X").comPrecoBase(new BigDecimal("10.00")).construir(), 1));
        List<String> etapas = cozinha.prepararComidas(p);
        assertEquals(ETAPAS_POR_COMIDA, etapas.size());
    }

    @Test
    public void bebidaNaoGeraEtapas() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(new ItemPedido(new Bebida("Coca-Cola", new BigDecimal("7.00"), 350), 1));
        assertTrue(cozinha.prepararComidas(p).isEmpty());
    }

    @Test
    public void pedidoMistoPreparaApenasAComida() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir(), 1));
        p.adicionarItem(new ItemPedido(new Bebida("Agua", new BigDecimal("4.00"), 500), 1));
        assertEquals(ETAPAS_POR_COMIDA, cozinha.prepararComidas(p).size());
    }

    @Test
    public void lancheComumUsaReceitaDeHamburguer() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir(), 1));
        assertEquals("grelhando o blend", cozinha.prepararComidas(p).get(2));
    }

    @Test
    public void lancheVegetarianoUsaReceitaVegetariana() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).comoVegetariano().construir(), 1));
        assertEquals("embalando em caixa biodegradavel", cozinha.prepararComidas(p).get(3));
    }

    @Test
    public void etapasFicamRegistradasPorPedido() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir(), 1));
        cozinha.prepararComidas(p);
        assertEquals(ETAPAS_POR_COMIDA, cozinha.etapasPreparo("P1").size());
    }
}
