package API;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.lombok.LoginBodyLombockModel;
import org.junit.jupiter.api.DisplayName;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static models.specs.Spec.RequestSpec;
import static models.specs.Spec.ResponseSpec;

public class Autenthication {

    protected static String token;


    @DisplayName("Аутенфикация")
    public static void LoginOn() {
        LoginBodyLombockModel authData = new LoginBodyLombockModel();
        authData.setUsername("anna.mikhanova35@rt.ru");
        authData.setPassword("anna.mikhanova35");

         token = step("Autenthication", () ->
                given(RequestSpec)
                        .contentType(ContentType.JSON)
                        .body(authData)
                        .when()
                        .post("/tpmmgbackend/authenticate")
                        .then()
                        .spec(ResponseSpec)
                        .contentType("text/plain")
                        .extract()
                        .body().asString()
        );





        step("autorization correct+ token", () ->

                given(RequestSpec)

                        .contentType(ContentType.JSON)
                        .header(new Header("Authorization", "Bearer " + token))
                        .post("/tpmmgbackend/authorize-correct")
                        .then()
                        .spec(ResponseSpec)
                        .contentType(ContentType.JSON)


        );
    }
}