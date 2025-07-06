package tests;

import io.restassured.http.ContentType;
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

      void  Autenthication() {
        LoginBodyLombockModel authData = new LoginBodyLombockModel();
        authData.setUsername("anna.mikhanova2@rt.ru");
        authData.setPassword("anna.mikhanova2");

//        step("Autenthication", ()->
        String token =  given()
                        .filter(withCustomTemplates())
                        .contentType(ContentType.JSON)
                        .baseUri("https://s77wbtom001ts01.mg-tpm.rt.ru/")
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



        ;
        LoginResponse response = new LoginResponse();

//        step("autorization correct+ token", ()->
//
//        given()
//                .contentType(ContentType.JSON)
////                .header(new Header("Authorization", "Bearer" + response.getToken())
////                .log().headers()
//                .log().body()
//
//
//       ) );


    }


}

