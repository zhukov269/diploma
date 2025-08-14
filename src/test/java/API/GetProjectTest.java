package API;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.getDst.Cities;
import models.getProject.Switches;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static API.Autenthication.token;
import static io.restassured.RestAssured.given;

//public class GetProjectTest extends TestBase {
//
//
//    @Step ()
//    @Test
//    public void getSource() {
//
//        Switches requestSwitches = new  Switches(
//                 "2769",
//                "ТМгУС-6/1",
//                "7"
//
//        );
//
//
//
//        given().contentType(ContentType.JSON)// Выбор станции "ТМгУС-6/1"
//                .header(new Header("Authorization", "Bearer " + token))
//                .when()
//                .body(requestSwitches)
//                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/drop-box-tg") // замените на ваш эндпоинт
//                .then()
//                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
//        ;
//
//        Switches requestSwitches2 = new  Switches(
//                "2719",
//                "ТМгУС-6",
//                "2"
//
//        );
//
//
//
//        given().contentType(ContentType.JSON)// Выбор станции "ТМгУС-6"
//                .header(new Header("Authorization", "Bearer " + token))
//                .when()
//                .body(requestSwitches2)
//                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/drop-box-tg") // замените на ваш эндпоинт
//                .then()
//                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
//        ;
//
//
//
//
//        ;
//
//    }
//}
