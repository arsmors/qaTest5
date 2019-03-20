package WebAutomation.Pages;

import org.openqa.selenium.By;

public class CheckoutPage {

    BaseFunc baseFunc;

    public CheckoutPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By TOTALPRICEWITHOUTTAX = By.xpath("//*[@id=\"total_price_without_tax\"]");
    private final By TOTALPRICE = By.xpath("//*[@id=\"total_price_container\"]/span");

    public String getItemPriceWithoutTax() {
        return baseFunc.getElement(TOTALPRICEWITHOUTTAX).getText();
    }

    public String getItemPriceTotal() {
        return baseFunc.getElement(TOTALPRICE).getText();
    }


}
