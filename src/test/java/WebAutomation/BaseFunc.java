package WebAutomation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunc {
    WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        Assert.assertFalse("Element not found", getElements(locator).isEmpty());
        return driver.findElement(locator);
    }

    public void closePage() {
        driver.quit();
    }


}
