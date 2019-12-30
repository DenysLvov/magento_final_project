package denys.page_objects;

import denys.elements.Button;
import denys.elements.InputField;
import denys.elements.TextField;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage{

    private By pageTitle = By.xpath("//div[@class='page-title']/h1");
    private By emailField = By.xpath("//input[@type='email'][@title='Email Address']");
    private By passwordField = By.xpath("//input[@type='password'][@title='Password']");
    private By loginBtn = By.xpath("//button[@title='Login']");

    @Getter
    public TextField PageHeader = new TextField(pageTitle,"Header");

    @Getter
    public InputField Email = new InputField(emailField,"Email field");

    @Getter
    public InputField Password = new InputField(passwordField,"Password field");

    @Getter
    public Button Login = new Button(loginBtn,"Login");

    //Constructors
    public LoginPage() {
        isLoginPageOpened();
    }

    private void isLoginPageOpened() {
        getPageHeader().verify();
    }

    @Step
    public LoginPage fillEmailField(String email){
        getEmail().setText(email);
        //Assert.assertEquals(email, Email.getText(), String.format("Expected email %s but entered was %s",email, Email.getText()));
        return this;
    }

    @Step
    public LoginPage fillPasswordField(String password){
        getPassword().setText(password);
        //Assert.assertEquals(password.length(), Password.getText().length(), "Check length of password");
        return this;
    }

    @Step
    public MainPage clickLoginbtn(){
        getLogin().click();
        return new MainPage();
    }


}
