import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return true;
    }

    public boolean isProductPriceEqual() {
        return true;
    }
}
