package API;

import io.restassured.http.ContentType;
import models.createDraft.*;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Step;
import tests.TestBase;

import static io.restassured.RestAssured.given;

public class CreateDraft extends TestBase {


    @Step ()
    @Test
    public void createDraft() {
        CreateDraftResponse userResponse = given().contentType(ContentType.JSON)
                .when()
                .get("https://s77wbtom001ts01.mg-tpm.rt.ru/tpmmgbackend/tpm/tpm-cpr-detail/v1/create-draft?login=anna.mikhanova") // замените на ваш эндпоинт
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
                .extract()
                .as(CreateDraftResponse.class);
        userResponse.getId();
    }
}
