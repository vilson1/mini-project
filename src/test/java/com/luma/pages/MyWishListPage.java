package com.luma.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage extends BasePage{
    public MyWishListPage(){
        super();
    }
    @FindBy(xpath = "//*[@data-ui-id='message-success']/div")
    public static WebElement itemAddedToWishListMessage;
    @FindBy(xpath = "//*[@data-ui-id='message-success']//a")
    public static WebElement continueShoppingButton;

    public void checkThatSuccessfulMessageIsDisplayed(){
        for (String eachMessage : WomenPage.SUCCESS_MESSAGE.keySet()) {
            Assert.assertTrue("success message is not displayed for "+eachMessage, WomenPage.SUCCESS_MESSAGE.get(eachMessage));
        }
    }


}
