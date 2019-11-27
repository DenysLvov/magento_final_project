package denys.tests;

import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckPriceFilterTest extends BaseTest {

    @Test(description = "Verify that price of all items is less than 100 if 'PRICE $0-$999' set ON")
    public void checkPriceFilter() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .clickPriceFilter("0-999")      //Is it correct?
                .checkPricesValues();
    }
}
