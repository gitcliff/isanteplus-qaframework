package org.openmrs.contrib.isanteplus.qaframework.automation;

import static org.junit.Assert.assertNotNull;

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
	
	private ClinicianFacingPatientDashboardPage dashbaordPage;
	
	private  FindPatientPage findPatientPage;
	
	private LoginPage loginPage;
	
	private HomePage homePage;
	
	protected String firstPatientIdentifier;
	
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
	
	@And("From the home page click ‘rechercher dossier de patient")
	public void clickOnSearchPatientRecord() {
		findPatientPage = homePage.clickOnSearchPatientRecord();
	}
	
	@And("Enter First Name or Last Name in “Patient Search” box")
	public void enterPatientName() {
		findPatientPage.enterPatientName("moses mutesa");
	}
	
	@Then("Identify patient in list")
	public void returnResults() {
		firstPatientIdentifier = findPatientPage.getFirstPatientIdentifier();
		assertNotNull(firstPatientIdentifier);
	}

	@And("Click row with the patient you are searching for")
	public void clickFirstPatient() {
		findPatientPage.clickOnFirstPatient();
	}
	
	@Then("Selected patient’s “Cover Page” will be displayed")
	public void loadPatientSelectedCoverPage() {
		matchPatientIds(firstPatientIdentifier);
	}
}
