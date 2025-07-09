package tests;

import API.CreateDraft;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.lombok.LoginBodyLombockModel;
import models.lombok.LoginResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;

public class Autorizathion extends TestBase {

//    String login= "";
//    String password= "anna.mikhanova2";

    @Test

    @DisplayName("Аутенфикация")
    void Autenthication() {
        LoginBodyLombockModel authData = new LoginBodyLombockModel();
        authData.setUsername("anna.mikhanova35@rt.ru");
        authData.setPassword("anna.mikhanova35");

        String token = step("Autenthication", () ->
                given()
                        .filter(withCustomTemplates())
                        .contentType(ContentType.JSON)
                        .body(authData)
                        .log().body()
                        .when()
                        .post("/tpmmgbackend/authenticate")
                        .then()
                        .contentType("text/plain")
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .body().asString()
        );


        LoginResponse response = new LoginResponse();


        step("autorization correct+ token", () ->

                given()
                        .log().headers()
                        .log().body()

                        .contentType(ContentType.JSON)
                        .header(new Header("Authorization", "Bearer " + token))
                        .post("/tpmmgbackend/authorize-correct")
                        .then()
                        .contentType(ContentType.JSON)
                        .log().all()

                        );


    }


}

