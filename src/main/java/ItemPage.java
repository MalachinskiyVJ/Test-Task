import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ItemPage {
    private static final String CONTAINR_PAGE = ".//*[@id='head_banner_container']";

    private WebDriver driver;
    public ItemPage(WebDriver driver) {
        this.driver=driver;
    }
    public WebElement getContainerPage() {
        return driver.findElement(By.xpath(CONTAINR_PAGE));
    }
    public void WaitForPage() {
        //getDiagonalMoreThanFour().click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(getContainerPage())).click();
    }
}
