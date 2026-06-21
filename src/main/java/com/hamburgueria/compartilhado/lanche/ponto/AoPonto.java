package com.hamburgueria.compartilhado.lanche.ponto;

public final class AoPonto implements PontoCarne {

    private static final int TEMPO_SEGUNDOS = 240;

    @Override
    public String descricao() {
        return "ao ponto";
    }

    @Override
    public int tempoCozimentoSegundos() {
        return TEMPO_SEGUNDOS;
    }
}
