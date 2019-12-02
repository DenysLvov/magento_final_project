package denys.tests;

import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckShowSelectTest extends BaseTest{

    @Test(description = "Only 5 items are shown on each page if SHOW selection was set to 5")
    public void  checkShowSelect(){


        mainPage
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("5")
                .checkNumbersOfItemsOnEachPage(5);
        }
}
