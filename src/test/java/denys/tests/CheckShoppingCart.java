package denys.tests;

import denys.page_objects.CartPage;
import denys.page_objects.MainPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckShoppingCart extends BaseTest {

    @AfterMethod(alwaysRun = true)
    @Step
    public void emptyCart(){
        CartPage cartPage = new CartPage();
        if(cartPage.getEmptyCart().isExists()){
            cartPage.getEmptyCart().click();
        }
    }

    @Test(description = "Check add product to Shopping Cart")
    public void checkShoppingCart() {

        mainPage
                .clickAccount()
                .clickLogIn()
                //TODO: move this to external file
                .fillEmailField("den_lvov@meta.ua")
                .fillPasswordField("123456")
                .clickLoginbtn()
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickGridViewBtn()
                .clickShowDropDown("36")
                .clickRandomProduct()
                .clickAddToCart()
                .checkCartPrices();

    }
}
