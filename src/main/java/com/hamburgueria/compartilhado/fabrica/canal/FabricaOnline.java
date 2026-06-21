package com.hamburgueria.compartilhado.fabrica.canal;

import com.hamburgueria.compartilhado.fabrica.lanche.CriadorLanche;
import com.hamburgueria.compartilhado.fabrica.lanche.CriadorXBurger;
import com.hamburgueria.compartilhado.fabrica.lanche.CriadorXSalada;


public final class FabricaOnline implements FabricaCanal {

    @Override
    public Embalagem criarEmbalagem() {
        return new EmbalagemDelivery();
    }

    @Override
    public CriadorLanche criadorXBurger() {
        return new CriadorXBurger();
    }

    @Override
    public CriadorLanche criadorXSalada() {
        return new CriadorXSalada();
    }
}
