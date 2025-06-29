import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.lombok.LoginBodyLombockModel;
import models.lombok.LoginResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;

public class Autorizathion {

//    String login= "";
//    String password= "anna.mikhanova2";

    @Test
    @DisplayName("Аутенфикация")
     void Autenthication() {
        LoginBodyLombockModel authData = new LoginBodyLombockModel();
        authData.setEmail("anna.mikhanova2@rt.ru");
        authData.setPassword("anna.mikhanova2");

        LoginResponse response = step("Autenthication", ()->
                given()
                        .filter(withCustomTemplates()))
                 .contentType("text/plain;charset=UTF-8")
//                .baseUri("https://s77wbtom001ts01.mg-tpm.rt.ru/")
                .body(authData)
                .log().body()
                .when()
                .post("https://s77wbtom001ts01.mg-tpm.rt.ru/tpmmgbackend/authenticate")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body().as(LoginResponse.class);

         );

        step("autorization correct+ token"), ()->

        given()
                .header(new Header("Authorization", "Bearer" + response.getToken());
                .contentType(ContentType.JSON)
                .log().headers()
                .log().body()


       ) ;


    }

}

