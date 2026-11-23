# 3.6. Preparando o cenário de testes com @BeforeEach e @BeforeAll

Ao invés de fazer toda preparação para o teste dentro de cada método, podemos fazer essa preparação com as anotações:

    @BeforeAll
    @BeforeEach
    @AfterAll
    @AfterEach

Vide a classe `com.algaworks.junit.blog.negocio.CalculadoraGanhosTest`