Feature: Change Password

  Background:
    Given User vists the Home Page and goes to System Administration Page
    Then the system loads system administration page

  @password
  Scenario Outline: Changing password  
  When User goes to Manage Accounts App
  Then the system loads manage acccount page
  And User clicks edit button action
  Then the system loads account page
  And User clicks on modifier under user account detaials