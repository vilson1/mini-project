package com.luma.pages;

import com.luma.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    public static Map<String,Boolean> ADD_TO_WISH_LIST_MESSAGE;


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
    private List<WebElement> productPrice;
    @FindBy(css = "li[class='item product product-item']")
    private List<WebElement> productList;
    @FindBy(xpath = "//span[.='Price']/../a")
    private WebElement removePriceFilterButton;
    @FindBy(css = "a[title='Add to Wish List']")
    private List<WebElement> addToWishButton;




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
        ADD_TO_WISH_LIST_MESSAGE=new HashMap<>();
        for (int i = 0; i < 2; i++) {
            BrowserUtils.hover(productList.get(i));
            clickElement(addToWishButton.get(i));
            ADD_TO_WISH_LIST_MESSAGE.put(((i+1)+". item"),MyWishListPage.itemAddedToWishListMessage.isDisplayed());
            clickElement(MyWishListPage.continueShoppingButton);
        }
    }


}
