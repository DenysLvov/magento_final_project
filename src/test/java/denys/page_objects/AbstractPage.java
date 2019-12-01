package denys.page_objects;

import denys.elements.Button;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.Assertion;

import static denys.DriverManager.getDriver;

public class AbstractPage {
    protected Assertion softAssert = new Assertion();

    private By accountBtn = By.xpath("//span[@class='label'][(contains(text(),'Account'))]");
    private By logInBtn = By.xpath("//div[@class='links']//a[@title='Log In']");


    @Getter
    private Button Account = new Button(accountBtn, "ACCOUNT button");

    @Getter
    private Button Login = new Button(logInBtn, "ACCOUNT -> LogIn button");


    //Constructor
    public AbstractPage(){

        //close banner
        ((JavascriptExecutor)getDriver()).executeScript("document.getElementById('close-fixedban').click()");
    }


    @Step
    public MainPage clickAccount(){
        getAccount().click();
        return new MainPage();
    }

    @Step
    public LoginPage clickLogIn(){
        getLogin().click();
        return new LoginPage();
    }
}
