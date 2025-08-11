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
import static models.specs.Spec.RequestSpec;
import static models.specs.Spec.ResponseSpec;

public   class CreateDraft extends TestBase {
    public static String draftId;

    public static   void createDraft() {

        LoginBodyLombockModel authData = new LoginBodyLombockModel();
        authData.setUsername("anna.mikhanova35@rt.ru");
        authData.setPassword("anna.mikhanova35");

        step("autorization correct+ token", () ->

                given(RequestSpec)

                        .contentType(ContentType.JSON)
                        .header(new Header("Authorization", "Bearer " + token))
                        .post("/tpmmgbackend/authorize-correct")
                        .then()
                        .spec(ResponseSpec)
                        .contentType(ContentType.JSON)


        );
        // Нажимаем кнопку "Создать новый КПМ"
        CreateDraftResponse draftResponse = given(RequestSpec).contentType(ContentType.JSON)
                .when()
                .header(new Header("Authorization", "Bearer " + token))
                .post("https://s77wbtom001ts01.mg-tpm.rt.ru/tpmmgbackend/tpm/tpm-cpr-detail/v1/create-draft?login=anna.mikhanova") // замените на ваш эндпоинт
                .then()
                .spec(ResponseSpec)
                .extract()
                .as(CreateDraftResponse.class);
        draftId = draftResponse.getId();
    }

}
