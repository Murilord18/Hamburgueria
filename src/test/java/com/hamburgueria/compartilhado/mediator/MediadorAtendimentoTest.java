package com.hamburgueria.compartilhado.mediator;

import com.hamburgueria.compartilhado.cozinha.Cozinha;
import com.hamburgueria.online.notificacao.ClienteObservador;
import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MediadorAtendimentoTest {

    private MediadorAtendimento mediador;
    private ClienteObservador cliente;

    @Before
    public void preparar() {
        Cozinha.obterInstancia().limparFila();
        mediador = new MediadorAtendimento(Cozinha.obterInstancia());
        cliente = new ClienteObservador("Ana");
        mediador.adicionarObservador(cliente);
    }

    @Test
    public void registrarEnviaPedidoACozinha() {
        mediador.registrarPedido(new Pedido("P1"));
        assertEquals(1, Cozinha.obterInstancia().tamanhoFila());
    }

    @Test
    public void registrarConectaObservadorAoPedido() {
        Pedido p = new Pedido("P1");
        mediador.registrarPedido(p);
        assertEquals(1, p.quantidadeObservadores());
    }

    @Test
    public void avancarNotificaCliente() {
        Pedido p = new Pedido("P1");
        mediador.registrarPedido(p);
        mediador.avancarPedido(p);
        assertEquals(1, cliente.quantidadeMensagens());
    }

    @Test
    public void registraEventos() {
        Pedido p = new Pedido("P1");
        mediador.registrarPedido(p);
        mediador.avancarPedido(p);
        assertEquals(2, mediador.getEventos().size());
    }
}
