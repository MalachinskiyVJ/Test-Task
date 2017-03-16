import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage {
    private static final String CATALOG_SMARTPHONES_TV = ".//*[@id='3361']";
    private static final String CATALOG_SMARTPHONES = ".//*[@id='3361']/div[1]/div[2]/div/ul[1]/li[1]/ul/li[1]/a";

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getCatalogSmartphonesTV() {
        return driver.findElement(By.xpath(CATALOG_SMARTPHONES_TV));
    }

    public WebElement getCatalogSmartphones() {
        return driver.findElement(By.xpath(CATALOG_SMARTPHONES));
    }

    public void ClickTheSmartphonesTV() {
        Actions actions = new Actions(driver);
        actions.doubleClick(getCatalogSmartphonesTV());
        actions.perform();
        //getCatalogSmartphonesTV().click();
    }

    public SmartphonesPage SmartphonesClick() {
        getCatalogSmartphones().click();
        return new SmartphonesPage(driver);
    }
}