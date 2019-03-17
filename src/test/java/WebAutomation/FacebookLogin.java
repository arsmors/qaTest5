package WebAutomation;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FacebookLogin {

    WebDriver driver;
    private final String STRING_NAME ="Bob Bobbing";
    private final By PROFILE_NAME = By.xpath(".//*[@class = 'homeSideNav']");



    @Given("^Open Chrome and go to Facebook page$")
    public void openChromeAndGoToFacebookPage() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterValidLoginAndPassword(String login, String password) {
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("loginbutton")).click();
    }


    @Then("^I should be login successfully$")
    public void iShouldBeLoginSuccessfully() {

        Boolean isStringFound = false;

        List<WebElement> listOfElements = new ArrayList<WebElement>();
        listOfElements = driver.findElements(PROFILE_NAME);
        for (int i = 0; i < listOfElements.size() ; i++) {
            if (listOfElements.get(i).getText().equals(STRING_NAME)) {
                isStringFound = true;
                break;
            }
        }

        Assert.assertTrue("Login fail ", isStringFound);
        driver.close();
    }
}
