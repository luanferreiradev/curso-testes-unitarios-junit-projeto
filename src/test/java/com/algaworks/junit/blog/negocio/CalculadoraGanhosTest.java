package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.utilidade.ProcessadorTextoSimples;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraGanhosTest {

    static CalculadoraGanhos calculadora;
    Editor autor;
    Post post;

    @BeforeAll
    static void beforeAll() {
        calculadora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);
    }

    @BeforeEach
    void beforeEach() {
        autor = new Editor(1L, "Alex", "alex@gmail.com", new BigDecimal("5"), true);
        post = new Post(1L, "Ecossistema Java",
                "O ecossistema do Java é muito maduro", autor, "ecossistema-jaba-abc123",
                null, false, false);
    }

//    @AfterAll
//    static void AfterAll() {
//        System.out.println("Depois de todos os testes");
//    }

//    @AfterEach
//    void AfterEach() {
//        System.out.println("Depois de cada teste");
//    }

    @Test
    public void deveCalcularGanhos() {
        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal("45"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(new BigDecimal("5"), ganhos.getValorPagoPorPalavra());
    }

    @Test
    public void deveCalcularGanhosSemPremium() {
        autor.setPremium(false);
        Ganhos ganhos = calculadora.calcular(post);

        assertEquals(new BigDecimal("35"), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(new BigDecimal("5"), ganhos.getValorPagoPorPalavra());
    }

}