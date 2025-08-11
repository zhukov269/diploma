package API;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.json.JSONObject;

import tests.TestBase;



import static API.Autenthication.token;
import static io.restassured.RestAssured.given;
import static models.specs.Spec.RequestSpec;
import static models.specs.Spec.ResponseSpec;


public class GetSource extends TestBase {
    String draftId = CreateDraft.draftId;




    public static void getSource() {
         given(RequestSpec).contentType(ContentType.JSON)// Выбор группы операторов "Национальные"
                 .header(new Header("Authorization", "Bearer " + token))
                .when()
                .get("/tpmmgbackend/tpm/tpm-cpr-detail/v1/source-oper-gr-dropbox?typeId=5")
                .then()
                 .spec(ResponseSpec)
             ;

        JSONObject bodyJO = new JSONObject()
                .put("cprId",CreateDraft.draftId)
                .put("typeId",5)
                .put("sourceOperators",(Object) null)
                .put("switchId",(Object) null)
                .put("trunkGroupId",(Object) null)
                .put("typeB",(Object) null)
                .put("operatorGroupId",new int[]{61});


        given(RequestSpec).contentType(ContentType.JSON)// сохранение Источника
                .header(new Header("Authorization", "Bearer " + token))
                .when()
                .body(bodyJO.toString())
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-source")
                .then()
                .spec(ResponseSpec)
        ;

    }
}
