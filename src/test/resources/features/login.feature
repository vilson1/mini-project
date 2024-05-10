@wip
  Feature: login

    Background:
      Given The user verifies if is not logged in

    @create_account @wip1
    Scenario: Create an account
      When the user click create an account link
      Then the user verifies the title of the open page
      And  The user fills in form field
      And The user clicks create an account submit button
      Then The user verifies that account is created successfully
      And The user clicks on the user profile button
      And The user clicks the signOut button
      Then The user verifies successful sign-out

      @login
      Scenario: check login
        When The user clicks the login Page
        And The user writes the username
        And The user writes the password
        And The user clicks the login button
        Then The user verifies that the username is displayed and its position
        And The user clicks on the user profile button
        And The user clicks the signOut button
        Then The user verifies successful sign-out



