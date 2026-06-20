package com.hamburgueria.compartilhado.pedido;

import java.util.List;
import java.util.NoSuchElementException;

//Iterator
public final class IteradorItensPedido implements java.util.Iterator<ItemPedido> {

    private static final int POSICAO_INICIAL = 0;

    private final List<ItemPedido> itens;
    private int posicao = POSICAO_INICIAL;

    public IteradorItensPedido(List<ItemPedido> itens) {
        this.itens = itens;
    }

    @Override
    public boolean hasNext() {
        return posicao < itens.size();
    }

    @Override
    public ItemPedido next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Nao ha mais itens no pedido");
        }
        ItemPedido atual = itens.get(posicao);
        posicao++;
        return atual;
    }
}
