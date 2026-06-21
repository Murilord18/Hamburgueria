package com.hamburgueria.compartilhado.filtro;

public final class FiltroVegetariano implements ExpressaoFiltro {

    @Override
    public boolean interpretar(ContextoItem item) {
        return item.vegetariano();
    }
}
