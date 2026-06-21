package com.hamburgueria.compartilhado.validacao;

import java.util.Objects;

public final class ResultadoValidacao {

    private static final String SEM_MOTIVO = "ok";

    private final boolean valido;
    private final String motivo;

    private ResultadoValidacao(boolean valido, String motivo) {
        this.valido = valido;
        this.motivo = Objects.requireNonNull(motivo, "motivo");
    }

    public static ResultadoValidacao ok() {
        return new ResultadoValidacao(true, SEM_MOTIVO);
    }

    public static ResultadoValidacao falha(String motivo) {
        return new ResultadoValidacao(false, motivo);
    }

    public boolean isValido() {
        return valido;
    }

    public String getMotivo() {
        return motivo;
    }
}
