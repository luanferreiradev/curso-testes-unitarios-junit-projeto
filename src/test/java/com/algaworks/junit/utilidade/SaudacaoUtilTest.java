package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    public void saudarInicioDia() {
        String saudacao = SaudacaoUtil.saudar(0);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    public void saudarFinalDia() {
        String saudacao = SaudacaoUtil.saudar(10);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    public void saudarInicioTarde() {
        String saudacao = SaudacaoUtil.saudar(12);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta");
    }

    @Test
    public void saudarFinalTarde() {
        String saudacao = SaudacaoUtil.saudar(15);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta");
    }

    @Test
    public void saudarInicioNoite() {
        String saudacao = SaudacaoUtil.saudar(18);
        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    public void saudarFinalNoite() {
        String saudacao = SaudacaoUtil.saudar(23);
        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    public void deveLancarException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }
}