# 2.10. Ignorando execução dos testes condicionalmente com Assumptions

Clicamos no menu de Run e vamos em edit configuration e adicionamos a vaŕiavel de ambiente ENV=PROD.
Vale notar que adicionamos a váriavel de ambiente apenas ao `SimuladorEsperaTest`.

---

Podemos desabilitar um teste com base na váriavel de ambiente destas duas formas:

`Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), () -> "Abortando teste: Não deve ser executado em PROD");`

Ou

`@EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")`

---

**Vale notar também que os testes apenas são ignorados quando executamos a classe de testes. Se executarmos um método ele será executado normalmente, isso também vale para a anotação @Disabled.**

