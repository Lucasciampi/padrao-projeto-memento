package org.example;

public class FuncionarioEstadoFerias implements FuncionarioEstado{

    private FuncionarioEstadoFerias() {}

    private static FuncionarioEstadoFerias instance;

    public static FuncionarioEstadoFerias getInstance() {
        if (instance == null) {
            instance = new FuncionarioEstadoFerias();
        }
        return instance;
    }

    @Override
    public String getEstado() {
        return "Férias";
    }

}
