package denys.stepsdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import denys.page_objects.MainPage;
import org.openqa.selenium.WebDriver;

import static denys.DriverManager.getDriver;

public class StepsDefinitionTest {

    private String URL = "http://magento.mainacad.com/index.php/english";
    WebDriver  webDriver;


    MainPage mainPage = new MainPage();



    public enum Language {
        AUTOMATION("Automation"),
        ENGLISH("English");

        private String text;

        Language(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    @Given("I have website {string}")
    public void iHaveWebSiteByUrl(String url){
        webDriver = getDriver();
        webDriver.get(url);
    }

    @When("I choose language {string}")
    public void iChooseLanguage(String arg0) {
        mainPage.setLanguage(MainPage.Language.AUTOMATION);
        }
}
