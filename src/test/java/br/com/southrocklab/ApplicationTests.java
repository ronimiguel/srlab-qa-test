package br.com.southrocklab;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static br.com.southrocklab.resources.core.PathConstants.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ApplicationTests {

    @Value("${local.server.port}")
    protected int porta;

    @Before
    public void setUp() {
        RestAssured.baseURI = APP_BASE_URL;
//        RestAssured.port = porta; // PORTA aleatoria
        RestAssured.port = APP_PORT; // PORTA 9090
        RestAssured.basePath = APP_BASE_PATH;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        RestAssured.responseSpecification = resBuilder.build();

        // Mostra log().all() em caso de falhas
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
