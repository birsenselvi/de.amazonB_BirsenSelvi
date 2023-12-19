package stepdefs;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import utils.PropertyReader;
import utils.Utilities;

public class BaseSteps {

    public WebDriver driver;
    public WebDriverWait wait;
    public Cookie cookie;


    {
        driver = Driver.getDriver();
        wait = Driver.getWait();
        cookie = new Cookie("accept", "all");
    }
    public void goToHome(){

        driver.navigate().to(PropertyReader.read("Config").get("url"));
        try{
            driver.manage().addCookie(cookie);
            driver.navigate().refresh();
        }catch(Exception e){
            try {
                driver.manage().addCookie(cookie);
                driver.navigate().refresh();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }



    }

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }


    public void click(WebElement element){
        wait.until(driver1 -> {
            try {
                element.click();
                return true;
            }catch (Exception e1){
                try {
                    new Actions(driver1).moveToElement(element).click().perform();
                    return true;
                }catch (Exception e2){
                    try {
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].click()", element);
                        return true;
                    }catch (Exception e3){
                        return false;
                    }
                }
            }
        });

    }

    public void sendKeys(By locator, String text){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, String text){
        wait.until(driver1 -> {
            try {
                element.clear();
                element.sendKeys(text);
                return true;
            }catch (Exception e1){
                try {
                    element.clear();
                    new Actions(driver1).moveToElement(element).sendKeys(text).perform();
                    return true;
                }catch (Exception e2){
                    try {
                        element.clear();
                        ((JavascriptExecutor) driver1).executeScript("arguments[0].value='" + text + "'", element);
                        return true;
                    }catch (Exception e3){
                        return false;
                    }
                }
            }
        });
    }

    public void hoverOverByAction(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .pause(500)
                .build()
                .perform();
    }

    public void hoverOverByAction(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        hoverOverByAction(element);
    }

    public void scrollToElement (WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToElement (By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollToElement(element);
    }

    //Bu metod String seklinde yazilmis bir locatorun %s kismindaki textini degistirip
    // xpath olarak geri döndürür.
    public By xpath(String locator, String... text) {

        return By.xpath(String.format(locator, text));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By locator) {
        Utilities.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForInvisibility(WebElement element) {
        Utilities.sleep(1000);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForInvisibility(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void checkDropProduktVisible(String text, By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        long num = driver.findElements(locator).stream()
                .filter(e->!e.getText().toLowerCase().startsWith(text)).count();
        Assert.assertEquals(num, 0);

    }


    
}
