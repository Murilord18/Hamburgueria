package com.hamburgueria.compartilhado.filtro;

import java.math.BigDecimal;

//Interpreter
public interface ContextoItem {
    BigDecimal preco();
    boolean vegetariano();
    int calorias();
    boolean contemIngrediente(String nome);
}
