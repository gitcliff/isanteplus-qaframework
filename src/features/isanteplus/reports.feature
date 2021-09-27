Feature: Patient Search

  Background:
    Given User loads HomePage

  @reports
  Scenario: Running Reports
  When    User clicks on Report App
  And     User click the Report Name
  Then    User clicks on calendar icon
  And     User clicks on start date calendar
  Then    User clicks on Run Button
  Then    System returns Available for download
 
 
