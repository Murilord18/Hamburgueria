package com.hamburgueria.compartilhado.cozinha.preparo;

public final class PreparoVegetariano extends PreparoTemplate {

    @Override
    protected String separarIngredientes() {
        return "separando pao integral e grao de bico";
    }

    @Override
    protected String montar() {
        return "montando lanche vegetariano";
    }

    @Override
    protected String finalizar() {
        return "embalando em caixa biodegradavel";
    }
}
