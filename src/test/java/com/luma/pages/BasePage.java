package com.luma.pages;

import com.luma.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
        wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
    }

    protected void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected String getTitle(){
       return Driver.getDriver().getTitle();
    }

    protected void sendKeys(WebElement element,String text){
        element.sendKeys(text);
    }


}
