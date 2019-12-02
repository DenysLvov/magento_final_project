package denys.tests;

import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckSaleTest extends BaseTest{

    @Test(description = "Check 'Old and 'Sale' prices in SALE")
    public void checkOldSalePrices() {


        mainPage
                .clickOnSale()
                .clickgridView()
                .clickShowDropDown("36")
                .comparePrices();
    }

}
