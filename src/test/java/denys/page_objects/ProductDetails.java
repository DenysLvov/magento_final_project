package denys.page_objects;

import denys.elements.Button;
import denys.elements.TextField;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class ProductDetails extends AbstractPage {

    private By productName = By.xpath("//div[@class='product-shop']/div[@class='product-name']");
    private By productPrice = By.xpath("//span[@class='regular-price']//span[@class='price']");
    private By addToCartBtn = By.xpath("//div[@class='add-to-cart-buttons']//button[@class='button btn-cart']");

    @Getter
    private TextField ProductName = new TextField(productName,"Product Name");

    @Getter
    private TextField ProductPrice = new TextField(productPrice,"Product Price");

    @Getter
    private Button AddToCart = new Button(addToCartBtn,"Add To Cart");

    @Step
    public CartPage clickAddToCart(){
        String productName = ProductName.getText();
        String productPrice = ProductPrice.getText();
        log.info("Prod. details: Name: "+productName);
        log.info("Prod. details: Price: "+productPrice);
        getAddToCart().click();
        return new CartPage(productName, productPrice);
    }
}
