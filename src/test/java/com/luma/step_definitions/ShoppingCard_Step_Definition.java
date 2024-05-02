package com.luma.step_definitions;

import com.luma.pages.ShoppingCartPage;
import com.luma.pages.WomenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCard_Step_Definition {

    @And("The user adds all items into shoping card")
    public void theUserAddsAllItemsIntoShopingCard() {
        WomenPage womenPage=new WomenPage();
        womenPage.addItemsToCart();
    }

    @Then("The user verifies success message is displayed")
    public void theUserVerifiesSuccessMessageIsDisplayed() {
        WomenPage womenPage=new WomenPage();
        womenPage.checkThatSuccessMessageIsDisplayed();
    }

    @And("The user clicks shopping cart link from success message")
    public void theUserClicksShoppingCartLinkFromSuccessMessage() {
        WomenPage womenPage=new WomenPage();
        womenPage.clickShoppingCartLinkInSuccessMEssage();
    }

    @Then("The user verify that is landed in shopping cart page")
    public void theUserVerifyThatIsLandedInShoppingCartPage() {
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.checkTheTitleOfThePage();
    }

    @And("The sum of products amount is the same as total price")
    public void theSumOfProductsAmountIsTheSameAsTotalPrice() {
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.checkTotalPriceAccordingToEachItemPrice();
    }

    @Given("The user adds items in shopping card")
    public void theUserAddsItemsInShoppingCard() {
        WomenPage womenPage=new WomenPage();
        womenPage.clickJacketButton();
        womenPage.clickShoppingOptionsColor();
        womenPage.selectAColor();
        womenPage.clickShoppingOptionsPrice();
        womenPage.selectProductsPriceRange();
        womenPage.addItemsToCart();
        womenPage.clickShoppingCartLinkInSuccessMEssage();

    }

    @When("The user delete items from shopping cart")
    public void theUserDeleteItemsFromShoppingCart() {
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.deleteItemsFromCart();
    }

    @Then("The user verifies that item are deleted one by one")
    public void theUserVerifiesThatItemAreDeletedOneByOne() {
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
        shoppingCartPage.chechIfItemsAreDeleted();
    }
}
