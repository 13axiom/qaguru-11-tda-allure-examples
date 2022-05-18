import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ImportTestFromAllure {
    @Test
    @AllureId("9996")
    @DisplayName("Login Test")
    @Tags({@Tag("average"), @Tag("integration"), @Tag("asap"), @Tag("login")})
    @Owner("allure8")
    void loginTestImportedFromAllureTestOps() {
        step("Open login page", () -> {
            open("https://url.url");
        });
        step("Enter user_name", () -> {
            $("#name").setValue("admin");
        });
        step("Enter user_password", () -> {
            $("#password").setValue("123");
        });
        step("Click button \"Submit\"", () -> {
            $("#submit").click();
        });

        step("Check ER:", () -> {
            step("User has logged", () ->
                    $("#header").shouldHave(Condition.exactText("User has logged"));
        });
        step("In main menu-bar user_name = Admin", () -> {
            $("#user-bar").shouldHave(Condition.exactText("Admin"));
        });
    });
}
}
