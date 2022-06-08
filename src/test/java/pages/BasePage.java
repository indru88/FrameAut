package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofMinutes(10));
    }
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(10));
    }
    public static void navigateTo(String url){
        driver.get(url);
    }
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void clickElement(String locator){
        Find(locator).click();
    }
    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }
    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }
    public void selectFromDropdownByIndex(String locator, int value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(value);
    }
    public void selectFromDropdownByText(String locator, String value){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(value);
    }
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }
    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }
    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }
    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }
    public void switchToiFrame(int iFrameID){
        driver.switchTo().frame(iFrameID);
    }
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String textFromElement(String locator){
        return Find(locator).getText();
    }
    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

}
