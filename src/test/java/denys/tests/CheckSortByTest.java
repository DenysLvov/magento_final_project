package denys.tests;

import denys.page_objects.ElectronicsPage;
import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckSortByTest extends BaseTest {

    @Test(description = "Price of each next item > than previous if SORT BY = 'Price'")
    public void checkSortBy() {


        mainPage
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("25")
                .setSortBy(ElectronicsPage.SortBy.PRICE)
                .checkSortedPrices();

    }
}
