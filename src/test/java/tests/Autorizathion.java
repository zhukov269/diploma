package tests;

import API.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class Autorizathion extends TestBase {

    @BeforeAll
    static void  setup() {
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

@Test


    void AllTests() {



         step("Autenthication", () ->
                Autenthication.LoginOn()
        );


        step("Содать Новый КПМ", () ->
        CreateDraft.createDraft()
        );

        step("Сохранить первый шаг КПМ", () ->
                GetHeader.updateHeader()
        );

        step("Сохранить источник КПМ", () ->
                GetSource.getSource()
        );

//        step("Сохранить направление КПМ", () ->
//                GetDstTest.getDst()
//        );


    }


}

