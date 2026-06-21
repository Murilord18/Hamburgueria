package com.hamburgueria.compartilhado.cardapio.visitor;

import com.hamburgueria.compartilhado.cardapio.CategoriaCardapio;
import com.hamburgueria.compartilhado.cardapio.ItemCardapio;
import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;


public final class ContadorProdutosVisitor implements VisitanteCardapio {

    private static final int CONTADOR_INICIAL = 0;
    private static final int UM_PRODUTO = 1;

    private int quantidade = CONTADOR_INICIAL;

    @Override
    public void visitarProduto(ProdutoCardapio produto) {
        quantidade += UM_PRODUTO;
    }

    @Override
    public void visitarCategoria(CategoriaCardapio categoria) {
        for (ItemCardapio item : categoria) {
            item.aceitar(this);
        }
    }

    public int getQuantidade() {
        return quantidade;
    }
}
