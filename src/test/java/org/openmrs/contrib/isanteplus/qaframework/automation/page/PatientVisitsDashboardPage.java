package org.openmrs.contrib.isanteplus.qaframework.automation.page;

import org.openqa.selenium.WebElement;

public class PatientVisitsDashboardPage extends Page {

    private static final String PAGE_PATH = "coreapps/patientdashboard/patientDashboard.page";

    public PatientVisitsDashboardPage(Page parent) {
        super(parent);
    }

    public PatientVisitsDashboardPage(Page parent, WebElement waitForStaleness) {
        super(parent, waitForStaleness);
    }

    @Override
    public String getPageUrl() {
        return PAGE_PATH;
    }
    
}
