package com.hamburgueria.online.notificacao;

import com.hamburgueria.compartilhado.notificacao.ObservadorPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public final class ClienteObservador implements ObservadorPedido {

    private final String nomeCliente;
    private final List<String> mensagensRecebidas = new ArrayList<>();

    public ClienteObservador(String nomeCliente) {
        this.nomeCliente = Objects.requireNonNull(nomeCliente, "nomeCliente");
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    @Override
    public void atualizar(Pedido pedido) {
        mensagensRecebidas.add(pedido.getId() + ":" + pedido.getEstado().nome());
    }

    public List<String> getMensagensRecebidas() {
        return Collections.unmodifiableList(mensagensRecebidas);
    }

    public int quantidadeMensagens() {
        return mensagensRecebidas.size();
    }
}
