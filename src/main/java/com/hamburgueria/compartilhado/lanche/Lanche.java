package com.hamburgueria.compartilhado.lanche;

import com.hamburgueria.compartilhado.cozinha.preparo.PreparoHamburguer;
import com.hamburgueria.compartilhado.cozinha.preparo.PreparoTemplate;
import com.hamburgueria.compartilhado.cozinha.preparo.PreparoVegetariano;
import com.hamburgueria.compartilhado.lanche.ponto.PontoCarne;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//Decorator-Proto-Fly-Template
public class Lanche implements Comestivel, Cloneable {

    private static final int CASAS_REAIS = 2;

    private final String nome;
    private final BigDecimal precoBase;
    private final boolean vegetariano;
    private List<Ingrediente> ingredientes;
    private PontoCarne ponto;

    public Lanche(String nome, BigDecimal precoBase, boolean vegetariano,
                  List<Ingrediente> ingredientes, PontoCarne ponto) {
        this.nome = nome;
        this.precoBase = precoBase.setScale(CASAS_REAIS, RoundingMode.HALF_UP);
        this.vegetariano = vegetariano;
        this.ingredientes = new ArrayList<>(ingredientes);
        this.ponto = ponto;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public PontoCarne getPonto() {
        return ponto;
    }

    public void setPonto(PontoCarne ponto) {
        this.ponto = ponto;
    }

    public List<Ingrediente> getIngredientes() {
        return Collections.unmodifiableList(ingredientes);
    }

    public void adicionarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @Override
    public String descricao() {
        StringBuilder sb = new StringBuilder(nome);
        for (Ingrediente i : ingredientes) {
            sb.append(", ").append(i.getNome());
        }
        return sb.toString();
    }

    @Override
    public BigDecimal preco() {
        BigDecimal total = precoBase;
        for (Ingrediente i : ingredientes) {
            total = total.add(i.getCusto());
        }
        return total;
    }

    @Override
    public boolean exigePreparo() {
        return true;
    }

    @Override
    public Optional<PreparoTemplate> preparo() {
        PreparoTemplate template = vegetariano ? new PreparoVegetariano() : new PreparoHamburguer();
        return Optional.of(template);
    }

    public Lanche clonar() {
        try {
            Lanche copia = (Lanche) super.clone();
            copia.ingredientes = new ArrayList<>(this.ingredientes);
            return copia;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Lanche deveria ser clonavel", e);
        }
    }
}
