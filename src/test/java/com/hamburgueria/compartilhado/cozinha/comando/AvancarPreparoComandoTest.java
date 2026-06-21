package com.hamburgueria.compartilhado.cozinha.comando;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.cozinha.Cozinha;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AvancarPreparoComandoTest {

    private Pedido pedido;
    private FilaComandos fila;
    private Cozinha cozinha;

    @Before
    public void preparar() {
        cozinha = Cozinha.obterInstancia();
        cozinha.limparFila();
        pedido = new Pedido("P1");
        pedido.adicionarItem(new ItemPedido(
                new LancheBuilder().comNome("X").comPrecoBase(new BigDecimal("10.00")).construir(), 1));
        fila = new FilaComandos();
    }

    @Test
    public void executarAvancaEstado() {
        fila.executar(new AvancarPreparoComando(pedido, cozinha));
        assertEquals("EM_PREPARO", pedido.getEstado().nome());
    }

    @Test
    public void desfazerVoltaEstado() {
        fila.executar(new AvancarPreparoComando(pedido, cozinha));
        fila.desfazerUltimo();
        assertEquals("RECEBIDO", pedido.getEstado().nome());
    }

    @Test
    public void contaComandosExecutados() {
        fila.executar(new AvancarPreparoComando(pedido, cozinha));
        fila.executar(new AvancarPreparoComando(pedido, cozinha));
        assertEquals(2, fila.quantidadeExecutados());
    }

    @Test
    public void aoEntrarEmPreparoExecutaTemplateMethod() {
        fila.executar(new AvancarPreparoComando(pedido, cozinha));
        assertFalse(cozinha.etapasPreparo("P1").isEmpty());
    }

    @Test
    public void desfazerDescartaEtapasDePreparo() {
        fila.executar(new AvancarPreparoComando(pedido, cozinha));
        fila.desfazerUltimo();
        assertTrue(cozinha.etapasPreparo("P1").isEmpty());
    }
}
