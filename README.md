# 4.1. Implementações falsas com Stub

O Stub é um dublê que nos ajuda a isolar o nosso teste unitário do mundo externo.

Nesta aula vamos criar os testes para `CadastroEditor`, porém, cadastro editor depende de uma instância de `ArmazenamentoEditor`, para isso vamos utilizar um Stub.

Criamos um Stub para `ArmazenamentoEditor`, a classe `ArmazenamentoEditorFixoEmMemoria`. Esta classe implementa a interface `ArmazenamentoEditor` e adiciona comportamentos relevantes para os testes. Vale ressaltar que a esta classe fica localizada no pacote de testes do JUnit.