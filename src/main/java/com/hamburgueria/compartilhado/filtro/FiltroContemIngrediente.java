package com.hamburgueria.compartilhado.filtro;

import java.util.Objects;

public final class FiltroContemIngrediente implements ExpressaoFiltro {

    private final String ingrediente;

    public FiltroContemIngrediente(String ingrediente) {
        this.ingrediente = Objects.requireNonNull(ingrediente, "ingrediente");
    }

    @Override
    public boolean interpretar(ContextoItem item) {
        return item.contemIngrediente(ingrediente);
    }
}
