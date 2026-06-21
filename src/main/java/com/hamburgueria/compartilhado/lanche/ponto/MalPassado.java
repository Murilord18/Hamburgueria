package com.hamburgueria.compartilhado.lanche.ponto;

public final class MalPassado implements PontoCarne {

    private static final int TEMPO_SEGUNDOS = 120;

    @Override
    public String descricao() {
        return "mal passado";
    }

    @Override
    public int tempoCozimentoSegundos() {
        return TEMPO_SEGUNDOS;
    }
}
