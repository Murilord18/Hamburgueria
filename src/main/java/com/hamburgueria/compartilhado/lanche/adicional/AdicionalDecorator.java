package com.hamburgueria.compartilhado.lanche.adicional;

import com.hamburgueria.compartilhado.cozinha.preparo.PreparoTemplate;
import com.hamburgueria.compartilhado.lanche.Comestivel;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

//Decorator
public abstract class AdicionalDecorator implements Comestivel {

    protected final Comestivel base;

    protected AdicionalDecorator(Comestivel base) {
        this.base = Objects.requireNonNull(base, "base");
    }

    protected abstract String rotuloAdicional();

    protected abstract BigDecimal precoAdicional();

    @Override
    public String descricao() {
        return base.descricao() + " + " + rotuloAdicional();
    }

    @Override
    public BigDecimal preco() {
        return base.preco().add(precoAdicional());
    }

    @Override
    public boolean exigePreparo() {
        return base.exigePreparo();
    }

    @Override
    public Optional<PreparoTemplate> preparo() {
        return base.preparo();
    }
}
