package com.hamburgueria.compartilhado.lanche.ponto;

public final class BemPassado implements PontoCarne {

    private static final int TEMPO_SEGUNDOS = 360;

    @Override
    public String descricao() {
        return "bem passado";
    }

    @Override
    public int tempoCozimentoSegundos() {
        return TEMPO_SEGUNDOS;
    }
}
