package com.hamburgueria.compartilhado.filtro;

import java.util.Objects;

public final class FiltroNao implements ExpressaoFiltro {

    private final ExpressaoFiltro expressao;

    public FiltroNao(ExpressaoFiltro expressao) {
        this.expressao = Objects.requireNonNull(expressao, "expressao");
    }

    @Override
    public boolean interpretar(ContextoItem item) {
        return !expressao.interpretar(item);
    }
}
