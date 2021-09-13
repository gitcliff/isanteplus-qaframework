package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.By;

public class FindPatientPage extends Page {
	
	private static final String PAGE_URL = "/coreapps/findpatient/findPatient.page?app=coreapps.findPatient";
	private static final By PATIENT_SEARCH = By.id("patient-search");
	private static final By PATIENT_ID_SEARCH_RESULT = By.cssSelector("#patient-search-results-table tr:first-child td:first-child");	
	private static final By PATIENT_NAME_SEARCH_RESULT = By.cssSelector("#patient-search-results-table tbody tr:first-child td:nth-child(2)");
	
	public FindPatientPage(Page page) {
		super(page);
	}

	public void enterPatientName(String patientName) {
		setTextToFieldNoEnter(PATIENT_SEARCH, patientName);
	}

	public  ClinicianFacingPatientDashboardPage clickOnFirstPatient() {
		clickOn(PATIENT_NAME_SEARCH_RESULT);
		return new ClinicianFacingPatientDashboardPage(this);
	}

	public void search(String text) {
		setTextToFieldNoEnter(PATIENT_SEARCH, text);
	}

	/**
	 * Finds first record from the result table
	 * 
	 * @return patient id
	 */
	public String getFirstPatientIdentifier() {
		getFirstPatientName();
		return getText(PATIENT_ID_SEARCH_RESULT);
	}

	public String getFirstPatientName() {
		return getText(PATIENT_NAME_SEARCH_RESULT);
	}
	
	@Override
	public String getPageUrl() {
		return PAGE_URL;
	}
	
}
