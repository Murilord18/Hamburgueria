package com.hamburgueria.compartilhado.pedido.estado;

public final class EstadoPronto implements EstadoPedido {

    @Override
    public String nome() {
        return "PRONTO";
    }

    @Override
    public EstadoPedido avancar() {
        return new EstadoEntregue();
    }

    @Override
    public boolean podeCancelar() {
        return false;
    }
}
