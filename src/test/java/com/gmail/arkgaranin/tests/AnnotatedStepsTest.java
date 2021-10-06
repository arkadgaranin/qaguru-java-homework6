package com.gmail.arkgaranin.tests;

import com.gmail.arkgaranin.pages.IssueTab;
import com.gmail.arkgaranin.pages.MainPage;
import com.gmail.arkgaranin.pages.ResultsPage;
import org.junit.jupiter.api.Test;

public class AnnotatedStepsTest extends BaseTest {

    private final static String REPOSITORY = "allure-framework/allure2";
    private final static String ISSUE_NAME = "Allure report generated failure in azure pipeline";

    @Test
    public void checkIssueNameInRepoTest() {
        MainPage mainPage = new MainPage();
        ResultsPage resultsPage = new ResultsPage();
        IssueTab issueTab = new IssueTab();

        mainPage
                .openMainPage()
                .searchRepository(REPOSITORY);

        resultsPage.goToRepository(REPOSITORY);

        issueTab
                .openIssueTab()
                .checkIssueWithName(ISSUE_NAME);
    }
}