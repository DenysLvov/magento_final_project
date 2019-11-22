package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import lombok.Getter;
import org.openqa.selenium.By;


public class MainPage {

    private By languageDropDown = By.xpath("//select[@id='select-language']");
    private By homeAndDecorMenu = By.xpath(" //a[@class='level0 has-children'][contains(text(),'Home & Decor')]");
    private By electronicsSubMenu = By.xpath("//a[contains(text(),'Electronics')]");

    @Getter
    DropDownList LanguageDropDown = new DropDownList(languageDropDown, "Language dropdown list");

    @Getter
    Button HomeAndDecorButton = new Button(homeAndDecorMenu, "HOME&DECOR");

    enum Language {
        AUTOMATION("Automation"),
        ENGLISH("English");

        private String text;

        Language(String text) {
            this.text=text;
        }

        @Override
        public String toString(){
            return text;
        }
    }

    public MainPage setLanguage(Language language) {
        getLanguageDropDown().select(language.toString());
        return this;
    }
}
