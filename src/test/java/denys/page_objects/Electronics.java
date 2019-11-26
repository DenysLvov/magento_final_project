package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import denys.elements.TextField;
import denys.helpers.StringProcessor;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static denys.DriverManager.getDriver;

public class Electronics extends AbstractPage {

    private By showAsListBtn = By.xpath("(//a[@class='list'])[1]");
    private By showSelectionLst = By.xpath("(//select[@title='Results per page'])[1]");
    private By productInList = By.xpath("//div[@class='product-primary']");
    private By nextPgArrowBtn = By.xpath("//a[@title='Next'][1]");
    private By pagesNumber = By.xpath("//p[@class='amount amount--has-pages']");
    private By sortByDropDwnList = By.xpath("//select[@title='Sort By']");
    private By item = By.xpath("//*[@id='products-list']/li");
    private By itemPrice = By.xpath("//div[@class='price-box']//span[@class='price']");

    @Getter
    private Button ShowAsList = new Button(showAsListBtn, "Show as list");

    @Getter
    private Button NextPgSmallArrowBtn = new Button(nextPgArrowBtn, "Next page arrow");

    @Getter
    private DropDownList ShowSelectionList = new DropDownList(showSelectionLst, "SHOW list");

    @Getter
    private TextField PagesAmount = new TextField(pagesNumber, "SHOW list");

    @Getter
    private DropDownList SortBy = new DropDownList(sortByDropDwnList, "SORT BY drop-down list");

    @Getter
    private TextField ItemPrice = new TextField(itemPrice, "Price of a product");

    @Step
    public Electronics clickShowAsList() {
        ShowAsList.click();
        return this;
    }

    @Step
    public Electronics clickShowDropDown(String value) {
        ShowSelectionList.select(value);
        return this;
    }

    @Step
    public int getProductsNumber() {
        List<WebElement> welist = getDriver().findElements(productInList);
        return welist.size();
    }

    public void checkNumbersOfItemsOnEachPage(int expectedItems) {
        int pageNumber = 1;
        do {
            if (pageNumber != 1)
                getNextPgSmallArrowBtn().click();
            //Counts items on the page
            int numberOfItems = getDriver().findElements(item).size();
            if (getNextPgSmallArrowBtn().isExists(1)) {
                Assert.assertEquals(numberOfItems, expectedItems,
                        String.format("Expect %s items, but found %s items on page %s",
                                expectedItems, numberOfItems, pageNumber));
            } else {
                Assert.assertTrue(numberOfItems <= expectedItems,
                        String.format("Expect not more than %s items, but found %s items on page %s",
                                expectedItems, numberOfItems, pageNumber));
            }
            pageNumber++;
        } while (getNextPgSmallArrowBtn().isExists(1));
    }

    public enum SortBy {
        POSITION("Position"),
        NAME("Name"),
        PRICE("Price");

        private String text;

        SortBy(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public Electronics setSortBy(SortBy SortBy) {
        getSortBy().select(SortBy.toString());
        return this;
    }

    public void checkPrices() {
       List<WebElement> eltList = getDriver().findElements(itemPrice);
        for (int i = 0; i < eltList.size() - 1; i++) {
            double priceCurrent = StringProcessor.stringToDouble(eltList.get(i).getText());
            double priceNext = StringProcessor.stringToDouble(eltList.get(i + 1).getText());
            Assert.assertTrue(priceNext > priceCurrent,
                    String.format("Expect price %s of next item bigger than price %s of current item",priceNext, priceCurrent));
        }
    }
}
