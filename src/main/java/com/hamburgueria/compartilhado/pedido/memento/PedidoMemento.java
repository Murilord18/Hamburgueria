package com.hamburgueria.compartilhado.pedido.memento;

import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.estado.EstadoPedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class PedidoMemento {

    private final EstadoPedido estado;
    private final List<ItemPedido> itens;

    public PedidoMemento(EstadoPedido estado, List<ItemPedido> itens) {
        this.estado = estado;
        this.itens = new ArrayList<>(itens);
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }
}
