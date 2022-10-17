package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.UsuarioPojo;
import pojo.componentePojo;
import pojo.produtoPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Teste de API Rest do modulo Produto! :)")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeEach() {

        //Configurando os dados da API Rest da Lojinha
        RestAssured.baseURI = "http://165.227.93.41";
        // As vezes pode precisar port = 8080;
        basePath = "/lojinha";


        //Obter o token do usuário Admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarNovoUsuarioAdmin())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");
        //System.out.println(this.token);
    }

    @Test
    @DisplayName("Validar os limites proibidos do valor do Produto - Acima")
    public void testValorAcima() {

        // Tentar inserir um produto com valor 0.00 e validar se mensagem de erro foi apresentado e o
        // Status code retornado foi 442

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(10000.00))
                .when()
                    .post("/v2/produtos")

                .then()
                    .assertThat() //Valide que
                        .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                            .statusCode(422);



    }

    @Test
    @DisplayName("Validar os limites proibidos do valor do Produto - Abaixo")

    public void testValorZerado() {

        // Tentar inserir um produto com valor 0.00 e validar se mensagem de erro foi apresentado e o
        // Status code retornado foi 442

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(0.00))
                .when()
                .post("/v2/produtos")

                .then()
                .assertThat() //Valide que
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);

    }
}