package com.hamburgueria.compartilhado.pedido.estado;

public final class EstadoEntregue implements EstadoPedido {

    @Override
    public String nome() {
        return "ENTREGUE";
    }

    @Override
    public EstadoPedido avancar() {
        return this;
    }

    @Override
    public boolean podeCancelar() {
        return false;
    }
}
