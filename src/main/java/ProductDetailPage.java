import jdk.nashorn.internal.AssertsEnabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage extends BasePage {

    By addToCartButtonLocator = By.id("addBasket");
    By cartProductPriceLocator = By.id("priceNew");
    By productPriceLocator = new By.ByClassName("m-productCard__newPrice");
    By goToCart = new By.ByClassName("o-header__userInfo--count");
    By increaseProductLocator = By.id("quantitySelect0");
    By removeProductLocator = By.id("removeCartItemBtn0");
    By controlCartLocator = By.id("m-empty__messageBtn");
    By productNum = new By.ByXPath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[1]/div[2]/ul/li[3]/div[2]/div/select/option[2]");
    private static String cartPrice;
    private static String productPrice;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        productPrice = driver.findElement(productPriceLocator).getText();
        click(addToCartButtonLocator);
    }

    public void goToCart() {
        cartPrice = driver.findElement(cartProductPriceLocator).getText();
        click(goToCart);
    }

    public void increaseProduct() {
        WebElement productNumber = driver.findElement(increaseProductLocator);
        Select select = new Select(productNumber);
        select.selectByValue("2");
    }

    public void removeProduct() throws InterruptedException {
        driver.findElement(removeProductLocator).click();
        Thread.sleep(2000);
    }

    public boolean checkIfProductUp() {
        return isDisplayed(productNum);
    }

    public boolean isCartEmpty() {
        return isDisplayed(controlCartLocator);
    }

    public String getCartPrice() {
        return cartPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void selectSize() {

        WebElement size = driver.findElement(new By.ByClassName("m-variation__item -criticalStock"));
        Actions actions = new Actions(driver);
        actions.moveToElement(size);
        actions.perform();
    }
}
