package com.hamburgueria.compartilhado.validacao;

import com.hamburgueria.compartilhado.pedido.Pedido;

public final class ValidaCancelavel extends ManipuladorPedido {

    @Override
    protected ResultadoValidacao verificar(Pedido pedido) {
        if (!pedido.getEstado().podeCancelar()) {
            return ResultadoValidacao.falha("pedido nao pode ser cancelado");
        }
        return ResultadoValidacao.ok();
    }
}
