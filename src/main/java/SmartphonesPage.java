import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SmartphonesPage {
    private static final String SORT_VIEW = ".//*[@id='sort_view']/a";
    private static final String POPULAR_ITEMS = ".//*[@id='filter_sortpopularity']/a";
    private static final String SORT_EXPENSIVE = ".//*[@id='filter_sortexpensive']/a";
    private static final String BANER = ".//*[@id='SubscribePushNotificationPanel']";
    private static final String BANER_CLOSE = ".//*[@id='SubscribePushNotificationPanel']/div/div[3]";
    private static final String LEPRICON = "//img[@class='lepricon']";
    private static final String LEPRICON_CLOSE = "//span[contains(@class, 'exponea')]";
    private static final String ASUS_FILTER = ".//*[@id='filter4']";
    private static final String MEIZU_FILTER = ".//*[@id='filter75382']";
    private static final String LENOVO_FILTER = ".//*[@id='filter120']";
    private static final String PRESTOGIO_FILTER = ".//*[@id='filter57']";
    private static final String XIAOMI_FILTER = ".//*[@id='filter5964']";
    private static final String MAX_PRICE_FIELD_FILTER = ".//*[@id='price[max]']";
    private static final String PRICE_BUTTON_FILTER = "//button[@id='submitprice']";
    private static final String DIAGONAL_MORETHAN_FOUR_FILTER = ".//*[@id='filter50069']";
    private static final String RESULT_ITEMS = "//div[@class='g-i-tile g-i-tile-catalog']";
    private static final String NEEDED_ITEM = ".//*[@id='catalog_goods_block']//div[3]";
    private static final String NEEDED_ITEM_BIG = ".//*[@id='catalog_goods_block']/div/div[3]/div[1]/div/div[1]/div[2]/div[4]/a";

    //li[contains (@id, 'filter16128') and contains (@class, 'pos-fix')]
    private WebDriver driver;


    public SmartphonesPage(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getSortView() {
        return driver.findElement(By.xpath(SORT_VIEW));
    }

    public WebElement getPopularItems() {
        return driver.findElement(By.xpath(POPULAR_ITEMS));
    }

    public WebElement getSortExpensive() {
        return driver.findElement(By.xpath(SORT_EXPENSIVE));
    }

    public WebElement getLepricon() {
        return driver.findElement(By.xpath(LEPRICON));
    }

    public WebElement getLepriconClose() {
        return driver.findElement(By.xpath(LEPRICON_CLOSE));
    }
    public WebElement getBaner() {
        return driver.findElement(By.xpath(BANER));
    }
    public WebElement getBanerClose() {
        return driver.findElement(By.xpath(BANER_CLOSE));
    }

    public WebElement getAsusFilter() {
        return driver.findElement(By.xpath(ASUS_FILTER));
    }

    public WebElement getMeizuFilter() {
        return driver.findElement(By.xpath(MEIZU_FILTER));
    }

    public WebElement getLenovoFilter() {
        return driver.findElement(By.xpath(LENOVO_FILTER));
    }

    public WebElement getPrestigioFilter() {
        return driver.findElement(By.xpath(PRESTOGIO_FILTER));
    }

    public WebElement getXiaomiFilter() {
        return driver.findElement(By.xpath(XIAOMI_FILTER));
    }

    public WebElement getMaxPriceFieldFilter() {
        return driver.findElement(By.xpath(MAX_PRICE_FIELD_FILTER));
    }

    public WebElement getPriceButtonFilter() {
        return driver.findElement(By.xpath(PRICE_BUTTON_FILTER));
    }

    public WebElement getDiagonalMoreThanFour() {
        return driver.findElement(By.xpath(DIAGONAL_MORETHAN_FOUR_FILTER));
    }

    public List<WebElement> getSmartphonesResult() {
        return driver.findElements(By.xpath(RESULT_ITEMS));
    }

    public WebElement getNeededItem() {
        return driver.findElement(By.xpath(NEEDED_ITEM));
    }
    public WebElement getNeededItemBig() {
        return driver.findElement(By.xpath(NEEDED_ITEM_BIG));
    }


    public void SelectPopularItems() {
        getSortView().click();
        getPopularItems().click();
    }

    public void SelectSortExpensiveItems() {
        getSortView().click();
        getSortExpensive().click();
    }

    public void SelectMarkFilter() throws InterruptedException {
        getAsusFilter().click();
        Thread.sleep(1000);
        getMeizuFilter().click();
        Thread.sleep(1000);
        getLenovoFilter().click();
        Thread.sleep(1000);
        getPrestigioFilter().click();
        Thread.sleep(1000);
        getXiaomiFilter().click();
    }

    public void SelectDiagonalMoreThanFour() {
        getDiagonalMoreThanFour().click();
    }

    public void EnterMaxPrice(String maxprice) {
        getMaxPriceFieldFilter().sendKeys(maxprice);
    }

    public void SelectMaxPrice() {
        getPriceButtonFilter().click();
    }

    public ItemPage ClickNeededItem() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getNeededItem());
        actions.perform();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(getNeededItemBig())).click();
        return new ItemPage(driver);
    }
}