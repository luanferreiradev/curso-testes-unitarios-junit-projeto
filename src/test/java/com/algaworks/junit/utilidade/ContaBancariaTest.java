package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    public void saldoNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("-5"));
        assertEquals(new BigDecimal("-5"), conta.saldo());
    }

    @Test
    public void saldoZero() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("0"));
        assertEquals(new BigDecimal("0"), conta.saldo());
    }

    @Test
    public void saldoPositivo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("5"));
        assertEquals(new BigDecimal("5"), conta.saldo());
    }

    @Test
    public void saldoNulo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null));
        assertEquals("O saldo não pode ser nulo", exception.getMessage());
    }

    @Test
    public void saqueNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.saque(new BigDecimal("-5")));
        assertEquals("O valor do saque deve ser maior que 0", exception.getMessage());
    }

    @Test
    public void saqueZero() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.saque(BigDecimal.ZERO));
        assertEquals("O valor do saque deve ser maior que 0", exception.getMessage());
    }

    @Test
    public void saquePositivo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        conta.saque(new BigDecimal("50"));
        assertEquals(new BigDecimal("50"), conta.saldo());
    }

    @Test
    public void saqueNulo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.saque(null));
        assertEquals("O valor do saque não pode ser nulo", exception.getMessage());
    }

    @Test
    public void saqueSaldoInsuficiente() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> conta.saque(new BigDecimal("200")));
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void depositoNegativo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(new BigDecimal("-5")));
        assertEquals("O valor deve ser maior que 0", exception.getMessage());
    }

    @Test
    public void depositoZero() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(BigDecimal.ZERO));
        assertEquals("O valor deve ser maior que 0", exception.getMessage());
    }

    @Test
    public void depositoPositivo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        conta.deposito(new BigDecimal("50"));
        assertEquals(new BigDecimal("150"), conta.saldo());
    }

    @Test
    public void depositoNulo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.deposito(null));
        assertEquals("O valor do depósito não pode ser nulo", exception.getMessage());
    }

    @Test
    public void consultaSaldo() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal("100"));
        assertEquals(new BigDecimal("100"), conta.saldo());
    }

}