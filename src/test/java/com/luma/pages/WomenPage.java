package com.luma.pages;

import com.luma.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WomenPage extends BasePage{
    public WomenPage(){
        super();
    }

    public static  String SELECTED_COLOR;
    public static  String SELECTED_PRICE_RANGE;
    public static  int PRODUCT_NUMBER;
    public static  int PRODUCT_NUMBER_ADDED_IN_WISH_LIST;
    public static Map<String,Boolean> SUCCESS_MESSAGE;

    public static String ITEM_SIZE="//li[@class='item product product-item'][%s]//div[@class='swatch-option text']";


    @FindBy(xpath = "//span[.='Tops']/../../a[@id='ui-id-9']")
    public static WebElement topsSection;
    @FindBy(xpath = "//span[.='Jackets']/../../a[@id='ui-id-11']")
    public static WebElement jacketButton;
    @FindBy(xpath = "//div[.='Color']/..")
    private WebElement shoppingOptionsColor;
    @FindBy(css = "div[class='swatch-option color ']")
    private List<WebElement> shoppingOptionsColorsList;
    @FindBy(css = "div[class='swatch-option color selected']")
    private List<WebElement> productSelectedColor;
    @FindBy(xpath = "//div[.='Price']/..")
    private WebElement shoppingOptionsPrice;
    @FindBy(xpath = "//span[@class='price']/../../a")
    private List<WebElement> shoppingOptionsPriceList;
    @FindBy(xpath = "//div[@class='product details product-item-details']//span[@data-price-type='finalPrice']/span")
    public List<WebElement> productPrice;
    @FindBy(xpath = "//ol[@class='products list items product-items']/li[@class='item product product-item']")
    private List<WebElement> productList;
    @FindBy(xpath = "//span[.='Price']/../a")
    private WebElement removePriceFilterButton;
    @FindBy(css = "a[title='Add to Wish List']")
    private List<WebElement> addToWishButton;
    @FindBy(xpath = "//*[@data-ui-id='message-success']/div")
    public static WebElement itemAddedToWishListMessage;
    @FindBy(xpath = "//*[@data-ui-id='message-success']//a")
    public static WebElement continueShoppingButton;
    @FindBy(xpath = "//li[@class='item product product-item']//button[@title='Add to Cart']")
    public static List<WebElement> addToCartButton;
    @FindBy(xpath = "//*[@data-ui-id='message-success']/div")
    public static WebElement addToCartSuccessMessage;
    @FindBy(xpath = "//*[@data-ui-id='message-success']//a")
    public static WebElement shoppingCartLink;
    @FindBy(xpath = "//div[@class='toolbar toolbar-products' and following-sibling::div[@class='products wrapper grid products-grid']]//select[@id='sorter']")
    private   WebElement sortElement;
    @FindBy(xpath = "//li[@class='item product product-item']//a[@class='product-item-link']")
    public static List<WebElement> productName;
    @FindBy(xpath = "//div[@class='toolbar toolbar-products' and following-sibling::div[@class='products wrapper grid products-grid']]//a[@title='Set Descending Direction']")
    public static WebElement buttonForDescendingOrder;




    public void hoverTheMouseOverWomenButton(){
        BrowserUtils.hover(HomePage.womenSectionButton);
    }
    public void hoverTheMouseOverTops(){
        BrowserUtils.hover(topsSection);
    }
    public void clickJacketButton(){
        hoverTheMouseOverWomenButton();
        hoverTheMouseOverTops();
        clickElement(jacketButton);
    }

    public void clickShoppingOptionsColor(){
        clickElement(shoppingOptionsColor);
    }
    public void selectAColor(){
        //int randomColorIndex=BrowserUtils.selectARandomNumber(0,shoppingOptionsColorsList.size()-1);
        int randomColorIndex=1;
        SELECTED_COLOR=BrowserUtils.getElementAttribute(shoppingOptionsColorsList.get(randomColorIndex),"option-label");
        clickElement(shoppingOptionsColorsList.get(randomColorIndex));
    }

    public void checkItemsSelectedColor(){
        for (WebElement eachItem : productSelectedColor) {
            String itemsSelectedColor=BrowserUtils.getElementAttribute(eachItem,"option-label");
            Assert.assertEquals("The selected color "+SELECTED_COLOR+" is not the same as items selected color "+itemsSelectedColor,SELECTED_COLOR,itemsSelectedColor);
        }
    }

    public void clickShoppingOptionsPrice(){
        clickElement(shoppingOptionsPrice);
    }

    public void selectProductsPriceRange(){
        //int randomColorIndex=BrowserUtils.selectARandomNumber(0,shoppingOptionsPriceList.size()-1);
        int randomColorIndex=1;
        SELECTED_PRICE_RANGE=BrowserUtils.getElementProperties(shoppingOptionsPriceList.get(randomColorIndex),"search").split("=")[2];
        clickElement(shoppingOptionsPriceList.get(randomColorIndex));
    }

    public void checkThatAllProductsHavePriceWithinTheSelectedRange(){
        List<String> productsPrice=BrowserUtils.getElementsText(productPrice);
        double selectedLowerPriceRange=Double.parseDouble(SELECTED_PRICE_RANGE.split("-")[0]);
        double selectedUpperPriceRange;
        if (SELECTED_PRICE_RANGE.split("-").length==1){
            selectedUpperPriceRange=0;
        }else {
            selectedUpperPriceRange=Double.parseDouble(SELECTED_PRICE_RANGE.split("-")[1]);
        }
        for (String eachProduct : productsPrice) {
            double productPrice=Double.parseDouble(eachProduct.replaceAll("[^\\d.]", ""));
            if (selectedUpperPriceRange!=0){
                Assert.assertTrue("Products price "+productPrice+" is not within the range "+SELECTED_PRICE_RANGE,
                        selectedLowerPriceRange<=productPrice && selectedUpperPriceRange>=productPrice);
            }else {
                Assert.assertTrue("Products price "+productPrice+" is not within the range "+SELECTED_PRICE_RANGE,
                        selectedLowerPriceRange<=productPrice);
            }
        }

    }
    public void checkProductNumber(){
        int expectedProductNumber=2;
        int actualProductNumber=productList.size();
        Assert.assertEquals("The product number "+actualProductNumber+" is not the same as expexted "+expectedProductNumber,expectedProductNumber,actualProductNumber);
    }

    public void clickRemovePriceFilter(){
        PRODUCT_NUMBER=productList.size();
        clickElement(removePriceFilterButton);
    }
    public void checkThatProductNumberIsIncreased(){
        int productNumberWithPriceFilter=PRODUCT_NUMBER;
        int actualProductNumber=productList.size();
        Assert.assertTrue("The product number was "+productNumberWithPriceFilter+" and now is "+actualProductNumber,
                actualProductNumber>productNumberWithPriceFilter);
    }

    public void addTwoProductsInWishList(){
        SUCCESS_MESSAGE=new HashMap<>();
        int productsToAddInToWishList=2;
        PRODUCT_NUMBER_ADDED_IN_WISH_LIST=productsToAddInToWishList;
        for (int i = 0; i < productsToAddInToWishList; i++) {
            BrowserUtils.hover(productList.get(i));
            clickElement(addToWishButton.get(i));
            SUCCESS_MESSAGE.put(((i+1)+". item"),itemAddedToWishListMessage.isDisplayed());
            clickElement(continueShoppingButton);
        }
    }

    public void addItemsToCart(){
        SUCCESS_MESSAGE=new HashMap<>();
        PRODUCT_NUMBER=productList.size();
        for (int i = 0; i < productList.size(); i++) {
            BrowserUtils.hover(productList.get(i));
           List<WebElement> sizeList= BrowserUtils.getListOfElements(ITEM_SIZE,(i+1)+"");
           int randomSizeIndex=BrowserUtils.selectARandomNumber(0,sizeList.size()-1);
           clickElement(sizeList.get(randomSizeIndex));
            BrowserUtils.hover(productList.get(i));
            clickElement(addToCartButton.get(i));
            SUCCESS_MESSAGE.put(((i+1)+". item"),addToCartSuccessMessage.isDisplayed());
        }
    }

    public void checkThatSuccessMessageIsDisplayed(){
        for (String eachMessage : WomenPage.SUCCESS_MESSAGE.keySet()) {
            Assert.assertTrue("Success message is not displayed for "+eachMessage, WomenPage.SUCCESS_MESSAGE.get(eachMessage));
        }
    }

    public void clickShoppingCartLinkInSuccessMEssage(){
        clickElement(shoppingCartLink);
    }

    public void selectGivenDropdown(String sortingType){
        if (sortingType.equalsIgnoreCase("name")) {
            BrowserUtils.selectFromDropDown(sortElement, "name");
        }else {
            BrowserUtils.selectFromDropDown(sortElement, "price");
        }
    }

    public void checkItemsAreListedInAscendingOrder(String sortingType){
        if (sortingType.equalsIgnoreCase("name")) {
            List<String> itemNames=BrowserUtils.getElementsText(productName);
            Assert.assertTrue("Item name are not in ascending order", BrowserUtils.checkIfListIsInAscendingOrder(itemNames));
        }else {
            List<String> itemPricestr=BrowserUtils.getElementsText(productPrice);
            List<Double> itemPricedouble=new ArrayList<>();
            for (String eachItem : itemPricestr) {
                itemPricedouble.add(Double.parseDouble(eachItem.substring(1)));
            }
            Assert.assertTrue("Item name are not in ascending order", BrowserUtils.isAscendingOrder(itemPricedouble));
        }
    }
    public void clickButtonForDescendinOrder(){
        clickElement(buttonForDescendingOrder);
    }

    public void checkItemsAreListedInDescendingOrder(){
        List<String> itemNames=BrowserUtils.getElementsText(productName);
        Assert.assertTrue("Item name are not in descending order",BrowserUtils.isDescendingOrder(itemNames));
    }

    public void checkItemsAreListedInDescendingOrder(String sortingType){
        if (sortingType.equalsIgnoreCase("name")) {
            List<String> itemNames=BrowserUtils.getElementsText(productName);
            Assert.assertTrue("Item name are not in descending order",BrowserUtils.isDescendingOrder(itemNames));
        }else {
            List<String> itemPricestr=BrowserUtils.getElementsText(productPrice);
            List<Double> itemPricedouble=new ArrayList<>();
            for (String eachItem : itemPricestr) {
                itemPricedouble.add(Double.parseDouble(eachItem.substring(1)));
            }
            Assert.assertTrue("Item name are not in descending order", BrowserUtils.isDescendingOrderForDouble(itemPricedouble));
        }
    }



}
