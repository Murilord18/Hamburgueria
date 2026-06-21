package com.hamburgueria.compartilhado.cardapio;

import com.hamburgueria.compartilhado.cardapio.visitor.VisitanteCardapio;
import com.hamburgueria.compartilhado.lanche.Comestivel;

import java.math.BigDecimal;
import java.util.Objects;

//composite
public final class ProdutoCardapio implements ItemCardapio {

    private final String nome;
    private final Comestivel comestivel;

    public ProdutoCardapio(String nome, Comestivel comestivel) {
        this.nome = Objects.requireNonNull(nome, "nome");
        this.comestivel = Objects.requireNonNull(comestivel, "comestivel");
    }

    public Comestivel getComestivel() {
        return comestivel;
    }

    @Override
    public String nome() {
        return nome;
    }

    @Override
    public BigDecimal preco() {
        return comestivel.preco();
    }

    @Override
    public void aceitar(VisitanteCardapio visitante) {
        visitante.visitarProduto(this);
    }
}
