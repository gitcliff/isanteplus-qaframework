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

public class DeleteUserSteps extends TestBase {

    private LoginPage loginPage;

    private SystemAdministrationPage systemPage;

    private ManageAccountsPage manageAccountsPage;

    private AccountsPage accountsPage;

    private HomePage homePage;

    @After(RunTest.HOOK.DELETEUSER)
    public void destroy() {
        quit();
    }

    @Before(RunTest.HOOK.DELETEUSER)
    public void setLoginPage() {
        System.out.println(".... Delete user......");
        loginPage = new LoginPage(getWebDriver());
    }

    @Given("new admin user logins in isante-plus and goes to Home Page")
    public void adminUserVisitLoginPage() throws Exception {
        homePage = loginPage.goToHomePage();
    }

    @When("From Main Menu admin user selects 'System Admininstration'")
    public void systemLoadsSystemAdministrationPage() {
        systemPage = homePage.clickSystemAdministrationApp();
    }

    @And("Search for user or find a user in the user table {string}")
    public void searchForTheUser(String user) {
        manageAccountsPage = systemPage.goToManageAccountsPage();
        manageAccountsPage.clickSearchTextBox(user);
    }

    @And("Click the pencil icon in the ‘Action’ column next to the desired user name")
    public void clickThePencilIcon() throws Exception {
        accountsPage = manageAccountsPage.goToAccountsPage();
    }

    @And("Click ‘Retire’ under user account details")
    public void clickRetireUnderUserAccountDetails() throws Exception {
        accountsPage.retireUser();
    }

    @And("Enter Reason {string}")
    public void enterTheReason(String reason) throws Exception {
        accountsPage.retireReason(reason);
    }

    @And("Select 'To confirm")
    public void enterToConfirm() throws Exception {
        accountsPage.clickConfimButton();
    }

    @Then("Notification ‘Retire avec success’ and the user’s account details  appear crossed out")
    public void retireMessage() throws Exception {
        accountsPage.containsText("Retire avec success");
    }

}