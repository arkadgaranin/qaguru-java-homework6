package com.gmail.arkgaranin.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    @Step("Открытие главной стр-цы github")
    public MainPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Поиск репозитория {repository}")
    public void searchRepository(String repository) {
        $("[name=q]").setValue(repository).submit();
    }
}