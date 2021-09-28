Feature: Patient Summary

 Background:
    Given system user logs into Isanteplus application and goes to the Home page

  @patientCoverSheet
  Scenario: Patient Cover sheet
  When Search for a patient (Use case #4.1 or 4.2)
  Then  Select ‘Resume de patient’ on the right hand side menu
   Examples:
      | patientName    |
      | moses2 mutesa2| 
