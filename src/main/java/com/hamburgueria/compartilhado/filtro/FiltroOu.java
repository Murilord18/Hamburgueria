package com.hamburgueria.compartilhado.filtro;

import java.util.Objects;

public final class FiltroOu implements ExpressaoFiltro {

    private final ExpressaoFiltro esquerda;
    private final ExpressaoFiltro direita;

    public FiltroOu(ExpressaoFiltro esquerda, ExpressaoFiltro direita) {
        this.esquerda = Objects.requireNonNull(esquerda, "esquerda");
        this.direita = Objects.requireNonNull(direita, "direita");
    }

    @Override
    public boolean interpretar(ContextoItem item) {
        return esquerda.interpretar(item) || direita.interpretar(item);
    }
}
