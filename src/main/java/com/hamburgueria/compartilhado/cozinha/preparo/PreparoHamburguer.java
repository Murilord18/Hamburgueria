package com.hamburgueria.compartilhado.cozinha.preparo;

//Template Method
public final class PreparoHamburguer extends PreparoTemplate {

    @Override
    protected String separarIngredientes() {
        return "separando pao, blend e queijo";
    }

    @Override
    protected String montar() {
        return "montando hamburguer";
    }

    @Override
    protected String cozinhar() {
        return "grelhando o blend";
    }
}
