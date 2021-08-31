package org.openmrs.contrib.isanteplus.qaframework.automation;

import org.openmrs.contrib.isanteplus.qaframework.RunTest;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.HomePage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.LoginPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.page.RegisterPatientPage;
import org.openmrs.contrib.isanteplus.qaframework.automation.test.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AddPatientSteps extends TestBase{

    private LoginPage loginPage;
	
	private HomePage homePage;

    private RegisterPatientPage registerPatientPage;
	
	@After(RunTest.HOOK.REGISTRATION)
	public void destroy() {
		quit();
	}
	
	@Before(RunTest.HOOK.REGISTRATION)
	public void setLoginPage() {
		loginPage = new LoginPage(getWebDriver());
	}
	
	@Given("User logins in and goes to Home Page")
	public void visitLoginPage() throws Exception {
		homePage = loginPage.goToHomePage();
	}

    @When("User selects ‘Register Patient’ From Main Menu")
    public void clickRegisterPatient(){
        registerPatientPage = homePage.clickRegisterPatientApp();
    }
    
}
