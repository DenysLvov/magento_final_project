package denys.tests;

import denys.page_objects.MainPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static denys.DriverManager.getDriver;
import static denys.DriverManager.killDriver;

public class BaseTest {
    protected MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void setLang(){
        mainPage=new MainPage().setLanguage(MainPage.Language.valueOf(System.getProperty("language", "english").toUpperCase()));
    }


    @BeforeMethod(alwaysRun = true)
    public void openPage(){
        getDriver().get("http://magento.mainacad.com/index.php/english/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        killDriver();
    }
}
