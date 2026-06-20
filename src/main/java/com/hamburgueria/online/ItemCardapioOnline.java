package com.hamburgueria.online;

import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;

import java.math.BigDecimal;
import com.hamburgueria.compartilhado.filtro.ContextoItem;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Composite e Interpreter
public final class ItemCardapioOnline implements ContextoItem {

    private final ProdutoCardapio produto;
    private final int calorias;
    private final boolean vegetariano;
    private final Set<String> ingredientes;

    public ItemCardapioOnline(ProdutoCardapio produto, int calorias, boolean vegetariano, Set<String> ingredientes) {
        this.produto = Objects.requireNonNull(produto, "produto");
        this.calorias = calorias;
        this.vegetariano = vegetariano;
        this.ingredientes = new HashSet<>(ingredientes);
    }

    public ProdutoCardapio getProduto() {
        return produto;
    }

    public String nome() {
        return produto.nome();
    }

    @Override
    public BigDecimal preco() {
        return produto.preco();
    }

    @Override
    public boolean vegetariano() {
        return vegetariano;
    }

    @Override
    public int calorias() {
        return calorias;
    }

    @Override
    public boolean contemIngrediente(String nome) {
        return ingredientes.contains(nome);
    }
}
