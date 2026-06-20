package com.hamburgueria.online.notificacao;

import com.hamburgueria.compartilhado.notificacao.ObservadorPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class PainelCozinhaObservador implements ObservadorPedido {

    private final List<String> historico = new ArrayList<>();

    @Override
    public void atualizar(Pedido pedido) {
        historico.add(pedido.getEstado().nome());
    }

    public List<String> getHistorico() {
        return Collections.unmodifiableList(historico);
    }
}
