package com.hamburgueria.compartilhado.cozinha.preparo;

import java.util.ArrayList;
import java.util.List;


public abstract class PreparoTemplate {

    public final List<String> preparar() {
        List<String> etapas = new ArrayList<>();
        etapas.add(separarIngredientes());
        etapas.add(montar());
        etapas.add(cozinhar());
        etapas.add(finalizar());
        return etapas;
    }

    protected abstract String separarIngredientes();

    protected abstract String montar();

    protected String cozinhar() {
        return "cozinhando no fogo";
    }

    protected String finalizar() {
        return "embalando";
    }
}
