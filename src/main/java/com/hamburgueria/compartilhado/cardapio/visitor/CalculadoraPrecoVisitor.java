package com.hamburgueria.compartilhado.cardapio.visitor;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.cardapio.CategoriaCardapio;
import com.hamburgueria.compartilhado.cardapio.ItemCardapio;
import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;

//Visitor
public final class CalculadoraPrecoVisitor implements VisitanteCardapio {

    private static final BigDecimal TOTAL_INICIAL = new BigDecimal("0.00");

    private BigDecimal total = TOTAL_INICIAL;

    @Override
    public void visitarProduto(ProdutoCardapio produto) {
        total = total.add(produto.preco());
    }

    @Override
    public void visitarCategoria(CategoriaCardapio categoria) {
        for (ItemCardapio item : categoria) {
            item.aceitar(this);
        }
    }

    public BigDecimal getTotal() {
        return total;
    }
}
