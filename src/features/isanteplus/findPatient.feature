Feature: Patient Search

  Background:
    Given User logs in the system

  @findPatient
  Scenario: Searching for a patient
  And User clicks on Find Patient App
  And User enters missing patient
  Then Search Page returns no patients
  And  User enters moses mutesa
  Then Search Page returns patients
  And  User clicks on first patient
  Then System loads patient dashboard
