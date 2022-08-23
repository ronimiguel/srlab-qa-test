package br.com.southrocklab.resources.core;


import io.restassured.http.ContentType;

public interface PathConstants {
    final String APP_BASE_URL = "http://localhost";
    final Integer APP_PORT = 9090;
    final String APP_BASE_PATH = "";
    final String APP_CUSTOMER_PATH = "/customer";
    final String APP_CARD_PATH = "/card";
    final ContentType APP_CONTENT_TYPE = ContentType.JSON;
}
