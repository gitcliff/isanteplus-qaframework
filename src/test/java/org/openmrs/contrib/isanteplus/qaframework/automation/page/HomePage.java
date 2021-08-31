package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.By;

/**
 * This class represents the Home page
 */
public class HomePage extends Page {
	
	private RegisterPatientPage registerPatientPage;

	private final By LINK_LOGOUT = By.className("logout");

	private final String PATH_HOME = "/referenceapplication/home.page";
	
	private final By APP_REGISTER_PATIENT = By.id(
	    "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension");
	
	public HomePage(Page page) {
		super(page);
	}
	
	@Override
	public String getPageUrl() {
		return PATH_HOME;
	}
	
	public Boolean hasLogOutLink() {
		return hasElement(LINK_LOGOUT);
	}
	
	public void clickLogout() {
		clickOn(LINK_LOGOUT);
	}

	public RegisterPatientPage clickRegisterPatientApp() {
		clickOn(APP_REGISTER_PATIENT);
		return new RegisterPatientPage(this);
	}
}
