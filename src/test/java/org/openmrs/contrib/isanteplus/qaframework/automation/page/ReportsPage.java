package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.By;

public class ReportsPage extends Page{
	
	private static final By NUMBER_OF_HIV_PATIENTS = By.cssSelector("#content > div:nth-child(3) > ul:nth-child(4) > li:nth-child(17) > a");

	public ReportsPage(Page parent) {
		super(parent);
	}
	
	public RunReportPage clickOnNUmberOfHivPatientsLink() {
		clickOn(NUMBER_OF_HIV_PATIENTS);
		return new RunReportPage(this);	
	}
	
	@Override
	public String getPageUrl() {

		return "/reportingui/reportsapp/home.page";
	}
	
}
