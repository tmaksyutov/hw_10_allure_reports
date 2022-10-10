package allureTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsTest {
    private static final String REPOSITORY = "tmaksyutov/hw_work_with_files";
    private static final String ISSUES = "Issues";

    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
        });

        step("Поиск репозитория " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Кликнуть на репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Проверить таб " + ISSUES, () ->{
            $(partialLinkText(ISSUES)).shouldHave(text("Issues"));
        });

    }
}
