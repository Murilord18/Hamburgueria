package com.hamburgueria.compartilhado.lanche;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//Fabrica Fly
public final class FabricaIngredientes {

    private final Map<String, Ingrediente> cache = new HashMap<>();

    public Ingrediente obter(String nome, BigDecimal custo) {
        return cache.computeIfAbsent(nome, chave -> new Ingrediente(chave, custo));
    }

    public int quantidadeDistintaCriada() {
        return cache.size();
    }
}
