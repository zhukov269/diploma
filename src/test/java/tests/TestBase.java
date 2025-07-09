package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {


    @BeforeAll
    public static void setBrowserParams() {
        RestAssured.baseURI = "https://s77wbtom001ts01.mg-tpm.rt.ru/";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("version", "127.0");
//        Configuration.browserSize = System.getProperty("resolution", "1920x1080");
//        Configuration.remote = "https://"
//                + System.getProperty("selenoidCredentials", "user1:1234@")
//                + System.getProperty("selenoidUrl", "selenoid.autotests.cloud")
//                + "/wd/hub";
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
//    }
//
//    @BeforeEach
//    public void addAllureSelenideListener() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }
//
//    @AfterEach
//    public void getAttachAndCloseDriver() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//        closeWebDriver();
//    }

    }
}
