package WebAutomation;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EditBio {
    BaseFunc baseFunc = new BaseFunc();


    private final String MY_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
    private final By ADDRESSES = By.xpath(".//*[@title='Addresses']");
    private final By UPDATE = By.xpath(".//*[@title='Update']");
    private final By CITY = By.xpath("//input[@id='city']");
    private final By SAVE_BUTTON = By.xpath("//button[@id='submitAddress']");
    private final By ADDRESS_BOX = By.xpath("//ul[@class='last_item item box']//li");

    @When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterAnd(String login, String password) throws InterruptedException {
        baseFunc.openPage(MY_ACCOUNT);

        baseFunc.driver.findElement(By.id("email")).click();
        baseFunc.driver.findElement(By.id("email")).sendKeys(login);
        Thread.sleep(2000);
        baseFunc.driver.findElement(By.id("passwd")).click();
        baseFunc.driver.findElement(By.id("passwd")).sendKeys(password);
        baseFunc.driver.findElement(By.id("SubmitLogin")).click();
    }

    @And("^go to My Addresses$")
    public void goToMyAddresses() {

        baseFunc.driver.findElement(ADDRESSES).click();
        baseFunc.driver.findElement(UPDATE).click();
    }

    @And("^update City with \"([^\"]*)\"$")
    public void updateCityWith(String city) {
        baseFunc.driver.findElement(CITY).click();
        baseFunc.driver.findElement(CITY).clear();
        baseFunc.driver.findElement(CITY).sendKeys(city);
        baseFunc.driver.findElement(SAVE_BUTTON).click();
    }

    @Then("^new info is displayed in my profile address box$")
    public void newInfoIsDisplayedInMyProfileAddressBox() {

        Boolean isStringFound = false;
        List<WebElement> listOfElements = baseFunc.driver.findElements(ADDRESS_BOX);
        for (int i = 0; i < listOfElements.size(); i++) {
            WebElement li = listOfElements.get(i);
            List<WebElement> spans = li.findElements(By.tagName("span"));
            if (!spans.isEmpty() && spans.get(0).getText().equals("hello there,")) {
                isStringFound = true;
                break;
            }
        }

        Assert.assertTrue("No String item is found", isStringFound);
    }
}



