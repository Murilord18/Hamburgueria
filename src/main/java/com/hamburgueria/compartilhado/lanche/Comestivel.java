package com.hamburgueria.compartilhado.lanche;

import com.hamburgueria.compartilhado.cozinha.preparo.PreparoTemplate;

import java.math.BigDecimal;
import java.util.Optional;

//Decorator - Template Method
public interface Comestivel {

    String descricao();

    BigDecimal preco();

    boolean exigePreparo();


    Optional<PreparoTemplate> preparo();
}
