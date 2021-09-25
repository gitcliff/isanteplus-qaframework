package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.By;

public class ManageAccountsPage extends Page {
	
	private static final String MANAGE_ACCOUNTS = "/adminui/systemadmin/accounts/manageAccounts.page";
		
	private static final By EDIT_ACTION_BUTTON = By.xpath("//*[@class='icon-pencil edit-action']");

	private static final By ADD_ACCOUNT_BUTTON = By.xpath("//*[@class='button']");

	private static final By LABEL_SEARCH = By.xpath("//input[starts-with(@type,'text')]");
	
	public ManageAccountsPage(Page page) {
		super(page);
	}
	
	@Override
	public String getPageUrl() {
		return MANAGE_ACCOUNTS;
	}
	
	public AccountsPage editAccount() {	
		clickOn(EDIT_ACTION_BUTTON);
		return new AccountsPage(this);
	}

	public AccountsPage clickAddAccount() {

		clickOn(ADD_ACCOUNT_BUTTON);
		return new AccountsPage(this);
	}
	
	public void clickSearchTextBox(String user) {	
		setText(LABEL_SEARCH, user);
	}
}
