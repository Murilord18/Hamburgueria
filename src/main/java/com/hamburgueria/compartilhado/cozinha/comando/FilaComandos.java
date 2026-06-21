package com.hamburgueria.compartilhado.cozinha.comando;

import java.util.ArrayDeque;
import java.util.Deque;


public final class FilaComandos {

    private final Deque<ComandoCozinha> executados = new ArrayDeque<>();

    public void executar(ComandoCozinha comando) {
        comando.executar();
        executados.push(comando);
    }

    public void desfazerUltimo() {
        if (!executados.isEmpty()) {
            executados.pop().desfazer();
        }
    }

    public int quantidadeExecutados() {
        return executados.size();
    }
}
