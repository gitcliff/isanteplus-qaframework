Feature: Adding a User 

  Background:
    Given client logs into Isanteplus application and goes to the Home page

  @addUser
  Scenario Outline: Adding a user
  When From the main menu select System Administration app
  And Select Manage Accounts App and goes to Manage Accounts page
  And Click add new account
  And Enter name,firstname and sex "<name>" "<firstName>"
  And Click the checkbox next to add user account
  And Enter a username "<userName>"
  And Select 'full' under privillage level "<privillage>" "<password>" "<confirmPassword>"
  And click force password
  And select the checkboxes under ‘capacites’ with the appropriate privileges based on roles defined
  And Click the checkbox next to ‘Add a supplier account?
  And Enter the same username as entered above in ‘Identifier’ field "<userName>"
  And Select the relevant role under ‘service provider role’ "<role>"
  And click save
  Then User redirected to the ‘Gerer les comptes’ page and user appears in the user table
  Examples:
    |name  |firstName |userName |privillage |password  |confirmPassword |role            |
    |john  |DO        |johnDo   |Full       |Messi123  |Messi123        |Clinical Doctor |

