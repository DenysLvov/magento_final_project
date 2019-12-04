package denys.stepsdefinition;

import cucumber.api.java.en.Given;

public class StepsDefinitionTest {

    private String URL;

    @Given("I have website {string}")
    public void iHaveWebSiteByUrl(String url) {
        URL = url;
    }
}
