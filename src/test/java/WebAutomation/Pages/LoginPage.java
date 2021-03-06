package WebAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    BaseFunc baseFunc;

    //TODO: create Page object and page factory (FindBy)
    private final By SIGNIN = By.xpath("//*[@class = \"login\"]");
    private final By LOGOUT = By.xpath("//*[@class = \"logout\"]");
    private final String HOMEPAGE = "http://automationpractice.com";

    //TODO: not a page object
    private String my_account = "/index.php?controller=my-account";
    private String sign_page = "/index.php?controller=authentication&back=my-account";
    private final String SIGN_PAGE = HOMEPAGE + sign_page;
    private final String MY_ACCOUNT = HOMEPAGE + my_account;
    //ends here

    private final By EMAIL = By.id("email");
    private final By PASSWORD = By.id("passwd");
    private final By SUMBIT = By.id("SubmitLogin");

    public LoginPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void enterLoginDetails(String login) {
        baseFunc.getElement(EMAIL).click();
        baseFunc.getElement(EMAIL).sendKeys(login);
    }

    public void enterPasswordDetails(String password) {
        baseFunc.getElement(PASSWORD).click();
        baseFunc.getElement(PASSWORD).sendKeys(password);
    }

    public void clickSubmitButton() {
        baseFunc.getElement(SUMBIT).click();
    }

    public String getLogOut() {
        //TODO: move all waits to common steps (BaseFunc?)
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
