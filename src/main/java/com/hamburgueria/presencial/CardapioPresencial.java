package com.hamburgueria.presencial;

import com.hamburgueria.compartilhado.cardapio.CategoriaCardapio;
import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;
import com.hamburgueria.compartilhado.fabrica.canal.FabricaPresencial;
import com.hamburgueria.compartilhado.lanche.Bebida;

import java.math.BigDecimal;
import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;

//Composite - Abstract Factory
public final class CardapioPresencial {

    private static final BigDecimal PRECO_REFRIGERANTE = new BigDecimal("7.00");
    private static final BigDecimal PRECO_SUCO = new BigDecimal("9.00");
    private static final BigDecimal PRECO_AGUA = new BigDecimal("4.00");
    private static final BigDecimal PRECO_CERVEJA = new BigDecimal("12.00");

    private static final int VOLUME_LATA = 350;
    private static final int VOLUME_SUCO = 300;
    private static final int VOLUME_AGUA = 500;
    private static final int VOLUME_LONGNECK = 355;

    private final FabricaIngredientes fabricaIngredientes;

    public CardapioPresencial(FabricaIngredientes fabricaIngredientes) {
        this.fabricaIngredientes = fabricaIngredientes;
    }

    public CategoriaCardapio montar() {
        FabricaPresencial canal = new FabricaPresencial();
        CategoriaCardapio raiz = new CategoriaCardapio("Cardapio Presencial");

        CategoriaCardapio lanches = new CategoriaCardapio("Lanches");
        lanches.adicionar(new ProdutoCardapio("X-Burger",
                canal.criadorXBurger().produzir(fabricaIngredientes)));
        lanches.adicionar(new ProdutoCardapio("X-Burger Classico",
                canal.criadorXBurger().produzir(fabricaIngredientes)));
        lanches.adicionar(new ProdutoCardapio("X-Salada",
                canal.criadorXSalada().produzir(fabricaIngredientes)));
        raiz.adicionar(lanches);

        CategoriaCardapio bebidas = new CategoriaCardapio("Bebidas");
        bebidas.adicionar(new ProdutoCardapio("Coca-Cola",
                new Bebida("Coca-Cola", PRECO_REFRIGERANTE, VOLUME_LATA)));
        bebidas.adicionar(new ProdutoCardapio("Guarana Antarctica",
                new Bebida("Guarana Antarctica", PRECO_REFRIGERANTE, VOLUME_LATA)));
        bebidas.adicionar(new ProdutoCardapio("Suco de Laranja",
                new Bebida("Suco de Laranja", PRECO_SUCO, VOLUME_SUCO)));
        bebidas.adicionar(new ProdutoCardapio("Agua Mineral",
                new Bebida("Agua Mineral", PRECO_AGUA, VOLUME_AGUA)));
        bebidas.adicionar(new ProdutoCardapio("Cerveja Heineken",
                new Bebida("Cerveja Heineken", PRECO_CERVEJA, VOLUME_LONGNECK)));
        raiz.adicionar(bebidas);

        return raiz;
    }
}
