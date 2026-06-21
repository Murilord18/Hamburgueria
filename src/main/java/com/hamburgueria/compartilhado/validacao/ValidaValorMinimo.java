package com.hamburgueria.compartilhado.validacao;

import com.hamburgueria.compartilhado.pedido.Pedido;

import java.math.BigDecimal;

public final class ValidaValorMinimo extends ManipuladorPedido {

    private final BigDecimal valorMinimo;

    public ValidaValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    @Override
    protected ResultadoValidacao verificar(Pedido pedido) {
        if (pedido.total().compareTo(valorMinimo) < 0) {
            return ResultadoValidacao.falha("valor abaixo do minimo");
        }
        return ResultadoValidacao.ok();
    }
}
