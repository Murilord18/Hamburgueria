package com.hamburgueria.compartilhado.filtro;

import java.math.BigDecimal;

public final class FiltroPrecoMaximo implements ExpressaoFiltro {

    private final BigDecimal precoMaximo;

    public FiltroPrecoMaximo(BigDecimal precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    @Override
    public boolean interpretar(ContextoItem item) {
        return item.preco().compareTo(precoMaximo) <= 0;
    }
}
