Feature: Patient Summary

 Background:
    Given system user logs into Isanteplus application and goes to the Home page

  @patientSummary
  Scenario: Patient Summary widget
  When  system loads Patient dashboardPage
  Then  Selected patient’s ‘Cover Sheet’ will be displayed with the following
