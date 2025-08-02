package API;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.getSource.saveSource;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static API.Autenthication.token;
import static io.restassured.RestAssured.given;

public class GetSource extends TestBase {




    public static void getSource() {
         given().contentType(ContentType.JSON)// Выбор группы операторов "Национальные"
                 .header(new Header("Authorization", "Bearer " + token))
                .when()
                .get("/tpmmgbackend/tpm/tpm-cpr-detail/v1/source-oper-gr-dropbox?typeId=5")
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
             ;

        saveSource requestTypeID = new saveSource(
                5
        );

        given().contentType(ContentType.JSON)// сохранение Источника
                .header(new Header("Authorization", "Bearer " + token))
                .when()
                .post("/tpmmgbackend/tpm/tpm-cpr-detail/v1/save-source")
                .then()
                .statusCode(200) // или 200, в зависимости от ожидаемого ответа
        ;

    }
}
