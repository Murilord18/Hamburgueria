package com.hamburgueria.compartilhado.lanche;

import com.hamburgueria.compartilhado.cozinha.preparo.PreparoTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Optional;


public final class Bebida implements Comestivel {

    private static final int CASAS_REAIS = 2;

    private final String nome;
    private final BigDecimal preco;
    private final int volumeMl;

    public Bebida(String nome, BigDecimal preco, int volumeMl) {
        this.nome = Objects.requireNonNull(nome, "nome");
        this.preco = Objects.requireNonNull(preco, "preco").setScale(CASAS_REAIS, RoundingMode.HALF_UP);
        this.volumeMl = volumeMl;
    }

    public String getNome() {
        return nome;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    @Override
    public String descricao() {
        return nome + " (" + volumeMl + "ml)";
    }

    @Override
    public BigDecimal preco() {
        return preco;
    }

    @Override
    public boolean exigePreparo() {
        return false;
    }

    @Override
    public Optional<PreparoTemplate> preparo() {
        return Optional.empty();
    }
}
