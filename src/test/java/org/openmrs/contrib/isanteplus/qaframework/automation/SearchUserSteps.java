package org.openmrs.contrib.isanteplus.qaframework.automation;

import static org.junit.Assert.assertTrue;

import org.openmrs.contrib.isanteplus.qaframework.RunTest;
import org.openmrs.contrib.isanteplus.qaframework.automation.test.TestBase;
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

public class SearchUserSteps extends TestBase {

    private LoginPage loginPage;

    private SystemAdministrationPage systemPage;

    private ManageAccountsPage manageAccountsPage;

    private HomePage homePage;

    @After(RunTest.HOOK.SEARCHUSER)
    public void destroy() {
        quit();
    }

    @Before(RunTest.HOOK.SEARCHUSER)
    public void setLoginPage() {
        System.out.println("....Search User......");
        loginPage = new LoginPage(getWebDriver());
    }

    @Given("admin user logins in isante-plus and goes to Home Page")
    public void adminUserVisitLoginPage() throws Exception {
        homePage = loginPage.goToHomePage();
    }

    @When("From Main Menu, select 'System Admininstration'")
    public void systemLoadsSystemAdministrationPage() {
        systemPage = homePage.clickSystemAdministrationApp();
    }

    @And("Select ‘Manage Accounts’")
    public void visitManageAccountsAppsPage() throws Exception {
        manageAccountsPage = systemPage.goToManageAccountsPage();
    }

    @And("Enter the name of the user in the ‘Search’ text box {string}")
    public void enterUserNameToSearch(String user) throws Exception {
        manageAccountsPage.clickSearchTextBox(user);
    }

    @Then("the User table should filter, only displaying results of the search")
    public void resultsOfTheSearch() throws Exception {
        assertTrue(manageAccountsPage.containsText("John Smith"));
        assertTrue(manageAccountsPage
                .containsText("Affichage de 1 à 1 sur 1 entrées Filtré à partir de 1 entrées au total"));
    }

}
