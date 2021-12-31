import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBox extends BasePage {

    By searchBoxLocator = By.xpath("/html/body/header/div/div/div[2]/div/div/div/input");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator, text);
        driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/button")).sendKeys(Keys.ENTER);

    }
}
