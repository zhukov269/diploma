package API;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.lombok.LoginBodyLombockModel;
import org.junit.jupiter.api.DisplayName;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class Autenthication {

    protected static String token;


    @DisplayName("Аутенфикация")
    public static void LoginOn() {
        LoginBodyLombockModel authData = new LoginBodyLombockModel();
        authData.setUsername("anna.mikhanova35@rt.ru");
        authData.setPassword("anna.mikhanova35");

         token = step("Autenthication", () ->
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