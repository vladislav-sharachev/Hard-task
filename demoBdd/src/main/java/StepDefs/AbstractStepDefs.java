package StepDefs;

import Pages.LoginPage;
import Pages.MainPage;

public abstract class AbstractStepDefs {
	private MainPage mainPage = new MainPage();
	private LoginPage loginPage = new LoginPage();

	public MainPage onMainPage() {
		return mainPage;
	}

	public LoginPage onLoginForm() {
		return loginPage;
	}
}