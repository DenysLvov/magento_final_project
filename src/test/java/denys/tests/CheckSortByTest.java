package denys.tests;

import denys.page_objects.Electronics;
import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckSortByTest extends BaseTest {

    @Test(description = "Price of each next item > than previous if SORT BY = 'Price'")
    public void checkSortBy() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .setSortBy(Electronics.SortBy.PRICE)
                .checkPrices();

    }
}
