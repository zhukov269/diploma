package API;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.createDraft.*;
import models.kpmFirstStep.SaveCprType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Step;
import tests.TestBase;


import static io.restassured.RestAssured.given;

public class GetHeader extends TestBase {




    @Step ()
    @Test
    public void updateHeader() {

        CreateDraftResponse draftResponse = given().contentType(ContentType.JSON)
                .when()
                .get("https://s77wbtom001ts01.mg-tpm.rt.ru/tpmmgbackend/tpm/tpm-cpr-detail/v1/create-draft?login=anna.mikhanova") // замените на ваш эндпоинт
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
                .extract()
                .as(CreateDraftResponse.class);

//       GetHeader requestBody = new GetHeader(
//                draftResponse.getId(),
//                "06.07.2025",
//                null,
//                "Стандартный",
//                null,
//                7,
//                null,
//                "asdsa",
//                null,
//                null,
//                5,
//                "06.07.2025",
//                1,
//                "Черновик",
//                "Тест Тестовый",
//                "Перемаршрутизация МГ",
//                null,
//                null,
//                null,
//                null
//        );

        SaveCprType requestBody = new SaveCprType(
                5,
                "Перемаршрутизация МГ"
        );

        given().contentType(ContentType.JSON)
                .when()
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-cpr-type?cprId= "+ draftResponse.getId())
        ;


        given().contentType(ContentType.JSON)
                .when()
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-cpr-control-date?cprId= "+ draftResponse.getId())
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .body().asString()

                ;

          given().contentType(ContentType.JSON)
                .when()
                .get("/tpmmgbackend/tpm/tpm-cpr-detail/v1/get-header?cprId= "+ draftResponse.getId())
                .then()
                .statusCode(200)
                .log().body();  // или 200, в зависимости от ожидаемого ответа




    }
}
