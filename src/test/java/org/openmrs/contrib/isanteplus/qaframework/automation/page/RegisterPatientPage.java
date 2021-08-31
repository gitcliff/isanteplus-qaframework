package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.By;

public class RegisterPatientPage extends Page {
    
    private static final String PAGE_PATH = "/registrationapp/registerPatient.page?appId=isanteplus.registration";
    
    private final By CHECK_BOX_DATE_TODAY = By.id("checkbox-enable-registration-date");
    
    private static final By FIELD_BIRTHDAY_DAY = By.id("birthdateDay-field");
    
    private static final By FIELD_BIRTHDAY_MONTH = By.id("birthdateMonth-field");
    
    private static final By FIELD_BIRTHDAY_YEAR = By.id("birthdateYear-field");
    
    private static final By FIELD_ESTIMATED_YEARS = By.id("birthdateYears-field");
    
    private static final By FIELD_ERROR = By.id("field-error");
    
    private static final By FIELD_GIVEN_NAME = By.name("givenName");
    
    private static final By FIELD_FAMILY_NAME = By.name("familyName");
    
    private static final By FIELD_MIDDLE_NAME = By.name("middleName");
    
    private static final By DROP_DOWN_GENDER = By.id("gender-field");
    
    private static final By FIELD_ADDRESS_COUNTRY = By.id("country");

    private static final By FIELD_ADDRESS1 = By.id("address1");
    
    private static final By FIELD_ADDRESS2 = By.id("address2");
    
    private static final By FIELD_CITY_VILLAGE = By.id("cityVillage");
    
    private static final By FIELD_NATIONAL_ID = By.id("Code National");
    
    private static final By LABEL_BIRTHDATE = By.id("birthdateLabel");
    
    private static final By LABEL_PHONE_NUMBER = By.id("phoneNumberLabel");
    
    private static final By LABEL_GENDER = By.id("genderLabel");
    
    private static final By LABEL_CONTACT_INFO_SECTION = By.id("contactInfo_label");
    
    private static final By LABEL_CONFIRM_SECTION = By.id("confirmation_label");
    
    public RegisterPatientPage(Page parent) {
        super(parent);
    }
    
    @Override
    public String getPageUrl() {
        return PAGE_PATH;
    }
    
    public void enterGivenName(String givenName) {
        setText(FIELD_GIVEN_NAME, givenName);
    }
    
    public void enterFamilyName(String familyName) {
        setText(FIELD_FAMILY_NAME, familyName);
    }
    
    public void enterDateOfBirth(String age) {
        setText(FIELD_ESTIMATED_YEARS, age);
    }
    
    public void selectGender(String gender) {
        selectFrom(DROP_DOWN_GENDER, gender);
    }
    
    public void enterNatinalId(String nationalId) {
        setText(FIELD_NATIONAL_ID, nationalId);
    }
    
    public void enterAddres(String country) {
        setText(FIELD_ADDRESS_COUNTRY, country);
    }
    
}
