package com.gmail.arkgaranin.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsPage {

    @Step("Переход в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(byLinkText(repository)).click();
    }
}