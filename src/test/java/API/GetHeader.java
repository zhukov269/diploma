package API;



import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import models.createDraft.*;
import models.kpmFirstStep.SaveCprType;
import tests.TestBase;


import static API.Autenthication.token;
import static io.restassured.RestAssured.given;
import static java.lang.Thread.sleep;

public class GetHeader extends TestBase {

    String draftId = CreateDraft.draftId;






    public static void updateHeader() {





        SaveCprType requestBody = new SaveCprType(
                5,
                "Перемаршрутизация МГ"
        );

        given().contentType(ContentType.JSON)// Перемаршутизация МГ
                .when()
                .header(new Header("Authorization", "Bearer " + token))
                .body(requestBody)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-cpr-type?cprId="+ CreateDraft.draftId )
                .then()
                .statusCode(200)
                .log().all()

        ;

        try {
            Thread.sleep(1000); // Добавлена обработка InterruptedException
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
            throw new RuntimeException("Thread was interrupted", e);
        }


//        given().contentType(ContentType.JSON)// контрольная Дата
//                .when()
//                .header(new Header("Authorization", "Bearer " + token))
//                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-cpr-control-date?cprId= "+ draftResponse.getId())
//                .then()
//                .contentType(ContentType.JSON)
//                .extract()
//                .body().asString()
//
//                ;

//          given().contentType(ContentType.JSON)// Сохранение первого шага КПМ
//                .when()
//                  .header(new Header("Authorization", "Bearer " + token))
//                .get("/tpmmgbackend/tpm/tpm-cpr-detail/v1/get-header?cprId="+ 31500)
//                .then()
//                .statusCode(200)
//                .log().body();  // или 200, в зависимости от ожидаемого ответа




    }
}
