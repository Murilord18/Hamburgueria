package com.hamburgueria.compartilhado.fabrica.lanche;

import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;

import java.math.BigDecimal;
import com.hamburgueria.compartilhado.lanche.Lanche;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;

public final class CriadorXBurger extends CriadorLanche {

    private static final BigDecimal PRECO_BASE = new BigDecimal("15.00");
    private static final BigDecimal CUSTO_PAO = new BigDecimal("2.00");
    private static final BigDecimal CUSTO_BLEND = new BigDecimal("8.00");
    private static final BigDecimal CUSTO_QUEIJO = new BigDecimal("3.00");

    @Override
    protected Lanche criarLanche(FabricaIngredientes fabricaIngredientes) {
        return new LancheBuilder()
                .comNome("X-Burger")
                .comPrecoBase(PRECO_BASE)
                .adicionarIngrediente(fabricaIngredientes.obter("pao", CUSTO_PAO))
                .adicionarIngrediente(fabricaIngredientes.obter("blend", CUSTO_BLEND))
                .adicionarIngrediente(fabricaIngredientes.obter("queijo", CUSTO_QUEIJO))
                .construir();
    }
}
