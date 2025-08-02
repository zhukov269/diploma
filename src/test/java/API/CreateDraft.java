package API;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.createDraft.*;
import models.lombok.LoginBodyLombockModel;
import models.lombok.LoginResponse;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Step;
import tests.TestBase;

import static API.Autenthication.token;
import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public   class CreateDraft extends TestBase {
    public static String draftId;








    public static   void createDraft() {

        LoginBodyLombockModel authData = new LoginBodyLombockModel();
        authData.setUsername("anna.mikhanova35@rt.ru");
        authData.setPassword("anna.mikhanova35");




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
        // Нажимаем кнопку "Создать новый КПМ"
        CreateDraftResponse draftResponse = given().contentType(ContentType.JSON)
                .when()
                .header(new Header("Authorization", "Bearer " + token))
                .post("https://s77wbtom001ts01.mg-tpm.rt.ru/tpmmgbackend/tpm/tpm-cpr-detail/v1/create-draft?login=anna.mikhanova") // замените на ваш эндпоинт
                .then()
                .log().all()
                .statusCode(200)// или 200, в зависимости от ожидаемого ответа
                .extract()
                .as(CreateDraftResponse.class);
        draftId = draftResponse.getId();
    }

}
