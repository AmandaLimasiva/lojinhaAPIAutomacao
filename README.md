## Lojinha API Automação
Esse é um repositório que contém a automação de alguns testes de API Rest de um software denominado Lojinha.


## Tecnologias utilizadas
- Java
- JUnit
- RestAssured
- Maven

## Testes automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto Lojinha que estão vinculadas diretamente a regra de negócio que diz que o valor deve estar entre R$0,01 a R$7.000,00.

## Notas Gerais
- Sempre utilizamos a anotação Before Each para capturar o token que sempre será utilizado nos métodos de teste.
- Armazenamos os dados que são enviados para a API através do uso de classes POJO.
