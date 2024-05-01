package com.luma.step_definitions;

import com.luma.pages.CreateAccountPage;
import com.luma.pages.HomePage;
import com.luma.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test {

    @When("the user click create an account link")
    public void the_user_click_create_an_account_link() {
        HomePage homePage=new HomePage();
        homePage.clickCreateAccountButton();
    }

    @Then("the user verifies the title of the open page")
    public void theUserVerifiesTheTitleOfTheOpenPage() {
        CreateAccountPage createAccountPage=new CreateAccountPage();
        createAccountPage.checkTitle();
    }

    @And("The user fills in form field")
    public void theUserFillsInFormField() {
        CreateAccountPage createAccountPage=new CreateAccountPage();
        createAccountPage.fillCreateAccountForm();
    }

    @And("The user clicks create an account submit button")
    public void theUserClicksCreateAnAccountSubmitButton() {
        CreateAccountPage createAccountPage=new CreateAccountPage();
        createAccountPage.clickCriateAccountSubmitButton();
    }

    @Then("The user verifies that account is created successfully")
    public void theUserVerifiesThatAccountIsCreatedSuccessfully() {
        CreateAccountPage createAccountPage=new CreateAccountPage();
        createAccountPage.verifyAccountCreation();
    }

    @And("The user clicks on the user profile button")
    public void theUserClicksInUserProfileButton() {
        HomePage homePage=new HomePage();
        homePage.clicksUserAccountButton();
    }

    @And("The user clicks the signOut button")
    public void theUserClickSignOutButton() {
        HomePage homePage=new HomePage();
        homePage.clickSignOutButton();

    }

    @Then("The user verifies successful sign-out")
    public void theUserVerifiesThatIsSignedOut() {
        HomePage homePage=new HomePage();
        homePage.checkPresenceOfSignInButton();
    }

    @When("The user clicks the login Page")
    public void theUserClickLoginPage() {
        HomePage homePage=new HomePage();
        homePage.clickLoginButon();
    }

    @And("The user writes the username")
    public void theUserWritesUsername() {
        LoginPage loginPage=new LoginPage();
        loginPage.writeUsername();
    }

    @And("The user writes the password")
    public void theUserWritesPassword() {
        LoginPage loginPage=new LoginPage();
        loginPage.writePassword();
    }

    @Then("The user verifies that the username is displayed and its position")
    public void theUserVerifiesTheUsernameIsDisplaedAndItsPossition() {
        HomePage homePage=new HomePage();
        homePage.checkUserNameAndPosition();
    }

    @And("The user clicks the login button")
    public void theUserClicksLoginButton() {
        LoginPage loginPage=new LoginPage();
        loginPage.clickLogInButton();
    }

}
