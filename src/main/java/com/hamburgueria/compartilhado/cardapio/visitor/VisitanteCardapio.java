package com.hamburgueria.compartilhado.cardapio.visitor;

import com.hamburgueria.compartilhado.cardapio.CategoriaCardapio;
import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;

//Visitor
public interface VisitanteCardapio {
    void visitarProduto(ProdutoCardapio produto);
    void visitarCategoria(CategoriaCardapio categoria);
}
