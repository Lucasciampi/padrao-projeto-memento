package org.example;

public class FuncionarioEstadoAtivo implements FuncionarioEstado{

    private FuncionarioEstadoAtivo() {}

    private static FuncionarioEstadoAtivo instance;

    public static FuncionarioEstadoAtivo getInstance() {
        if (instance == null) {
            instance = new FuncionarioEstadoAtivo();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Ativo";
    }

}
