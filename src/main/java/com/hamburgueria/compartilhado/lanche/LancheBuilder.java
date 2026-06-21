package com.hamburgueria.compartilhado.lanche;

import com.hamburgueria.compartilhado.lanche.ponto.PontoCarne;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Builder
public class LancheBuilder {

    private static final BigDecimal PRECO_BASE_PADRAO = new BigDecimal("0.00");

    private String nome = "Lanche";
    private BigDecimal precoBase = PRECO_BASE_PADRAO;
    private boolean vegetariano = false;
    private final List<Ingrediente> ingredientes = new ArrayList<>();
    private PontoCarne ponto;

    public LancheBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LancheBuilder comPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
        return this;
    }

    public LancheBuilder comoVegetariano() {
        this.vegetariano = true;
        return this;
    }

    public LancheBuilder adicionarIngrediente(Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
        return this;
    }

    public LancheBuilder comPonto(PontoCarne ponto) {
        this.ponto = ponto;
        return this;
    }

    public Lanche construir() {
        return new Lanche(nome, precoBase, vegetariano, ingredientes, ponto);
    }
}
