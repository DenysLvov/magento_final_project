package denys.tests;

import denys.page_objects.MainPage;
import denys.page_objects.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckAddToWishListTest extends BaseTest {

    @Test(description = "My Wishlist shows chosen item")
    public void checkWishListItems() {
        MainPage mainPage = new MainPage();

        String expProdName = mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .clickAccount()
                .clickLogIn()
                //TODO: move this to external file
                .fillEmailField("den_lvov@meta.ua")
                .fillPasswordField("123456")
                .clickLoginbtn()
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .addRandomProductToWishList();
        List<String> actualNamesList = new WishListPage().getItemNames();
        Assert.assertTrue(actualNamesList.contains(expProdName),
                String.format("Expected product %s not found in list %s", expProdName, actualNamesList));
    }
}