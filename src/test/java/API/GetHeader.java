package API;



import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.kpmFirstStep.SaveCprType;
import tests.TestBase;
import static API.Autenthication.token;
import static io.restassured.RestAssured.given;
import static models.specs.Spec.RequestSpec;
import static models.specs.Spec.ResponseSpec;

public class GetHeader extends TestBase {

    String draftId = CreateDraft.draftId;

    public static void updateHeader() {

        SaveCprType requestBody = new SaveCprType(
                5,
                "Перемаршрутизация МГ"
        );

        given(RequestSpec).contentType(ContentType.JSON)// Перемаршутизация МГ
                .when()
                .header(new Header("Authorization", "Bearer " + token))
                .body(requestBody)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-cpr-type?cprId="+ CreateDraft.draftId )
                .then()
                .spec(ResponseSpec)

        ;


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

          given(RequestSpec).contentType(ContentType.JSON)// Сохранение первого шага КПМ
                .when()
                  .header(new Header("Authorization", "Bearer " + token))
                .get("/tpmmgbackend/tpm/tpm-cpr-detail/v1/get-header?cprId="+  CreateDraft.draftId)
                .then().spec(ResponseSpec);




    }
}
