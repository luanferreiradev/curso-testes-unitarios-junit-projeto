# 3.7. Um teste deve ter uma única asserção?

Um teste pode conter mais de uma asserção, porém, isso torna o entendimento dos testes mais complicado, então idealmenta devemos separa-los. 

Deve-se notar também, que quando criamos um teste com várias asserções, se não utilizarmos o assertAll, caso uma asserção falhe, as demais não serão executadas.

Nesta aula separamos um teste por asserção, vide `com.algaworks.junit.blog.negocio.CalculadoraGanhosTest`