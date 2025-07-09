package API;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.createDraft.CreateDraftResponse;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.restassured.RestAssured.given;

public class GetSource extends TestBase {


    @Step ()
    @Test
    public void getSource() {
         given().contentType(ContentType.JSON)
                .when()
                .get("tpmmgbackend/tpm/tpm-cpr-detail/v1/get-source?cprId=") // замените на ваш эндпоинт
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
             ;
    }
}
