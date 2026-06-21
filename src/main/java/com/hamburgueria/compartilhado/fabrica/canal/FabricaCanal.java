package com.hamburgueria.compartilhado.fabrica.canal;

import com.hamburgueria.compartilhado.fabrica.lanche.CriadorLanche;

//Abstract Factory
public interface FabricaCanal {

    Embalagem criarEmbalagem();

    CriadorLanche criadorXBurger();

    CriadorLanche criadorXSalada();


    default CriadorLanche criadorLanchePrincipal() {
        return criadorXBurger();
    }
}
