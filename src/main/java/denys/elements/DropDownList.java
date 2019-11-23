package denys.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDownList extends TextField{
    public DropDownList(By locator, String description) {
        super(locator, description);
    }

    @Step ("select by id")
    public void select(int id){
        getSelectElement().selectByIndex(id);
    }

    @Step ("select by text")
    public void select(String text){
        getSelectElement().selectByVisibleText(text);
    }

    private Select getSelectElement(){
        return new Select(get());
    }

    public void click(){
        get().click();
    }
}
