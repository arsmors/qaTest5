package WebAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    BaseFunc baseFunc;
    private final By MAIN = By.xpath(".//*[@class=\"sf-menu clearfix menu-content sf-js-enabled sf-arrows\"]/li/a");
    private final By ADDTOCART = By.xpath("//*[@title=\"Add to cart\"]/span");
    private final By PROCEEDTOCHECKOUT = By.xpath("//*[@title=\"Proceed to checkout\"]");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectMenuItem(String item) {
        List<WebElement> menuItems = baseFunc.getElements(MAIN);
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(item)) {
                menuItems.get(i).click();
                break;
            }
        }
    }

    public void addItemToCart(Integer id) {
        getItems(id).click();
    }

    private WebElement getItems(Integer id) {
        List<WebElement> items = baseFunc.getElements(ADDTOCART);
        return items.get(id);
    }

    public void proceedToCheckout() {
        baseFunc.getElement(PROCEEDTOCHECKOUT).click();
    }

}
