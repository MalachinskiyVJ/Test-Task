import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Вова on 15.03.2017.
 */
public class ShopTesting {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.firefox.marionette", ("user.dir") + "\\geckodriver.exe");
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.ie.driver", "D:\\Git\\Task\\IEDriverServer.exe");
        //driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua");

    }

    @Test
    public void test1() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        mainPage.ClickTheSmartphonesTV();
        mainPage.SmartphonesClick();

        if (smartphonesPage.getBaner().isDisplayed()) {
            smartphonesPage.getBanerClose().click();
        }

        if (smartphonesPage.getLepricon().isDisplayed()) {
            smartphonesPage.getLepriconClose().click();
        }

        smartphonesPage.SelectPopularItems();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)", "");
        smartphonesPage.SelectMarkFilter();
        js.executeScript("window.scrollBy(0,400)", "");
        smartphonesPage.SelectDiagonalMoreThanFour();
        Thread.sleep(5000);//такие ожидания расставлены только для удбства слежения за действиями работы скрипта
        js.executeScript("window.scrollBy(0,2000)", "");
        smartphonesPage.EnterMaxPrice("6000");
        smartphonesPage.SelectMaxPrice();
        Thread.sleep(5000);

        Assert.assertTrue(smartphonesPage.getSmartphonesResult().size()>1);
        js.executeScript("window.scrollBy(0,-2600)", "");
        Thread.sleep(5000);
        smartphonesPage.SelectSortExpensiveItems();
        smartphonesPage.ClickNeededItem();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}

