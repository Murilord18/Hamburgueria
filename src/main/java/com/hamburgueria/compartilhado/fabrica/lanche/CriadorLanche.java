package com.hamburgueria.compartilhado.fabrica.lanche;

import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;
import com.hamburgueria.compartilhado.lanche.Lanche;
import com.hamburgueria.compartilhado.lanche.ponto.AoPonto;


public abstract class CriadorLanche {

    public final Lanche produzir(FabricaIngredientes fabricaIngredientes) {
        Lanche lanche = criarLanche(fabricaIngredientes);
        if (lanche.getPonto() == null) {
            lanche.setPonto(new AoPonto());
        }
        return lanche;
    }

    protected abstract Lanche criarLanche(FabricaIngredientes fabricaIngredientes);
}
