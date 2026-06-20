package com.hamburgueria.compartilhado.pedido.memento;

import java.util.ArrayDeque;
import java.util.Deque;


public final class HistoricoPedido {

    private final Deque<PedidoMemento> pilha = new ArrayDeque<>();

    public void salvar(PedidoMemento memento) {
        pilha.push(memento);
    }

    public PedidoMemento desfazer() {
        return pilha.pop();
    }

    public boolean temHistorico() {
        return !pilha.isEmpty();
    }

    public int tamanho() {
        return pilha.size();
    }
}
