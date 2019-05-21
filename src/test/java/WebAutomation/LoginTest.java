package WebAutomation;

import WebAutomation.Pages.BaseFunc;
import WebAutomation.Pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginTest {

    BaseFunc baseFunc = new BaseFunc();
    LoginPage loginPage = new LoginPage(baseFunc);


    //TODO: remove chrome stuff from step
    @Given("^Open Chrome and go to Homepage$")
    public void openChromeAndGoToHomepage() {
        loginPage.openSignInPage();
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterValidAnd(String login, String password) throws InterruptedException {
        loginPage.enterLoginDetails(login);
        loginPage.enterPasswordDetails(password);
        loginPage.clickSubmitButton();
    }

    @Then("^I should be login successfully$")
    public void iShouldBeLoginSuccessfully() {
        String signout = loginPage.getLogOut();
        Assert.assertTrue("Login failed", signout.equals("Sign out"));

        //TODO: Move all closePage stuff to After Hook
        baseFunc.closePage();
    }

    @When("^I enter invalid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterInvalidAnd(String login, String password) throws Throwable {
        loginPage.enterLoginDetails(login);
        loginPage.enterPasswordDetails(password);
        loginPage.clickSubmitButton();
    }

    @Then("^I should not be logged in$")
    public void iShouldNotBeLoggedIn() {
        String signin = loginPage.getSignIn();
        Assert.assertTrue("Test failed", signin.equals("Sign in"));
        baseFunc.closePage();
    }
}
