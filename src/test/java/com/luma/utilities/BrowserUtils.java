package com.luma.utilities;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class BrowserUtils {

    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }

    public static String getElementProperties(WebElement element,String propertyName){
        return element.getDomProperty(propertyName);
    }

    public static String getStringFromFaker(String stringType){
        Faker faker=new Faker();
        String str="";
        switch (stringType){
            case "email":
                str=faker.internet().emailAddress();
                break;
            case "firstName":
                str=faker.name().firstName();
                break;
            case "lastName":
                str=faker.name().lastName();
                break;
            case "password":
                str=faker.name().lastName();
                break;
        }
        return str;
    }

    public static boolean isElementInUpperRightQuadrant(WebElement element) {
        // Get the position of the element
        Point elementLocation = element.getLocation();
        int elementX = elementLocation.getX();
        int elementY = elementLocation.getY();

        // Get the size of the viewport
        int viewportWidth = Driver.getDriver().manage().window().getSize().getWidth();
        int viewportHeight = Driver.getDriver().manage().window().getSize().getHeight();

        // Calculate the position of the upper-right corner of the viewport
        int upperRightX = viewportWidth;
        int upperRightY = 0;

        // Compare the position of the element with the position of the upper-right corner of the viewport
        return elementX >= (viewportWidth / 2) && elementY <= (viewportHeight / 2);
    }

    public static int selectARandomNumber(int minNumber,int maxNumber){
        Random random=new Random();
        return random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

    public static String getElementAttribute(WebElement element,String attributeName){
        return  element.getAttribute(attributeName);
    }

    public static List<WebElement> getListOfElements(String xpath,String strToReplace){
       return Driver.getDriver().findElements(By.xpath(String.format(xpath,strToReplace)));
    }

    public static void pause(int timeInSeconds){
        try {
            Thread.sleep(timeInSeconds* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectFromDropDown(WebElement element, String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }

    public static boolean checkIfListIsInAscendingOrder(List<String> list){
        String[] strArray=new String[list.size()];
        strArray=list.toArray(strArray);
        String[] sortedArray=new String[list.size()];
        sortedArray=list.toArray(sortedArray);
        Arrays.sort(sortedArray);
        return Arrays.equals(strArray,sortedArray);
    }

    public static boolean isAscendingOrder(List<Double> list){
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >
            list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDescendingOrder(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDescendingOrderForDouble(List<Double> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


}
