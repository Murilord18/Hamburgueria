package com.hamburgueria.compartilhado.filtro;

public final class FiltroCaloriasMaximas implements ExpressaoFiltro {

    private final int caloriasMaximas;

    public FiltroCaloriasMaximas(int caloriasMaximas) {
        this.caloriasMaximas = caloriasMaximas;
    }

    @Override
    public boolean interpretar(ContextoItem item) {
        return item.calorias() <= caloriasMaximas;
    }
}
