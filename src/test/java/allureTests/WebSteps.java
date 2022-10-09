package allureTests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open Main page")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Find repository {repo}")
    public void searchForRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Click on link repository {repo}")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step("Check for tab {tab}")
    public void checkTab (String tab) {
        $(partialLinkText(tab)).shouldHave(text("Issues"));
    }
}
