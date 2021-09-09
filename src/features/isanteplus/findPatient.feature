Feature: Patient Search

  Background:
    Given User logs in the system
    And User clicks on Find Patient App

  @findPatient
  Scenario: Searching missing a patient
    And User enters missing patient
    Then Search Page returns no patients

  @findPatient
  Scenario: Searching an existing patient
    User enters James Smith 
    Then Search Page returns patients
    And User clicks on first patient
    Then System loads patient dashboard
