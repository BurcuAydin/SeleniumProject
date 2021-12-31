import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestAddProductToCart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;


    //Ana sayfanın açıldığı kontrol edilir. Sitede hesabım, favorilerim, sepetim, alanları kontrol edilir.
    @Test
    @Order(1)
    public void check() throws InterruptedException {
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.beymen.com/");

        Boolean isPresentAccount = driver.findElements(By.className("o-header__userInfo--item bwi-account-o -customer")).size() > 0;
        Boolean isPresentFav = driver.findElements(By.className("o-header__userInfo--item bwi-favorite-o -favorite")).size() > 0;
        Boolean isPresentCart = driver.findElements(By.className("o-header__userInfo--item bwi-cart-o -cart")).size() > 0;
    }

    @Test
    @Order(2)
    public void search_product() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.searchBox().search("pantolan");
        //Assertions.assertTrue(productsPage.isOnProductPage(),"Not on products page.");
        Thread.sleep(3500);
    }

    @Test
    @Order(3)
    public void scroll() throws InterruptedException {
        productsPage = new ProductsPage(driver);
        productsPage.scrollDown();
        Thread.sleep(2500);
    }

    @Test
    @Order(4)
    public void click_more_product() throws InterruptedException {

        productsPage.click();
        Thread.sleep(3500);
    }

    @Test
    @Order(5)
    public void select_product() {
        productsPage.selectProduct();
        Assertions.assertTrue(productDetailPage.isOnProductPage(), "Not on product detail page.");
    }


    @Test
    @Order(6)
    public void add_product_to_cart() {

        productDetailPage = new ProductDetailPage(driver);
        productDetailPage.selectSize();
        productDetailPage.addToCart();

    }

    @Test
    @Order(7)
    public void go_to_cart() {
        cartPage = new CartPage(driver);
        productDetailPage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(), "Product was not added to cart.");
        Assertions.assertTrue(cartPage.isProductPriceEqual(), "Product price is not equal.");
    }

    @Test
    @Order(8)
    public void compare_price() {
        Assertions.assertEquals(productDetailPage.getCartPrice(), productDetailPage.getProductPrice());
    }

    @Test
    @Order(9)
    public void product_up() {
        productDetailPage.increaseProduct();
        Assertions.assertTrue(productDetailPage.checkIfProductUp(), "Product was not increase.");
    }


}
