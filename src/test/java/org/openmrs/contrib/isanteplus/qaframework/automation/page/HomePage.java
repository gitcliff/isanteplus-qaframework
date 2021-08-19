package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class represents the Home page
 */
public class HomePage extends Page {
	
	private final By LINK_LOGOUT = By.className("logout");
	
	public HomePage(Page page) {
		super(page);
	}
	
	@Override
	public String getPageUrl() {
		return "PATH_HOME";
	}

	public Boolean hasLogOutLink() {
		return hasElement(LINK_LOGOUT);
	}

}
