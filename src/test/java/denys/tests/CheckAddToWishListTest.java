package denys.tests;

import denys.helpers.DataProviderHelper;
import denys.page_objects.MainPage;
import denys.page_objects.WishListPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CheckAddToWishListTest extends BaseTest {

    /*DataProviderHelper dataProviderHelper = new DataProviderHelper();

    @DataProvider(name ="testdata")
    public Object[][] readCredentials() {
        dataProviderHelper =new DataProviderHelper();
        return dataProviderHelper.readTestData("//testdata.txt");
    } */

    @Test(description = "My Wishlist shows chosen item")
    public void checkWishListItems( ) {


        String expProdName = mainPage.setLanguage(MainPage.Language.ENGLISH)
                .clickAccount()
                .clickLogIn()
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