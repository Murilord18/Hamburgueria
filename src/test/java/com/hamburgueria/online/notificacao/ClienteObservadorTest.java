package com.hamburgueria.online.notificacao;

import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteObservadorTest {

    private Pedido pedido;

    @Before
    public void preparar() {
        pedido = new Pedido("P1");
    }

    @Test
    public void clienteRecebeMensagemAoAvancar() {
        ClienteObservador cliente = new ClienteObservador("Ana");
        pedido.registrar(cliente);
        pedido.avancarEstado();
        assertEquals(1, cliente.quantidadeMensagens());
    }

    @Test
    public void mensagemContemEstadoAtual() {
        ClienteObservador cliente = new ClienteObservador("Ana");
        pedido.registrar(cliente);
        pedido.avancarEstado();
        assertEquals("P1:EM_PREPARO", cliente.getMensagensRecebidas().get(0));
    }

    @Test
    public void clienteMantemNome() {
        assertEquals("Ana", new ClienteObservador("Ana").getNomeCliente());
    }

    @Test
    public void painelRegistraHistoricoDeEstados() {
        PainelCozinhaObservador painel = new PainelCozinhaObservador();
        pedido.registrar(painel);
        pedido.avancarEstado();
        pedido.avancarEstado();
        assertEquals(2, painel.getHistorico().size());
    }

    @Test
    public void multiplosObservadoresRecebem() {
        ClienteObservador cliente = new ClienteObservador("Ana");
        PainelCozinhaObservador painel = new PainelCozinhaObservador();
        pedido.registrar(cliente);
        pedido.registrar(painel);
        pedido.avancarEstado();
        assertEquals(1, cliente.quantidadeMensagens());
    }
}
