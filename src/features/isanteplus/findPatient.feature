Feature: Patient Search

  Background:
    Given User logs in the system

  @findPatient
  Scenario: Searching for a patient
  And From the home page click ‘rechercher dossier de patient
  And  Enter First Name or Last Name in “Patient Search” box "<searchText>" searchText
  Then Identify patient in list
  And  Click row with the patient you are searching for
  Then Selected patient’s “Cover Page” will be displayed
   Examples:
      | searchText  | 
      | moses mutesa     | 
 
