package API;



import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.createDraft.*;
import models.kpmFirstStep.SaveCprType;
import tests.TestBase;


import static API.Autenthication.token;
import static io.restassured.RestAssured.given;
import static java.lang.Thread.sleep;

public class GetHeader extends TestBase {






    public static void updateHeader() {

        CreateDraftResponse draftResponse = given().contentType(ContentType.JSON)
                .when()
                .header(new Header("Authorization", "Bearer " + token))
                .get("https://s77wbtom001ts01.mg-tpm.rt.ru/tpmmgbackend/tpm/tpm-cpr-detail/v1/create-draft?login=anna.mikhanova")
                .then()
                .log().all()
                .extract()
                .as(CreateDraftResponse.class);



        SaveCprType requestBody = new SaveCprType(
                5,
                "Перемаршрутизация МГ"
        );

        given().contentType(ContentType.JSON)// Перемаршутизация МГ
                .when()
                .header(new Header("Authorization", "Bearer " + token))
                .body(requestBody)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-cpr-type?cprId="+ draftResponse.getId())
                .then()
                .statusCode(200)

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
//                .get("/tpmmgbackend/tpm/tpm-cpr-detail/v1/get-header?cprId="+ draftResponse.getId())
//                .then()
//                .statusCode(200)
//                .log().body();  // или 200, в зависимости от ожидаемого ответа




    }
}
