package br.com.southrocklab.resources;

import br.com.southrocklab.ApplicationTests;

import br.com.southrocklab.resources.methods.CreateCustomer;
import br.com.southrocklab.resources.tdm.InfoCustomer;
import static org.hamcrest.Matchers.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static br.com.southrocklab.resources.core.PathConstants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerResourceTest extends ApplicationTests {
    InfoCustomer infoCustomer = new InfoCustomer();
    CreateCustomer createCustomer = new CreateCustomer();
    static int id;
   @Test
    public void t01_deve_salvar_novo_customer_no_sistema() {
    id =
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
    }

    @Test
    public void t02_deve_retornar_status_400_quando_salvar_customer_ja_salvo() {
        given()
            .body(createCustomer.SalvarNovoCustomer())
        .when()
            .post(APP_CUSTOMER_PATH)
        .then()
            .statusCode(400)
            .body("error", is("Bad Request"))
            .body("message", is("Customer already exists"))
        ;

    }

    @Test
    public void t03_deve_retornar_status_400_quando_salvar_customer_com_birth_date_maior_que_hoje() {

    }

    @Test
    public void t04_deve_procurar_customer_pelo_name_e_last_name() {

    }

    @Test
    public void t05_deve_retornar_status_404_quando_buscar_customer_por_name_e_last_name_inexistente() {

    }

    @Test
    public void t06_deve_atualizar_o_last_name_de_um_customer() {

    }

    @Test
    public void t07_deve_retornar_status_404_ao_atualizar_um_customer_com_id_nao_salvo_no_sistema() {

    }

    @Test
    public void t08_deve_deletar_um_customer_salvo_no_sistema() {

    }

    @Test
    public void t09_deve_retornar_status_404_ao_deletar_um_customer_com_id_nao_salvo_no_sistema() {

    }
}
