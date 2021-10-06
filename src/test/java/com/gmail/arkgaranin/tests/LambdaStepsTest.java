package com.gmail.arkgaranin.tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("arkgaranin")
public class LambdaStepsTest extends BaseTest {

    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Allure report generated failure in azure pipeline";

    @Test
    @Story("Поиск по Issues")
    @Link(name = "Главная стр-ца", url = "https://github.com/")
    @DisplayName("Проверка поиска конкретной Issue")
    @Severity(SeverityLevel.BLOCKER)
    public void checkIssueNameInRepoTest() {
        step("Открытие главной стр-цы github", () -> {
            open("/");
            takeScreenshot();
            takePageSource();
        });

        step("Поиск репозитория " + REPOSITORY, () -> {
            $("[name=q]").setValue(REPOSITORY).submit();
            takeScreenshot();
            takePageSource();
        });

        step("Переход в репозиторий " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
            addAttachment("This is attachment", "image/png");
            takePageSource();
        });

        step("Открытие раздела Issues", () -> {
            $(byPartialLinkText("Issues")).click();
            takeScreenshot();
            takePageSource();
        });

        step("Проверка наличия Issue c названием " + ISSUE_NAME, () -> {
            $(byText(ISSUE_NAME)).shouldBe(Condition.visible);
            takeScreenshot();
            takePageSource();
        });
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(value = "Страница", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }
}