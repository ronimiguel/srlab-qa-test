package br.com.southrocklab.resources;

import br.com.southrocklab.ApplicationTests;
import br.com.southrocklab.resources.methods.CreateCard;
import br.com.southrocklab.resources.methods.CreateCustomer;
import br.com.southrocklab.resources.tdm.InfoCard;
import br.com.southrocklab.resources.tdm.InfoCustomer;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static br.com.southrocklab.resources.core.PathConstants.*;
import static org.hamcrest.Matchers.notNullValue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardResourceTest extends ApplicationTests {
    static int customerId;
    static int cardId;
    InfoCustomer infoCustomer = new InfoCustomer();
    InfoCard infoCard = new InfoCard();
    CreateCustomer createCustomer = new CreateCustomer();
    CreateCard createCard = new CreateCard();

    @Test
    public void t10_deve_salvar_novo_card_no_sistema() {
        customerId =
            given()
                .body(createCustomer.SalvarNovoCustomer())
            .when()
                .post(APP_CUSTOMER_PATH)
            .then()
                .statusCode(200)
                .body("id", is(notNullValue()))
                .body("name", is(infoCustomer.getName()))
                .body("lastName", is(infoCustomer.getLastName()))
                .body("birthDate", is(infoCustomer.getBirthDate()))
                .extract().path("id")
        ;
        cardId =
        given()
           .body(createCard.salvarNovo(customerId))
        .when()
            .post(APP_CARD_PATH)
        .then()
            .statusCode(200)
            .body("number", is(infoCard.getCardNumber()))
                .extract().path("id")
        ;

    }

    @Test
    public void t11_deve_retornar_status_400_quando_salvar_card_com_cvv_maior_que_999() {
        given()
            .body(createCard.comCvcMaior(customerId))
        .when()
            .post(APP_CARD_PATH)
        .then()
            .statusCode(400)
            .body("cvc", is("cvc must be between 001 to 999"))
        ;
    }

    @Test
    public void t12_deve_retornar_status_400_quando_salvar_card_com_expiration_month_maior_que_12() {
        given()
            .body(createCard.comExpMonthMaior(customerId))
        .when()
            .post(APP_CARD_PATH)
        .then()
            .statusCode(400)
            .body("expirationMoth", is("Expiration month must be less then 12"))
        ;
    }

    @Test
    public void t13_deve_retornar_status_400_quando_salvar_card_com_expiration_year_menor_que_2022() {
        given()
            .body(createCard.comExpYearMenorQueAtual(customerId))
        .when()
            .post(APP_CARD_PATH)
        .then()
            .statusCode(400)
            .body("expirationYear", is("Expiration year must be greater than the current one"))
        ;
    }

    @Test
    public void t14_deve_retornar_status_400_quando_salvar_card_com_number_de_15_digitos() {

    }

    @Test
    public void t15_deve_deletar_um_card_salvo_no_sistema() {

    }

    @Test
    public void t16_deve_retornar_status_404_ao_deletar_um_card_com_id_nao_salvo_no_sistema() {

    }
}
