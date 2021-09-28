Feature: Patient Summary

 Background:
    Given system user logs into  and goes to the Home page

  @patientSummary
  Scenario: Patient Summary
  When    Search for a Patient "<patientName>"
  And     Select ‘Patient Summary’ on the right hand side menu
  Then     Check that the following exist
   Examples:
      | patientName    |
      | moses2 mutesa2 | 
