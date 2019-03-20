package WebAutomation;

import WebAutomation.Pages.BaseFunc;
import WebAutomation.Pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CartTest {
    BaseFunc baseFunc = new BaseFunc();

    private final String HOMEPAGE = "http://automationpractice.com";

    @Given("^I go to webshop homepage Woman section$")
    public void iGoToWebshopHomepageWomanSection() {
        HomePage homePage = new HomePage(baseFunc);
        baseFunc.openPage(HOMEPAGE);

        homePage.selectMenuItem("WOMEN");
    }

    @And("^add any product to cart$")
    public void addAnyProductToCart() {
        HomePage homePage = new HomePage(baseFunc);
        homePage.addItemToCart(1);
        homePage.proceedToCheckout();
    }
}


