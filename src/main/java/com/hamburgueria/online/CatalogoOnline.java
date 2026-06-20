package com.hamburgueria.online;

import com.hamburgueria.compartilhado.filtro.ExpressaoFiltro;

import java.util.ArrayList;
import java.util.List;

//Interpreter
public final class CatalogoOnline {

    private final List<ItemCardapioOnline> itens = new ArrayList<>();

    public CatalogoOnline adicionar(ItemCardapioOnline item) {
        itens.add(item);
        return this;
    }

    public int quantidade() {
        return itens.size();
    }

    /** Retorna os itens que satisfazem a expressao de filtro. */
    public List<ItemCardapioOnline> filtrar(ExpressaoFiltro expressao) {
        List<ItemCardapioOnline> resultado = new ArrayList<>();
        for (ItemCardapioOnline item : itens) {
            if (expressao.interpretar(item)) {
                resultado.add(item);
            }
        }
        return resultado;
    }
}
