package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RunReportPage extends Page {
	
	private static final By CALENDAR_ICON = By.xpath("/html/body/div[1]/div[3]/div/div[2]/fieldset/form/p[1]/span/span[1]/input");
	
	private static final By START_DATE = By.xpath("/html/body/div[2]/div[3]/table/tbody/tr[5]/td[5]");

	
	private static final By END_DATE = By.xpath("/html/body/div[3]/div[3]/table/tbody/tr[5]/td[1]");
	
	private static final By FORMAT_REVIEW = By.xpath("//*[@id=\"fr5107-field\"]");
	
	private static final By OUTPUT_FORMAT = By.xpath("//*[@id=\"fr5107-field\"]");
	
	private static final By DOWNLOAD_TABLE = By.cssSelector("#content > div > div.past-reports > fieldset:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2)");
	
	private static final By RUN_REPORT    = By.xpath("/html/body/div[1]/div[3]/div/div[2]/fieldset/form/button/i");
	
	private static String FORMAT = "Html";
	
	public RunReportPage(Page page) {
		super(page);
	}

	public void clickOnCalender() {
		clickOn(CALENDAR_ICON);
	}
	
	public  void chooseCurrentDate() {
		waiter.until( ExpectedConditions.visibilityOfAllElementsLocatedBy(START_DATE));
		clickOn(START_DATE);
	}
	
	public void clickOnEndDate() {
		waiter.until( ExpectedConditions.visibilityOfAllElementsLocatedBy(END_DATE));
		clickOn(END_DATE);
	}
	
	public void clickOnRunButton() {
		clickOn(RUN_REPORT);
	}
	
	@Override
	public String getPageUrl() {

		return "/reportingui/runReport.page?reportDefinition=b6973c26-e4a2-46c6-9446-f993cad52efe";
	}
	
}
