package denys.stepsdefinition;

import denys.page_objects.LoginPage;
import denys.page_objects.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;

import static denys.DriverManager.getDriver;
import static denys.DriverManager.killDriver;

public class StepsDefinitionTest {

    @After
    public void shutDown() {
        killDriver();
    }

    private String URL = "http://magento.mainacad.com/index.php/english";

    MainPage mainPage;
    LoginPage loginPage;

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
    public void iHaveWebSiteByUrl(String url) {
        getDriver().get(url);
        mainPage = new MainPage();
    }

    @When("I choose language {string}")
    public void iChooseLanguage(String lang) {
        switch (lang) {
            case "automation":
                mainPage.setLanguage(MainPage.Language.AUTOMATION);
                break;
            case "english":
                mainPage.setLanguage(MainPage.Language.ENGLISH);
                break;
            default:
                mainPage.setLanguage(MainPage.Language.AUTOMATION);
        }
    }

    @And("I click Account - Login")
    public void iClickAccountLogin() {
        loginPage = mainPage.clickAccount()
                .clickLogIn();
    }

    @Then("Login or create account page is opened")
    public void loginOrCreateAccountPageIsOpened() {
        Assert.assertEquals(loginPage.getPageHeader().getText().toLowerCase(), "login or create an account");
    }
}
