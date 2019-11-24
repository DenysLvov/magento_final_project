package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import denys.elements.TextField;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static denys.DriverManager.getDriver;

public class Electronics extends AbstractPage {

    private By showAsListBtn = By.xpath("(//a[@class='list'])[1]");
    private By showSelectionLst = By.xpath("(//select[@title='Results per page'])[1]");
    private By productInList = By.xpath("//div[@class='product-primary']");
    private By nextPgArrowBtn = By.xpath("//div[@class='toolbar-bottom']//a[@class='next i-next']");
    private By pagesAmount = By.xpath("//p[@class='amount amount--has-pages']");

    @Getter
    private Button ShowAsList = new Button(showAsListBtn, "Show as list");

    @Getter
    private Button NextPgSmallArrowBtn = new Button(nextPgArrowBtn, "Next page arrow");

    @Getter
    private DropDownList ShowSelectionList = new DropDownList(showSelectionLst,"SHOW list");

    @Getter
    private TextField PagesAmount = new DropDownList(pagesAmount,"SHOW list");

    @Step
    public Electronics clickShowAsList() {
        ShowAsList.click();
        return this;
    }

    @Step
    public Electronics clickShowDropDown(String value){
        ShowSelectionList.select(value);
        return this;
    }

    @Step
    public int getProductsNumber(){
        List<WebElement> welist = getDriver().findElements(productInList);
        return welist.size();
    }

    public Electronics clickNextPgBtn() {
     while(getNextPgSmallArrowBtn().isEnabled()) {
         ((JavascriptExecutor) getDriver()).executeScript("document.getElementsByClassName('next i-next')[0].click()");
     }
        return this;
    }
}
