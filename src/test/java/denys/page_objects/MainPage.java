package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import lombok.Getter;
import org.openqa.selenium.By;


public class MainPage {

    private By languageDropDownLst = By.xpath("//select[@id='select-language']");
    private By homeAndDecorBtn = By.xpath(" //a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronicsSubMenu = By.xpath("//a[contains(text(),'Electronics')]");

    @Getter
    private DropDownList LanguageDropDown = new DropDownList(languageDropDownLst, "Language dropdown list");

    @Getter
    private Button HomeAndDecor = new Button(homeAndDecorBtn, "HOME&DECOR");

    @Getter
    private Button ElectronicsSubMenu = new Button(electronicsSubMenu, "HOME&DECOR - Electronics");


    // enums for Your Language menu
    enum Language {
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

    public MainPage setLanguage(Language language) {
        getLanguageDropDown().select(language.toString());
        return this;
    }

    public MainPage clickHomeAndDecorMenu() {
        getHomeAndDecor().click();
        return this;
    }

    //Q1: Is it correct? - class will have giant num of methods.
    //Q2: How to call Electronics only in Home & Decor context
    //Q3: Is Home & Decor
    public Electronics clickOnElectronicsItem() {
        getElectronicsSubMenu().click();
        return new Electronics();
    }


}