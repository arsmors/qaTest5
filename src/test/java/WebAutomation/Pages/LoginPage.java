package WebAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    BaseFunc baseFunc;
    private final By SIGNIN = By.xpath("//*[@title='Log in to your customer account']");
    private final By LOGOUT = By.xpath("//*[@title='Log me out']");
    private final String MY_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";
    private final String HOMEPAGE = "http://automationpractice.com";
    private final String SIGN_PAGE = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

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

    public String getLogOut() {
        WebDriverWait wait = new WebDriverWait(baseFunc.driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(LOGOUT));
        return baseFunc.getElement(LOGOUT).getText();
    }

    public String getSignIn() {
        WebDriverWait wait = new WebDriverWait(baseFunc.driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(SIGNIN));
        return baseFunc.getElement(SIGNIN).getText();
    }

    public void openMyAccountPage() {
        baseFunc.openPage(MY_ACCOUNT);
    }

    public void openHomePage() {
        baseFunc.openPage(HOMEPAGE);
    }

    public void openSignInPage() {
        baseFunc.openPage(SIGN_PAGE);
    }

}
