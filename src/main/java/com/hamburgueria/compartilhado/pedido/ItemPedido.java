package com.hamburgueria.compartilhado.pedido;

import com.hamburgueria.compartilhado.lanche.Comestivel;

import java.math.BigDecimal;
import java.util.Objects;

public final class ItemPedido {

    private final Comestivel comestivel;
    private final int quantidade;

    public ItemPedido(Comestivel comestivel, int quantidade) {
        this.comestivel = Objects.requireNonNull(comestivel, "comestivel");
        this.quantidade = quantidade;
    }

    public Comestivel getComestivel() {
        return comestivel;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal subtotal() {
        return comestivel.preco().multiply(BigDecimal.valueOf(quantidade));
    }
}
