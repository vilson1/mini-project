package com.luma.pages;

import com.luma.utilities.BrowserUtils;
import com.luma.utilities.ConfigurationReader;
import com.luma.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }
    @FindBy (xpath = "//header//a[.='Create an Account']")
    public WebElement criateAccountButton;
    @FindBy(xpath = "//a[@class='action skip contentarea']/..//button[@data-action='customer-menu-toggle']")
    private WebElement accountButton;
    @FindBy(xpath = "//a[@class='action skip contentarea']/..//div[@class='customer-menu']//a[contains(.,'Sign Out')]")
    private WebElement signOutButton;
    @FindBy(xpath = "//ul[@class='header links' and preceding-sibling::a[@class='action skip contentarea']]//a[contains(.,'Sign In')]")
    private WebElement logInButton;
    @FindBy(xpath = "//ul[@class='header links' and preceding-sibling::a]//span[@class='logged-in']")
    private WebElement username;
    @FindBy(xpath = "//span[.='Women']/../../a")
    public static WebElement womenSectionButton;


    public void clickCreateAccountButton(){
        clickElement(criateAccountButton);
    }

    public void clicksUserAccountButton(){
        clickElement(accountButton);
    }

    public void clickSignOutButton(){
        clickElement(signOutButton);
    }

    public void checkPresenceOfSignInButton(){
        BrowserUtils.verifyElementDisplayed(logInButton);
    }

    public void clickLoginButon(){clickElement(logInButton); }

    public void checkUserNameAndPosition(){
        String expectedUsername= ConfigurationReader.getProperty("firstName")+" "+ConfigurationReader.getProperty("lastName");
        String actualUserName=username.getText().split(",")[1].replace("!","").trim();
        Assert.assertEquals(expectedUsername,actualUserName);
        Assert.assertTrue(BrowserUtils.isElementInUpperRightQuadrant(username));
    }

    public void clickWomenDropdown(){
        clickElement(womenSectionButton);
    }

}
