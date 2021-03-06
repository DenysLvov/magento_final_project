package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;


public class MainPage extends AbstractPage{

    private By languageDropDownLst = By.xpath("//select[@id='select-language']");
    private By homeAndDecorBtn = By.xpath(" //a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronicsSubMenu = By.xpath("//a[contains(text(),'Electronics')]");
    private By saleBtn = By.xpath("//a[contains(text(),'Sale')]");


    @Getter
    private DropDownList LanguageDropDown = new DropDownList(languageDropDownLst, "Language dropdown list");

    @Getter
    private Button HomeAndDecor = new Button(homeAndDecorBtn, "Main menu HOME&DECOR");

    @Getter
    private Button ElectronicsSubMenu = new Button(electronicsSubMenu, "HOME&DECOR - Electronics");

    @Getter
    private Button Sale = new Button(saleBtn, "Main menu SALE");


    // enums for Your Language menu
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

    @Step
    public MainPage setLanguage(Language language) {
        getLanguageDropDown().select(language.toString());
        return this;
    }

    @Step
    public MainPage focusHomeAndDecorMenu() {
        getHomeAndDecor().setFocusOn();
        return this;
    }

    @Step
    public ElectronicsPage clickOnElectronicsItem() {
        getElectronicsSubMenu().click();
        return new ElectronicsPage();
    }

    @Step
    public SalePage clickOnSale() {
        getSale().click();
        return new SalePage();
    }


}
