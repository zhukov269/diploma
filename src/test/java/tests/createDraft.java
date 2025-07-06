package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.createDraft.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class createDraft {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.example.com ";
    }

    @Step ()
    @Test
    public void sendCreateRequest() {
//        NewDraft request = new NewDraft(
//                30966,
//                "29.06.2025",
//                null,
//                "Стандартный",
//                null,
//                7,
//                null,
//                null,
//                null,
//                null,
//                0,
//                null,
//                1,
//                "Черновик",
//                "Тест Тестовый",
//                null,
//                null,
//                null,
//                null,
//                null
//        );

        given()
                .contentType(ContentType.JSON)
//                .body(request)
                .when()
                .post("https://s77wbtom001ts01.mg-tpm.rt.ru/tpmmgbackend/tpm/tpm-cpr-detail/v1/create-draft?login=anna.mikhanova") // замените на ваш эндпоинт
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
                .log().body();
    }
}
