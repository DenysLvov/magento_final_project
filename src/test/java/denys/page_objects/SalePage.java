package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class SalePage extends AbstractPage{

    private By gridViewBtn = By.xpath("//strong[@title='Grid']");
    private By showSelectionLst = By.xpath("(//select[@title='Results per page'])[1]");
    private By itemPrice = By.xpath("//div[@class='price-box']");


    @Getter
    private Button GridView = new Button(gridViewBtn,"Grid view icon");

    @Getter
    private DropDownList ShowSelectionList = new DropDownList(showSelectionLst, "SHOW list");


    @Step
    public SalePage clickgridView(){
        GridView.click();
        return this;
    }

    @Step
    public SalePage clickShowDropDown(String value) {
        ShowSelectionList.select(value);
        return this;
    }


}
