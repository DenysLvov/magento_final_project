package denys.tests;

import denys.page_objects.MainPage;
import org.testng.annotations.Test;

public class CheckShowSelectTest extends BaseTest{

    @Test(description = "Only 5 items are shown on each page if SHOW selection was set to 5")
    public void  checkShowSelect(){
        MainPage mainPage = new MainPage();

        mainPage.setLanguage(MainPage.Language.ENGLISH)
                .focusHomeAndDecorMenu()
                .clickOnElectronicsItem()
                .clickShowAsList()
                .clickShowDropDown("5").clickNextPgBtn();


        //Magic should be here


    }
}
