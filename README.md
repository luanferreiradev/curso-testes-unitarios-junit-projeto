# 2.11. Executando testes via Maven

Adicionamos o plugin para que possamos executar os testes pelo maven

    <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.22.2</version>
    </plugin>

Podemos executar os testes com: `mvn test`

Os testes também são executados quando usamos: `mvn clean package`

Podemos fazer um clean package sem executar os testes novamente com: `mvn clean package -Dmaven.test.skip=true`

---

## Problemas com Encoding de caracteres

Caso o seu ambiente venha a apresentar problemas com encoding, adicione uma variável de ambiente com o nome e valor:

`JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF-8`

Isso fará com que o Maven e o Java sejam forçados a usar o UTF-8 na hora da execução

Obs.: Caso exista alguma configuração customizada de JAVA_TOOL_OPTIONS na sua IDE, como de memória, ela pode acabar conflitando com a variável de ambiente.