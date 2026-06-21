package com.hamburgueria.compartilhado.fabrica.lanche;

import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;

import java.math.BigDecimal;
import com.hamburgueria.compartilhado.lanche.Lanche;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;

public final class CriadorXSalada extends CriadorLanche {

    private static final BigDecimal PRECO_BASE = new BigDecimal("17.00");
    private static final BigDecimal CUSTO_PAO = new BigDecimal("2.00");
    private static final BigDecimal CUSTO_BLEND = new BigDecimal("8.00");
    private static final BigDecimal CUSTO_QUEIJO = new BigDecimal("3.00");
    private static final BigDecimal CUSTO_ALFACE = new BigDecimal("1.00");
    private static final BigDecimal CUSTO_TOMATE = new BigDecimal("1.50");

    @Override
    protected Lanche criarLanche(FabricaIngredientes fabricaIngredientes) {
        return new LancheBuilder()
                .comNome("X-Salada")
                .comPrecoBase(PRECO_BASE)
                .adicionarIngrediente(fabricaIngredientes.obter("pao", CUSTO_PAO))
                .adicionarIngrediente(fabricaIngredientes.obter("blend", CUSTO_BLEND))
                .adicionarIngrediente(fabricaIngredientes.obter("queijo", CUSTO_QUEIJO))
                .adicionarIngrediente(fabricaIngredientes.obter("alface", CUSTO_ALFACE))
                .adicionarIngrediente(fabricaIngredientes.obter("tomate", CUSTO_TOMATE))
                .construir();
    }
}
