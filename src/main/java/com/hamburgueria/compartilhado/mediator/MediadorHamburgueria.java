package com.hamburgueria.compartilhado.mediator;

import com.hamburgueria.compartilhado.pedido.Pedido;


public interface MediadorHamburgueria {
    void registrarPedido(Pedido pedido);
    void avancarPedido(Pedido pedido);
}
