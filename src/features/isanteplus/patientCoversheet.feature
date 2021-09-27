Feature: Patient Summary

 Background:
    Given system user logs into Isanteplus application and goes to the Home page

  @patientCoverSheet
  Scenario: Patient Cover sheet
  When Search for and select Patient "<patientName>"
  Then  Selected patient’s ‘Cover Sheet’ will be displayed with the following
   Examples:
      | patientName    |
      | sharif shamirah|  
