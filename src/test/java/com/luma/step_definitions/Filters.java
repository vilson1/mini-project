package com.luma.step_definitions;

import com.luma.pages.HomePage;
import com.luma.pages.LoginPage;
import com.luma.pages.MyWishListPage;
import com.luma.pages.WomenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Filters {
    @Given("The user is logged in")
    public void theUserIsLoggedIn() {
        LoginPage loginPage=new LoginPage();
        HomePage homePage=new HomePage();
        homePage.clickLoginButon();
        loginPage.writeUsername();
        loginPage.writePassword();
        loginPage.clickLogInButton();
    }

    @When("The user clicks women dropdown")
    public void theUserClicksWomenDropdown() {
        HomePage homePage=new HomePage();
        homePage.clickWomenDropdown();
    }

    @And("The user selects jacket option under tops dropdown")
    public void theUserSelectsJacketOptionUnderTopsDropdown() {
        WomenPage womenPage=new WomenPage();
        womenPage.clickJacketButton();
    }

    @And("The user selects a color")
    public void theUserSelectsAColor() {
        WomenPage womenPage=new WomenPage();
        womenPage.clickShoppingOptionsColor();
        womenPage.selectAColor();
    }

    @Then("The user verifies that all products have selected the same color")
    public void theUserVerifiesThatAllProductsHaveSelectedTheSameColor() {
        WomenPage womenPage=new WomenPage();
        womenPage.checkItemsSelectedColor();
    }

    @And("The user selects a range price")
    public void theUserSelectsARangePrice() {
        WomenPage womenPage=new WomenPage();
        womenPage.clickShoppingOptionsPrice();
        womenPage.selectProductsPriceRange();
    }

    @Then("The user verifies that all products have the price within the selectet range")
    public void theUserVerifiesThatAllProductsHaveThePriceWithinTheSelectetRange() {
        WomenPage womenPage=new WomenPage();
        womenPage.checkThatAllProductsHavePriceWithinTheSelectedRange();
    }

    @And("The user verifies that only two products are displayed")
    public void theUserVerifiesThatOnlyTwoProductsAreDisplayed() {
        WomenPage womenPage=new WomenPage();
        womenPage.checkProductNumber();
    }

    @Given("The user select jacket option from tops of women page and select color and price filters")
    public void theUserSelectJacketOptionFromTopsOfWomenPageAndSelectColorAndPriceFilters() {
        WomenPage womenPage=new WomenPage();
        womenPage.clickJacketButton();
        womenPage.clickShoppingOptionsColor();
        womenPage.selectAColor();
        womenPage.clickShoppingOptionsPrice();
        womenPage.selectProductsPriceRange();
    }

    @When("The user removes price filter")
    public void theUserRemovesPriceFilter() {
        WomenPage womenPage=new WomenPage();
        womenPage.clickRemovePriceFilter();
    }

    @Then("The user verifies the number of products incresed")
    public void theUserVerifiesTheNumberOfProductsIncresed() {
        WomenPage womenPage=new WomenPage();
        womenPage.checkThatProductNumberIsIncreased();
    }

    @And("The user adds first two items in the wish list")
    public void theUserAddsFirstTwoItemsInTheWishList() {
        WomenPage womenPage=new WomenPage();
        womenPage.addTwoProductsInWishList();
    }

    @Then("The user verifies that successful message is displayed")
    public void theUserVerifiesThatSuccessfulMessageIsDisplayed() {
        MyWishListPage myWishListPage=new MyWishListPage();
        myWishListPage.checkThatSuccessfulMessageIsDisplayed();
    }
}
