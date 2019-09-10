package StepDefs;

import Pages.DraftsPage;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.NewMailPage;

public abstract class AbstractStepDefs {
	private MainPage mainPage = new MainPage();
	private LoginPage loginPage = new LoginPage();
	private NewMailPage newMailPage = new NewMailPage();
	private DraftsPage draftsPage = new DraftsPage();

	public MainPage onMainPage() {
		return mainPage;
	}

	public LoginPage onLoginForm() {
		return loginPage;
	}

	public NewMailPage onNewMailPage() {
		return newMailPage;
	}

	public DraftsPage onDraftPage() {
		return draftsPage;
	}
}