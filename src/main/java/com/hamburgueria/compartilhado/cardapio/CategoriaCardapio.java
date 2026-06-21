package com.hamburgueria.compartilhado.cardapio;

import com.hamburgueria.compartilhado.cardapio.visitor.VisitanteCardapio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

//composite
public final class CategoriaCardapio implements ItemCardapio, Iterable<ItemCardapio> {

    private static final BigDecimal PRECO_INICIAL = new BigDecimal("0.00");

    private final String nome;
    private final List<ItemCardapio> itens = new ArrayList<>();

    public CategoriaCardapio(String nome) {
        this.nome = Objects.requireNonNull(nome, "nome");
    }

    public CategoriaCardapio adicionar(ItemCardapio item) {
        itens.add(item);
        return this;
    }

    public int quantidadeFilhos() {
        return itens.size();
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public BigDecimal preco() {
        BigDecimal total = PRECO_INICIAL;
        for (ItemCardapio item : itens) {
            total = total.add(item.preco());
        }
        return total;
    }

    @Override
    public void aceitar(VisitanteCardapio visitante) {
        visitante.visitarCategoria(this);
    }

    @Override
    public Iterator<ItemCardapio> iterator() {
        return itens.iterator();
    }
}
