package StepDefs;

import Pages.DraftsPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.NewLetterPage;

abstract class AbstractStepDefs {
    private MainPage mainPage = new MainPage();
    private LoginPage loginPage = new LoginPage();
    private NewLetterPage newLetterPage = new NewLetterPage();
    private DraftsPage draftsPage = new DraftsPage();

    protected MainPage onMainPage() {
        return mainPage;
    }

    protected LoginPage onLoginForm() {
        return loginPage;
    }

    protected NewLetterPage onNewMailPage() {
        return newLetterPage;
    }

    protected DraftsPage onDraftPage() {
        return draftsPage;
    }
}