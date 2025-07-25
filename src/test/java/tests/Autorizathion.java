package tests;

import API.Autenthication;
import API.CreateDraft;

import API.GetHeader;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.lombok.LoginBodyLombockModel;
import models.lombok.LoginResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;

public class Autorizathion extends TestBase {



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


    }


}

