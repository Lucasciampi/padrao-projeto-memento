package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario();
    }

    @Test
    void deveArmazenarEstados() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario.setEstado(FuncionarioEstadoFerias.getInstance());
        assertEquals(2, funcionario.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario.setEstado(FuncionarioEstadoFerias.getInstance());
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario.setEstado(FuncionarioEstadoAposentado.getInstance());
        funcionario.restauraEstado(0);
        assertEquals(FuncionarioEstadoAtivo.getInstance(), funcionario.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario.setEstado(FuncionarioEstadoFerias.getInstance());
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario.setEstado(FuncionarioEstadoAposentado.getInstance());
        funcionario.restauraEstado(2);
        assertEquals(FuncionarioEstadoAtivo.getInstance(), funcionario.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            funcionario.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

}