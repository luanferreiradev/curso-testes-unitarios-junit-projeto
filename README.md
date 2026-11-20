# 3.1. Organizando testes com o padrão Triple A

O padrão Triplo A vem de:

- Arrange
- Act
- Assert

Ou seja, primeiro preparamos o cenário, executamos e por último validamos. Assim montamos nossos testes.

Para seguir esse padão temos que extrair o executable dos assertThrow, mas não vamos usar o Executable do java, vamos usar:

`org.junit.jupiter.api.function.Executable`

Vide a classe `com.algaworks.junit.utilidade.SaudacaoUtilTest`.