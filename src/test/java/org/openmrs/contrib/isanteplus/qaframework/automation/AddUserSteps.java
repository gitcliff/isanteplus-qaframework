package org.openmrs.contrib.isanteplus.qaframework.automation;

import static org.junit.Assert.assertTrue;

import org.openmrs.contrib.isanteplus.qaframework.RunTest;

import org.openmrs.contrib.isanteplus.qaframework.automation.page.AccountsPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.test.TestBase;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.HomePage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.LoginPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.ManageAccountsPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.SystemAdministrationPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddUserSteps extends TestBase {

	private LoginPage loginPage;

	private SystemAdministrationPage systemPage;

	private ManageAccountsPage manageAccountsPage;

	private AccountsPage accountsPage;

	private HomePage homePage;

	@After(RunTest.HOOK.ADDUSER)
	public void destroy() {
		quit();
	}

	@Before(RunTest.HOOK.ADDUSER)
	public void setLoginPage() {
		System.out.println(".... User Login......");
		loginPage = new LoginPage(getWebDriver());
	}

	@Given("client logs into Isanteplus application and goes to the Home page")
	public void clientVisitLoginPage() throws Exception {
		homePage = loginPage.goToHomePage();
	}

	@When("From the main menu select System Administration app")
	public void systemLoadsSystemAdministrationPage() throws Exception {
		systemPage = homePage.clickSystemAdministrationApp();
	}

	@And("Select Manage Accounts App and goes to Manage Accounts page")
	public void visitManageAccountsAppsPage() throws Exception {
		manageAccountsPage = systemPage.goToManageAccountsPage();
	}

	@And("Click add new account")
	public void clickAddAccount() throws Exception {
		accountsPage = manageAccountsPage.clickAddAccount();
	}

	@And("Enter name,firstname and sex {string} {string}")
	public void enterPersonDetails(String name, String firstName) throws Exception {
		accountsPage.enterName(name);
		accountsPage.enterFirstName(firstName);
		accountsPage.clickGenderButton();
	}

	@And("Click the checkbox next to add user account")
	public void enableAddUserAccount() throws Exception  {
		accountsPage.addUserIsChecked();
	}

	@And("Enter a username {string}")
	public void enterUsername(String userName) throws Exception {
		accountsPage.enterUserName(userName);
	}

	@And("Select 'full' under privillage level {string} {string} {string}")
	public void enterPrivillage(String privillage, String password, String confirmPassword) throws Exception {
		accountsPage.selectPrevillageLevel(privillage);
		accountsPage.enterPassword(password);
		accountsPage.confirmPassword(confirmPassword);
	}

	@And("click force password")
	public void forceChangePassword() throws Exception  {
		accountsPage.checkForcePassword();
	}

	@And("select the checkboxes under ‘capacites’ with the appropriate privileges based on roles defined")
	public void checkRoles() throws Exception  {
		accountsPage.administerSystemIsChecked();
	}

	@And("Click the checkbox next to ‘Add a supplier account?")
	public void checkAddSupplierAccount() throws Exception  {
		accountsPage.addSupplierAccountIsChecked();
	}

	@And("Enter the same username as entered above in ‘Identifier’ field {string}")
	public void enterUserNameInIdentify(String identify) throws Exception  {
		accountsPage.enterIdentifier(identify);
	}

	@And("Select the relevant role under ‘service provider role’ {string}")
	public void selectProviderRole(String role) throws Exception {
		accountsPage.selectProviderRole(role);
	}

	@And("click save")
	public void saveNewUserAccount() throws Exception {
		accountsPage.saveAccount();
	}

	@Then("User redirected to the ‘Gerer les comptes’ page and user appears in the user table")
	public void saveNewUserrAccount() throws Exception {
		 assertTrue(manageAccountsPage.containsText("Ajouter un nouveau compte"));
	}

}
