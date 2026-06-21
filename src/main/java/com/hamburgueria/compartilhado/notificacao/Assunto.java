package com.hamburgueria.compartilhado.notificacao;


public interface Assunto {
    void registrar(ObservadorPedido observador);
    void remover(ObservadorPedido observador);
    void notificarObservadores();
}
