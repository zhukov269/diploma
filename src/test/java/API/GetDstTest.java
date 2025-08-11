package API;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.getDst.Cities;
import org.json.JSONObject;
import tests.TestBase;

import static API.Autenthication.token;
import static io.restassured.RestAssured.given;
import static models.specs.Spec.RequestSpec;
import static models.specs.Spec.ResponseSpec;

public class GetDstTest extends TestBase {

    String draftId = CreateDraft.draftId;



    public static void getDst() {



//        Cities requestCities2 = new Cities(
//                "81",
//                "Тольятти",
//                "Самарская область",
//                "Волга"
//
//        );
//
//        given().contentType(ContentType.JSON)// Выбор оператора Мегафон, города Тольятти
//                .header(new Header("Authorization", "Bearer " + token))
//                .when()
//                .body(requestCities2)
//                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/city-dst") // замените на ваш эндпоинт
//                .then()
//                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
//        ;
        Cities requestCities = new Cities(
                "80",
                "Самара",
                "Самарская область",
                "Волга"

        );

        given(RequestSpec).contentType(ContentType.JSON)// Выбор оператора Мегафон, города Самара
                .header(new Header("Authorization", "Bearer " + token))
                .when()
                .body(requestCities)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/city-dst") // замените на ваш эндпоинт
                .then()
                .spec(ResponseSpec)
        ;

        JSONObject saveDst = new JSONObject()
                .put("cities", requestCities)
                .put("cprId", CreateDraft.draftId)
                .put("defs", (Object) null )
                .put("mrfs", (Object) null )
                .put("prefixes", (Object) null )
                .put("regions", (Object) null )
                .put("sourceOperators", "ПАО МЕГАФОН" )
                ;

        given(RequestSpec).contentType(ContentType.JSON)// сохранение Направления
                .header(new Header("Authorization", "Bearer " + token))
                .when()
                .body(saveDst)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-dst")
                .then()
                .spec(ResponseSpec)
        ;

    }
}
