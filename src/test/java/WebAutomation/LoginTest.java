package WebAutomation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginTest {

    BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "http://www.automationpractice.com";
    private final String SIGN_PAGE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private final By LOGOUT = By.xpath("//*[@title='Log me out']");


    @Given("^Open Chrome and go to Homepage$")
    public void openChromeAndGoToHomepage() {
        baseFunc.openPage(HOME_PAGE);
        baseFunc.openPage(SIGN_PAGE);
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterValidAnd(String login, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(baseFunc);

        loginPage.enterLoginDetails(login);
        Thread.sleep(2000);
        loginPage.enterPasswordDetails(password);
        loginPage.clickSubmitButton();

    }

    @Then("^I should be login successfully$")
    public void iShouldBeLoginSuccessfully() {

        String signout = baseFunc.getElement(LOGOUT).getText();
        Assert.assertTrue("Login failed", signout.equals("Sign out"));
        baseFunc.closePage();
    }

    @When("^I enter invalid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterInvalidAnd(String login, String password) throws Throwable {
        LoginPage loginPage = new LoginPage(baseFunc);

        loginPage.enterLoginDetails(login);
        Thread.sleep(2000);
        loginPage.enterPasswordDetails(password);
        loginPage.clickSubmitButton();
    }

    @Then("^I should not be logged in$")
    public void iShouldNotBeLoggedIn() {

        String signout = baseFunc.getElement(LOGOUT).getText();
        Assert.assertFalse("Test failed", signout.equals("Sign out"));
        baseFunc.closePage();
    }
}
