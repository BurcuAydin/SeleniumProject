import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    SearchBox searchBox;
    By productPriceLocator = By.id("m-productCard__newPrice");


    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }


    public SearchBox searchBox() {

        return this.searchBox;
    }


}

