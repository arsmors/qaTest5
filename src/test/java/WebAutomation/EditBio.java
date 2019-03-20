package WebAutomation;

import WebAutomation.Pages.BaseFunc;
import WebAutomation.Pages.LoginPage;
import WebAutomation.Pages.MyAdressPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class EditBio {
    BaseFunc baseFunc = new BaseFunc();


    private final String MY_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
    private final By ADDRESS_BOX = By.xpath("//ul[@class='last_item item box']//li");

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String login, String password) throws InterruptedException {
        baseFunc.openPage(MY_ACCOUNT);

        LoginPage loginPage = new LoginPage(baseFunc);

        loginPage.enterLoginDetails(login);
        Thread.sleep(2000);
        loginPage.enterPasswordDetails(password);
        loginPage.clickSubmitButton();
    }

    @And("^go to My Addresses$")
    public void goToMyAddresses() {
        MyAdressPage myAdressPage = new MyAdressPage(baseFunc);
        myAdressPage.goToMyAddressPage();
    }

    @And("^update FirstName with \"([^\"]*)\"$")
    public void updateFirstNameWith(String firstname) {
        MyAdressPage myAdressPage = new MyAdressPage(baseFunc);
        myAdressPage.updateFirstName(firstname);
    }

    @Then("^new info is displayed in my profile address box$")
    public void newInfoIsDisplayedInMyProfileAddressBox() {

        MyAdressPage myAdressPage = new MyAdressPage(baseFunc);
        myAdressPage.getStringFromAddress();

        baseFunc.closePage();
    }
}



