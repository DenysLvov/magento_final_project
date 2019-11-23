package denys.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static denys.DriverManager.getDriver;
import static denys.DriverManager.killDriver;

public class BaseTest {

    @BeforeClass
    public void setupPage(){
        getDriver().get("http://magento.mainacad.com/index.php/english/");
    }

    @AfterClass
    public void tearDown(){
        killDriver();
    }
}
