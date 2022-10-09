package allureTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = true;
    }
    @Test
    @Feature("Visible tab Issue on repo")
    @Story("Crwate Issue in repo")
    @Owner("tmaksyutov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Create Issue")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("tmaksyutov/hw_work_with_files");
        $(".header-search-input").submit();

        $(linkText("tmaksyutov/hw_work_with_files")).click();
        $(partialLinkText("Issues")).shouldHave(text("Issues"));
    }
}
