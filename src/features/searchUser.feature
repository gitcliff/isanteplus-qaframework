Feature: Search a User 

  Background:
    Given admin user logins in isante-plus and goes to Home Page

  @searchUser
  Scenario Outline: Searching a user
  When From Main Menu, select 'System Admininstration'
  And Select ‘Manage Accounts’
  And Enter the name of the user in the ‘Search’ text box "<user>"
  Then the User table should filter, only displaying results of the search                                                                              
   Examples:
      | user        |
      | john smith  |
