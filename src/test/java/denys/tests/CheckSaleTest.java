package denys.tests;

import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckSaleTest extends BaseTest{

    @Test(description = "Check 'Old and 'Sale' prices in SALE")
    public void checkOldSalePrices() {
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.AUTOMATION)
                .clickOnSale()
                .clickgridView()
                .clickShowDropDown("36");
    }

}
