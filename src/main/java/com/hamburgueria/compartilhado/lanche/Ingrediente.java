package com.hamburgueria.compartilhado.lanche;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

//flyweight
public final class Ingrediente {

    private static final int CASAS_REAIS = 2;

    private final String nome;
    private final BigDecimal custo;

    Ingrediente(String nome, BigDecimal custo) {
        this.nome = Objects.requireNonNull(nome, "nome");
        this.custo = Objects.requireNonNull(custo, "custo").setScale(CASAS_REAIS, RoundingMode.HALF_UP);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (!(outro instanceof Ingrediente)) {
            return false;
        }
        Ingrediente i = (Ingrediente) outro;
        return custo.equals(i.custo) && nome.equals(i.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, custo);
    }
}
