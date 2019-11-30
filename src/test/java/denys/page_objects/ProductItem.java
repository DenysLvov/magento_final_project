package denys.page_objects;

import denys.elements.BaseElement;
import denys.elements.Button;
import denys.elements.TextField;
import lombok.Getter;
import org.openqa.selenium.By;
/*
*   POM: Product card (details)
* */
public class ProductItem {

    private By itemPrice = By.xpath("//div[@class='price-box']//span[@class='price']");
    private By itemName = By.cssSelector("#products-list .product-name");
    private By addToWishListBtn = By.cssSelector(" .add-to-links  .link-wishlist");

    @Getter
    private TextField ItemPrice = new TextField(itemPrice, "Price of a product");

    @Getter
    private TextField Name = new TextField(itemName, "Product name");

    @Getter
    private Button addToWishList = new Button(addToWishListBtn,"Add To Wish list");

}
