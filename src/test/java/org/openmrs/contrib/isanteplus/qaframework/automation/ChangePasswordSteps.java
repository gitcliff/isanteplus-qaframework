package org.openmrs.contrib.isanteplus.qaframework.automation;

import static org.junit.Assert.assertTrue;

import org.openmrs.contrib.isanteplus.qaframework.RunTest;
import org.openmrs.contrib.isanteplus.qaframework.automation.test.TestBase;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.AccountsPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.HomePage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.LoginPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.ManageAccountsPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.SystemAdministrationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ChangePasswordSteps extends TestBase {

	private LoginPage loginPage;

	private SystemAdministrationPage systemPage;

	private ManageAccountsPage manageAccountsPage;

	private AccountsPage accountsPage;

	private HomePage homePage;

	@After(RunTest.HOOK.PASSWORD)
	public void destroy() {
		quit();
	}

	@Before(RunTest.HOOK.PASSWORD)
	public void setLoginPage() {
		loginPage = new LoginPage(getWebDriver());
	}

	@When("user logs into Isanteplus application and goes to the Home page")
	public void userVisitLoginPage() throws Exception {
		homePage = loginPage.goToHomePage();
	}

	@And("user clicks System Administration")
	public void systemLoadsSystemAdministrationPage() {
		systemPage = homePage.clickSystemAdministrationApp();
		assertTrue(systemPage.containsText("System Administration"));

	}

	@And("User clicks Manage Accounts App and goes to Manage Accounts page")
	public void visitManageAccountsAppsPage() throws Exception {
		manageAccountsPage = systemPage.goToManageAccountsPage();
		assertTrue(manageAccountsPage.containsText("Manage Accounts"));
	}

	@And("User clicks edit button action and goes to account page")
	public void userClicksEditButton() throws Exception {
		accountsPage = manageAccountsPage.editAccount();
		assertTrue(accountsPage.containsText("Edit Account"));

	}

	@And("User clicks on modifier under user account detaials")
	public void modifyAccount() throws Exception {
		accountsPage.clickEditButton();
	}

	@And("User enters username {string}")
	public void enterUsername(String userName) {
		accountsPage.enterUserName(userName);
	}

}