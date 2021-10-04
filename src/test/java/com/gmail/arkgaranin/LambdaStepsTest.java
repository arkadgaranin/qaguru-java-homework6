package com.gmail.arkgaranin;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends BaseTest {

    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Allure report generated failure in azure pipeline";

    @Test
    public void checkIssueNameInRepoTest() {
        step("Открытие главной стр-цы github", () -> {
            open("/");
        });

        step("Поиск репозитория " + REPOSITORY, () -> {
            $("[name=q]").setValue(REPOSITORY).submit();
        });

        step("Переход в репозиторий " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });

        step("Открытие раздела Issues", () -> {
            $(byPartialLinkText("Issues")).click();
        });

        step("Проверка наличия Issue c названием " + ISSUE_NAME, () -> {
            $(byText(ISSUE_NAME)).shouldBe(Condition.visible);
        });
    }
}