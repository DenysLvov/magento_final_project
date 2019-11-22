package denys.page_objects;

import org.openqa.selenium.JavascriptExecutor;

import static denys.DriverManager.getDriver;

public class AbstractPage {

    public AbstractPage(){

        //close banner
        ((JavascriptExecutor)getDriver()).executeScript("document.getElementById('close-fixedban').click()");
    }
}
