package WebAutomation.Pages;

import org.openqa.selenium.By;

public class MyAdressPage {

    BaseFunc baseFunc;
    private final By ADDRESSES = By.xpath(".//*[@title='Addresses']");
    private final By UPDATE = By.xpath(".//*[@title='Update']");
    private final By FIRSTNAME = By.xpath("//input[@id='firstname']");
    private final By SAVE_BUTTON = By.xpath("//button[@id='submitAddress']");

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
}
