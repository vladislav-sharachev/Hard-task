package StepDefs;

import Pages.DraftsPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.NewLetterPage;

public abstract class AbstractStepDefs {
    private MainPage mainPage = new MainPage();
    private LoginPage loginPage = new LoginPage();
    private NewLetterPage newLetterPage = new NewLetterPage();
    private DraftsPage draftsPage = new DraftsPage();

    public MainPage onMainPage() {
        return mainPage;
    }

    public LoginPage onLoginForm() {
        return loginPage;
    }

    public NewLetterPage onNewMailPage() {
        return newLetterPage;
    }

    public DraftsPage onDraftPage() {
        return draftsPage;
    }
}