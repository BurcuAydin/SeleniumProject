import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    By filterLocator = By.id("productFilterOpenButton");
    By moreProductLocator = By.id("moreContentButton");
    By productNameLocator = new By.ByClassName("m-productCard__desc");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct() {


        List<WebElement> products = driver.findElements(new By.ByClassName("m-productCard__desc"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(products.size());
        products.get(randomProduct).click();
    }

    public boolean isOnProductPage() {

        return isDisplayed(filterLocator);
    }

    public void scrollDown() {

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        WebElement element = driver.findElement(By.id("moreContentButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void click() {
        driver.findElement(moreProductLocator).click();

    }

    private List<WebElement> getAllProducts() {

        return findAll(productNameLocator);
    }

}
