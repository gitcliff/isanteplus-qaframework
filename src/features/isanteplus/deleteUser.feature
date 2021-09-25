Feature: Delete a User 

  Background:
    Given new admin user logins in isante-plus and goes to Home Page

  @deleteUser
  Scenario Outline: Searching a user
  When From Main Menu admin user selects 'System Admininstration'
  And Search for user or find a user in the user table "<user>"
  And Click the pencil icon in the ‘Action’ column next to the desired user name
  And Click ‘Retire’ under user account details
  And Enter Reason "<reason>"
  Then Notification ‘Retire avec success’ and the user’s account details  appear crossed out

  Examples:
      | user        |reason             |
      | john smith  |user nolonger used |    