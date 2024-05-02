package com.luma.pages;

import com.luma.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(){
        super();
    }

   public static Map<String,Boolean> ITEM_DELETE_CHECK;

    @FindBy(xpath = "//td[@data-th='Price']//span[@class='price']")
    private List<WebElement> itemsSubTotalPrice;
    @FindBy(xpath = "//td[@data-th='Order Total']//span[@class='price']")
    private WebElement totalPrice;
    @FindBy(xpath = "//tr[@class='item-info']")
    private List<WebElement> cartItemList;
    @FindBy(xpath = "//tr[@class='item-actions']//a[@title='Remove item']")
    private List<WebElement> deleteItemButton;
    @FindBy(xpath = "//div[@class='cart-empty']")
    private WebElement emptyCartMessage;

    public void checkTheTitleOfThePage(){
        String expectedTitle="Shopping Cart";
        BrowserUtils.verifyTitle(expectedTitle);
    }
    
    public void checkTotalPriceAccordingToEachItemPrice(){
        List<String> listOfSubprice=BrowserUtils.getElementsText(itemsSubTotalPrice);
        double sum=0;
        for (String eachItem : listOfSubprice) {
            sum+=Double.parseDouble(eachItem.substring(1));
        }
        double total=Double.parseDouble(totalPrice.getText().substring(1));
        System.out.println(sum);
        System.out.println(total);
        Assert.assertTrue("The sum of items price "+sum+" is not the same as total price "+total,sum==total);
    }

    public void deleteItemsFromCart(){
        ITEM_DELETE_CHECK=new HashMap<>();
        int deleteButtonNumber=deleteItemButton.size();
        for (int i = deleteButtonNumber-1; i >=0; i--) {
            int itemNumber = cartItemList.size();
            deleteItemButton.get(i).click();
            BrowserUtils.pause(2);
            if (itemNumber > 1) {
                int itemNumberAfterDelete = cartItemList.size();
                ITEM_DELETE_CHECK.put("item number before delete was " + itemNumber + "and now is " + itemNumberAfterDelete,
                        itemNumber - 1 == itemNumberAfterDelete);
            } else {
                if (emptyCartMessage.isDisplayed()) {
                    ITEM_DELETE_CHECK.put("succes delete", true);
                } else {
                    ITEM_DELETE_CHECK.put("succes delete", false);
                }
            }
        }
    }

    public void chechIfItemsAreDeleted(){
        for (String eachMessage : ITEM_DELETE_CHECK.keySet()) {
            Assert.assertTrue(eachMessage, ITEM_DELETE_CHECK.get(eachMessage));
        }
    }
}

