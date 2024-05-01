package com.luma.pages;

import com.luma.utilities.ConfigurationReader;
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

    public void writeUsername(){
        sendKeys(usernameInputField, ConfigurationReader.getProperty("emailAddress"));
    }
    public void writePassword(){
        sendKeys(passwordInputField, ConfigurationReader.getProperty("password"));
    }
    public void clickLogInButton(){
        clickElement(loginButton);
    }



}
