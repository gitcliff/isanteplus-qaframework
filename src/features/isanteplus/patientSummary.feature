Feature: Patient Summary

 Background:
    Given system user logs into Isanteplus application and goes to the Home page

  @patientSummary
  Scenario: Patient Summary widget
  When  system loads Patient dashboardPage
  Then  Patient summary should display in pdf format on the screen
