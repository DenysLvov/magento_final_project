package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static denys.DriverManager.getDriver;

public class Electronics extends AbstractPage {

    private By showAsListBtn = By.xpath("//a[@class='list'])[1]");
    private By showSelectionLst = By.xpath("//select[@title='Results per page'])[1]");
    private By productInList = By.xpath("//div[@class='product-primary']");

    @Getter
    private Button ShowAsList = new Button(showAsListBtn, "Show as list");

    @Getter
    private DropDownList ShowSelectionList = new DropDownList(showSelectionLst,"SHOW list");

    public Electronics clickShowAsList() {
        ShowAsList.click();
        return this;
    }

    public Electronics clickShowDropDown(int value){
        ShowSelectionList.select(value);
        return this;
    }

    public int getProductsnumber(){
        List<WebElement> welist = getDriver().findElements(productInList);
        return welist.size();
    }
}
