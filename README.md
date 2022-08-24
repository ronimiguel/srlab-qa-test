## Sobre o teste

O objetivo é criar testes e2e para os cenários já criados no pacote de test.

### Rodando a API

O repositório consiste em uma pequena API para cadastro de customers(comprador portador de um cartão) e cards(cartões) para seus respectivos portadores. O projeto está utilizando Java 8 e usamos o maven para gerenciamento de pacotes, portanto antes de tudo você deve ter os dois instalados na sua máquina e baixar o projeto. Para rodar a api basta digitar os comandos dentro da pasta principal do projeto:

```bash
mvn clean install
```

e depois

```bash
mvn spring-boot:run
```

A aplicação está configurada para rodar na porta 9090. Para acessar o **swagger** basta entrar no endereço [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html)

### Exemplos de JSON

- Json para criar um novo customer:

```json
{
  "birthDate": "1992-08-15",
  "lastName": "Lorem",
  "name": "Ipsum"
}
```

- Json para criar um novo card:

```json
{
  "brand": "VISA",
  "cvc": "111",
  "expirationMoth": 2,
  "expirationYear": 2025,
  "holderName": "LOREM IPSUM SILVA",
  "number": "1111111111111112",
  "customerId": 2
}
```

### O que utilizar para o teste

Para facilitar seu trabalho já adicionamos o Junit e o Restassured, mas para a realização do teste não colocamos nenhuma restrição, portanto sinta-se a vontade em utilizar quaisquer ferramentas para a automação, assim como alterar as classes de teste que estamos enviando. Lembre-se sempre que os testes devem ser uma automação para as funcionalidades da API.

**Dicas**: faça um fork deste projeto, clone o mesmo com o git em sua máquina, faça suas alterações e suba no seus repositório github;

## Todos os testes foram Automatizados
### Para rodar os testes

```bash
mvn test
```

### Conclusão

Os testes foram desenvolvidos utilizando Restassured, nenhuma nova dependência foi adicionada no pom.xml. 

Alguns cenários dependiam de outros testes, tentei manter todos os cenários o mais limpo e dinâmico possível.

**Obs:** Caso não for rodar os testes pela linha de comando provavelmente você terá que comentar a linha de porta aleatória no arquivo ApplicationTests.java e descomentar a que roda pela porta 9090.

**Exemplo:**

```
        RestAssured.port = porta; // PORTA aleatoria
//        RestAssured.port = APP_PORT; // PORTA 9090
```

 

**Dicas**: Caso queira rodar os testes utilizando massa de dados diferente, o único lugar que precisa alterar são os dados que estão dentro do pacote tdm (test data management).

Abaixo uma **file tree** da estrutura do testes com uma breve descrição:

```
`-- test
    `-- java
        `-- br
            `-- com
                `-- southrocklab
                    |-- resources
                    |   |-- core
                    |   |   `-- PathConstants.java		(var de path)
                    |   |-- methods
                    |   |   |-- CreateCard.java			(criar cartao)
                    |   |   `-- CreateCustomer.java		(criar cliente)
                    |   |-- tdm
                    |   |   |-- InfoCard.java 			(dados cartão)
                    |   |   `-- InfoCustomer.java 		(dados cliente)
                    |   |-- utils
                    |   |   `-- DateUtils.java 			(gerar datas)
                    |   |-- CardResourceTest.java		(testes cartão)
                    |   `-- CustomerResourceTest.java	(testes cliente)
                    `-- ApplicationTests.java			(setUp Projeto)

```
