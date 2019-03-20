package WebAutomation.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAdressPage {

    BaseFunc baseFunc;
    private final By ADDRESSES = By.xpath(".//*[@title='Addresses']");
    private final By UPDATE = By.xpath(".//*[@title='Update']");
    private final By FIRSTNAME = By.xpath("//input[@id='firstname']");
    private final By SAVE_BUTTON = By.xpath("//button[@id='submitAddress']");
    private final By ADDRESS_BOX = By.xpath("//ul[@class='last_item item box']//li");

    public MyAdressPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void goToMyAddressPage() {
        baseFunc.getElement(ADDRESSES).click();
        baseFunc.getElement(UPDATE).click();
    }

    public void updateFirstName(String firstname) {
        baseFunc.getElement(FIRSTNAME).click();
        baseFunc.getElement(FIRSTNAME).clear();
        baseFunc.getElement(FIRSTNAME).sendKeys(firstname);
        baseFunc.getElement(SAVE_BUTTON).click();
    }

    public void getStringFromAddress() {
        boolean isStringFound = false;
        List<WebElement> listOfElements = baseFunc.getElements(ADDRESS_BOX);
        for (int i = 0; i < listOfElements.size(); i++) {
            if (listOfElements.get(i).getText().contains("arsenss")) {
                isStringFound = true;
                break;
            }
        }

        Assert.assertTrue("No String item is found", isStringFound);
    }
}
