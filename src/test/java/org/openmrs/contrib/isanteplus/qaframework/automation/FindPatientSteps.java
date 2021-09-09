package org.openmrs.contrib.isanteplus.qaframework.automation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openmrs.contrib.isanteplus.qaframework.RunTest;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.ClinicianFacingPatientDashboardPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.FindPatientPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.HomePage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.LoginPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.test.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class FindPatientSteps extends TestBase {
	
	private ClinicianFacingPatientDashboardPage dashboardPage;
	
	private FindPatientPage findPatientPage;
	
	private LoginPage loginPage;
	
	private HomePage homePage;
	
	@Before(RunTest.HOOK.FINDPATIENT)
	public void setUp() {
		loginPage = new LoginPage(getWebDriver());
	}
	
	@After(RunTest.HOOK.FINDPATIENT)
	public void destroy() {
		quit();
	}
	
	@Given("User logs in the system")
	public void userVisitLoginPage() throws Exception {
		homePage = loginPage.goToHomePage();
    }
	
	@And("User clicks on Find Patient App")
	public void clickOnFindPatientRecordApp() {
		findPatientPage = (FindPatientPage) homePage.clickOnFindPatientRecordApp().waitForPage();
	}
	
	@And("User enters missing patient")
	public void enterMissingPatient() {
		findPatientPage.enterPatientName("MissingPatient");
	}
	
	@Then("Search Page returns no patients")
	public void noPatients() {
		assertTrue(findPatientPage.containsText("No matching records found"));
	}
	
	@And("User enters James Smith")
	public void enterJohnSmith() {
		findPatientPage.enterPatientName("James Smith");
	}
	
	@Then("Search Page returns patients")
	public void returnResults() {
		firstPatientIdentifier = findPatientPage.getFirstPatientIdentifier();
		assertNotNull(firstPatientIdentifier);
	}
	
	@And("User clicks on first patient")
	public void clickFirstPatient() {
		dashboardPage = findPatientPage.clickOnFirstPatient();
	}
	
	@Then("System loads patient dashboard")
	public void loadPatientDashboard() {
		matchPatientIds(firstPatientIdentifier);
	}
	
}
