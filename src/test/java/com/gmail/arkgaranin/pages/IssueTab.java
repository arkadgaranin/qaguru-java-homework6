package com.gmail.arkgaranin.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class IssueTab {

    @Step("Открытие раздела Issues")
    public IssueTab openIssueTab() {
        $(byPartialLinkText("Issues")).click();
        return this;
    }

    @Step("Проверка наличия Issue c названием {issueName}")
    public void checkIssueWithName(String issueName) {
        $(byText(issueName)).shouldBe(Condition.visible);
    }
}