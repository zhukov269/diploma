package API;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.getDst.Cities;
import models.getDst.SourceOperators;
import models.getDst.defDst;
import models.getDst.getDst;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static API.Autenthication.token;
import static io.restassured.RestAssured.given;

public class GetDstTest extends TestBase {


    @Step ()
    @Test
    public void getSource() {

        Cities requestCities = new Cities(
                 "80",
                "Самара",
                "Самарская область",
                "Волга"

        );



        given().contentType(ContentType.JSON)// Выбор оператора Мегафон, города Самара
                .header(new Header("Authorization", "Bearer " + token))
                .when()
                .body(requestCities)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/city-dst") // замените на ваш эндпоинт
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
        ;

        Cities requestCities2 = new Cities(
                "81",
                "Тольятти",
                "Самарская область",
                "Волга"

        );

        given().contentType(ContentType.JSON)// Выбор оператора Мегафон, города Тольятти
                .header(new Header("Authorization", "Bearer " + token))
                .when()
                .body(requestCities2)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/city-dst") // замените на ваш эндпоинт
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
        ;

        

        given().contentType(ContentType.JSON)// сохранение Источника
                .header(new Header("Authorization", "Bearer " + token))
                .when()
                .body(requestCities)
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-dst") // замените на ваш эндпоинт
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
        ;

    }
}
