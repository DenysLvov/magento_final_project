package denys.tests;

import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckAddToWishListTest extends BaseTest {

    @Test(description = "My Wishlist shows chosen item")
    public void checkWishListItems() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .clickAccount()
                .clickLogIn()
                .fillEmailField("den_lvov@meta.ua")
                .fillPasswordField("123456")
                .clickLoginbtn()
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25");
        //TODO: chooseRandomItem{}
        //TODO: clickAddToWish()
        //TODO: check WISHLIST
    }
}