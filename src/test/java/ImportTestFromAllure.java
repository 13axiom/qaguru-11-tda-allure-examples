import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportTestFromAllure {
    @Test
    @AllureId("9996")
    @DisplayName("Login Test")
    @Tags({@Tag("average"), @Tag("integration"), @Tag("asap"), @Tag("login")})
    @Owner("allure8")
    void loginTestImportedFromAllureTestOps() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        step("Open login page", () -> {
            open("https://trade.mangotrade.com");
        });
        step("Set identifier", () -> {
            $("[name=identifier]").setValue("mnenie@bk.ru");
        });
        step("Set password", () -> {
            $("[name=password]").setValue("Test1234");
        });
        step("Click button \"Log in\"", () -> {
            $("[data-test-id=login-submit-button]").click();
            sleep(5000);
        });

        step("Check ER:", () -> {

            step("User has logged");

            step("Redirect to 'https://trade.mangotrade.com/traderoom'", () -> {
                String currURL = getWebDriver().getCurrentUrl().toString();
                assertEquals("https://trade.mangotrade.com/traderoom", currURL);
            });
        });

    }
}
