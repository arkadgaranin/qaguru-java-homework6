package com.gmail.arkgaranin.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest extends BaseTest {

    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Allure report generated failure in azure pipeline";

    @Test
    public void checkIssueNameInRepoTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");
        $("[name=q]").as("Поисковая строка").setValue(REPOSITORY).submit();
        $(byLinkText(REPOSITORY)).as("Ссылка репозитория").click();
        $(byPartialLinkText("Issues")).as("Таб Issues").click();
        $(byText(ISSUE_NAME)).as("Issue c названием " + ISSUE_NAME).shouldBe(Condition.visible);
    }
}