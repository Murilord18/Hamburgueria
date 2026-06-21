package com.hamburgueria.compartilhado.cardapio;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.cardapio.visitor.VisitanteCardapio;

//composite
public interface ItemCardapio {
    String nome();
    BigDecimal preco();
    void aceitar(VisitanteCardapio visitante);
}
