package denys.tests;

import denys.page_objects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckItemsCounterTest extends BaseTest{

    @Test (description = "Number of present items is equal to the counter")
    public void checkItemCounterTest(){
        MainPage mainPage = new MainPage();

        int num = mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25").getProductsNumber();

        Assert.assertEquals(num,12,"Number of products in list = 12");
   }
}
