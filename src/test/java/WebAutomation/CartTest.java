package WebAutomation;

import WebAutomation.Pages.BaseFunc;
import WebAutomation.Pages.CheckoutPage;
import WebAutomation.Pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CartTest {
    BaseFunc baseFunc = new BaseFunc();
    HomePage homePage = new HomePage(baseFunc);
    private final String HOMEPAGE = "http://automationpractice.com";

    @Given("^I go to webshop homepage Woman section$")
    public void iGoToWebshopHomepageWomanSection() {
        baseFunc.openPage(HOMEPAGE);
        homePage.selectMenuItem("WOMEN");
    }

    @And("^add any product to cart$")
    public void addAnyProductToCart() {
        homePage.addItemToCart(1);
        homePage.proceedToCheckout();
    }

    @Then("^i verify that price of item is equals with total price without shipping$")
    public void iVerifyThatPriceOfItemIsEqualsWithTotalPriceWithoutShipping() {
        CheckoutPage checkoutPage = new CheckoutPage(baseFunc);

        Assert.assertTrue("Prices does not match", checkoutPage.getItemPriceTotal().equals(checkoutPage.getItemPriceWithoutTax()));

    }
}


