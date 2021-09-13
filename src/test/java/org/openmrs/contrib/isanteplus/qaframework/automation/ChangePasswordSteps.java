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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

	@Given("User vists the Home Page and goes to System Administration Page")
	public void userVisitLoginPage() throws Exception {
		homePage = loginPage.goToHomePage();
		systemPage = homePage.clickSystemAdministrationApp();
	}

	@Then("the system loads system administration page")
	public void systemLoadsSystemAdministrationPage() {
		 assertTrue(systemPage.containsText("System Administration"));

	}

	@When("User goes to Manage Accounts App")
	public void visitManageAccountsAppsPage() throws Exception {
		manageAccountsPage = systemPage.goToManageAccountsPage();
	}

	@Then("the system loads manage acccount page")
	public void systemLoadsManageAccountsPage() {
		assertTrue(manageAccountsPage.containsText("Manage Accounts"));
	}

	@And("User clicks edit button action")
	public void userClicksEditButton() throws Exception {
		accountsPage = manageAccountsPage.editAccount();
	}

	@Then("the system loads account page")
	public void systemLoadsAddNewAccountPage() {
		assertTrue(accountsPage.containsText("Edit Account"));
	}

	@And("User clicks on modifier under user account detaials")
	public void modifyAccount() throws Exception {
		accountsPage.clickEditButton();
	}

}