package com.luma.pages;

import com.luma.utilities.ConfigurationReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(){
        super();
    }

    @FindBy (css = "input[id='email']")
    private WebElement usernameInputField;
    @FindBy (css = "input[title='Password']")
    private WebElement passwordInputField;
    @FindBy (xpath = "//button[@class='action login primary']")
    private WebElement loginButton;
    @FindBy(xpath = "//ul[@class='header links' and preceding-sibling::a[@class='action skip contentarea']]//a[contains(.,'Sign In')]")
    public static WebElement logInButton;
    @FindBy(xpath = "//a[@class='action skip contentarea']/..//div[@class='customer-menu']//a[contains(.,'Sign Out')]")
    private WebElement signOutButton;


    public void writeUsername(){
        sendKeys(usernameInputField, ConfigurationReader.getProperty("emailAddress"));
    }

    public void writePassword(){
        sendKeys(passwordInputField, ConfigurationReader.getProperty("password"));
    }

    public void clickLogInButton(){
        clickElement(loginButton);
    }

    public void checkIfIsLoggedOut() {
        try {
            logInButton.isDisplayed();
        } catch (Exception e) {
            clickElement(HomePage.accountButton);
            clickElement(signOutButton);
        }
    }



}
