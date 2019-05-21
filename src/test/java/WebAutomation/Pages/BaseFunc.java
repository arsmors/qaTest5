package WebAutomation.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {
    public WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

        //TODO: cross browser support - to support FireFox as well
        driver = new ChromeDriver();
    }

    public void openPage(String url) {

        //TODO: move to somewhere common
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }


    //TODO: if needed 0 elements - update this
    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }


    //TODO: update this or say to me why you should NOT be updated
    public WebElement getElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found");
            return null;
        }
    }

    public void closePage() {
        driver.quit();
    }
}
