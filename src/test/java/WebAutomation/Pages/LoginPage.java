package WebAutomation.Pages;

import org.openqa.selenium.By;

public class LoginPage {

    BaseFunc baseFunc;

    public LoginPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void enterLoginDetails(String login) {
        baseFunc.getElement(By.id("email")).click();
        baseFunc.getElement(By.id("email")).sendKeys(login);
    }

    public void enterPasswordDetails(String password) {
        baseFunc.getElement(By.id("passwd")).click();
        baseFunc.getElement(By.id("passwd")).sendKeys(password);
    }

    public void clickSubmitButton() {
        baseFunc.getElement(By.id("SubmitLogin")).click();
    }
}
