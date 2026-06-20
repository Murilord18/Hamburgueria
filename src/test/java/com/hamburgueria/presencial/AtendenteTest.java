package com.hamburgueria.presencial;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.cozinha.Cozinha;
import com.hamburgueria.compartilhado.lanche.Bebida;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import com.hamburgueria.compartilhado.mediator.MediadorAtendimento;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtendenteTest {

    private MediadorAtendimento mediador;
    private Atendente atendente;

    @Before
    public void preparar() {
        Cozinha.obterInstancia().limparFila();
        mediador = new MediadorAtendimento(Cozinha.obterInstancia());
        atendente = new Atendente("Joao", mediador);
    }

    private ItemPedido comida() {
        return new ItemPedido(new LancheBuilder().comNome("X").comPrecoBase(new BigDecimal("10.00")).construir(), 1);
    }

    private ItemPedido bebida() {
        return new ItemPedido(new Bebida("Coca-Cola", new BigDecimal("7.00"), 350), 1);
    }

    @Test
    public void comidaVaiParaCozinha() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(comida());
        atendente.atenderPedido(p);
        assertEquals(1, Cozinha.obterInstancia().tamanhoFila());
    }

    @Test
    public void bebidaNaoVaiParaCozinha() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(bebida());
        atendente.atenderPedido(p);
        assertEquals(0, Cozinha.obterInstancia().tamanhoFila());
    }

    @Test
    public void garcomEntregaBebidaNaHora() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(bebida());
        assertEquals(1, atendente.atenderPedido(p).size());
    }

    @Test
    public void mensagemDeEntregaIdentificaGarcomEBebida() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(bebida());
        assertEquals("Joao entregou Coca-Cola (350ml)", atendente.atenderPedido(p).get(0));
    }

    @Test
    public void pedidoMistoEnviaComidaEEntregaBebida() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(comida());
        p.adicionarItem(bebida());
        int entregasDiretas = atendente.atenderPedido(p).size();
        assertEquals(1, entregasDiretas);
    }

    @Test
    public void pedidoMistoTambemVaiParaCozinha() {
        Pedido p = new Pedido("P1");
        p.adicionarItem(comida());
        p.adicionarItem(bebida());
        atendente.atenderPedido(p);
        assertEquals(1, Cozinha.obterInstancia().tamanhoFila());
    }

    @Test
    public void atendenteMantemNome() {
        assertEquals("Joao", atendente.getNome());
    }
}
