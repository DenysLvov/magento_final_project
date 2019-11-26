package denys.page_objects;

import denys.elements.Button;
import denys.elements.DropDownList;
import denys.elements.TextField;
import denys.helpers.StringProcessor;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
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
    private By priceSelection0_999 = By.xpath("(//a/span[@class='price']//..)[1]");
    private By priceSelection1000above= By.xpath("(//a/span[@class='price']//..)[4]");

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

    @Getter
    private Button PriceSelectionFilterOne = new Button(priceSelection0_999, "PRICE selection from 0 - 999");

    @Getter
    private Button PriceSelectionFilterTwo = new Button(priceSelection1000above, "PRICE selection from 0 - 999");

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

    @Step
    public Electronics clickPriceFilter(String filter) {
        switch (filter) {
            case "0-999":
                PriceSelectionFilterOne.click();
                break;
            case "1.000.000 and above":
                PriceSelectionFilterTwo.click();
                break;
            }
        return this;
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

    // Check prices sorted from low to high
    public void checkSortedPrices() {
        List<WebElement> eltList = getDriver().findElements(itemPrice);
        for (int i = 0; i < eltList.size() - 1; i++) {
            double priceCurrent = StringProcessor.stringToDouble(eltList.get(i).getText());
            double priceNext = StringProcessor.stringToDouble(eltList.get(i + 1).getText());
            Assert.assertTrue(priceNext > priceCurrent,
                    String.format("Expect price %s of next item bigger than price %s of current item", priceNext, priceCurrent));
        }
    }

    //Check prices < 100
    public void checkPricesValues() {
        List<WebElement> eltList = getDriver().findElements(priceSelection0_999);
        for (WebElement e : eltList) {
            double price = StringProcessor.stringToDouble(e.getText());
            Assert.assertTrue(price < 100.00, String.format("Price %s less than 100", price));
        }

    }
}
