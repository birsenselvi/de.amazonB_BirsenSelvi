package pageObjects;


import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefs.BaseSteps;
import utils.PropertyReader;
import utils.Utilities;

import java.util.*;

import static java.lang.Double.parseDouble;

public class ProduktPage {

    BaseSteps base = new BaseSteps();


    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#nav-search-dropdown-card > div")
    public WebElement alle;
    @FindBy(xpath = "//select[@id='s-result-sort-select']")
    public WebElement soritieren;

    @FindBy(xpath = "//li[@class='a-dropdown-item']")
    public List<WebElement> sortierenDropDown;

    @FindBy(xpath = "//div[@class='puisg-col-inner']//h2//a//span")
    public List<WebElement> produktNameList;
    @FindBy(css = "div#centerCol div h1 span")
    public WebElement produktTitle;
    @FindBy(css = "select option")
    public List<WebElement> optionsList;
    @FindBy(css = "#ivImagesTab #ivTitle")
    public WebElement productBildName;
    @FindBy(css = ".a-spacing-small.item.imageThumbnail.a-declarative")
    public List<WebElement> produkctsBild;
    @FindBy(xpath = "(//span[@class='a-offscreen'])[1]")
    public WebElement produktPrice;
    @FindBy(xpath = "(//span[@id='acrCustomerReviewText'])[1]")
    public WebElement bewertung;
    @FindBy(xpath = "//li//span[@id='videoCount']")
    public WebElement produktVideo;
    @FindBy(xpath = "//span[@class='a-price' ]//span[@class='a-offscreen']")
    public List<WebElement> produktPreisNeu;
    @FindBy(css = "#s-result-sort-select")
    public WebElement dropDownSortieren;

    String filtreOf1 = "//span[@class= 'a-color-state a-text-bold' and text()='%s'] ";
    String filtreOf2 = "//span[@class= 'a-size-base a-color-base puis-bold-weight-text' and text()='%s']";
    String filtreOf3 = "//span[@class= 'a-size-base a-color-base a-text-bold' and text()='%s']";

    String filtreOptionen = "//a[@class = 'a-link-normal s-navigation-item']//*[contains(.,'%s')]";

    public void selectIsVisible1() {

            Driver.getWait().until(ExpectedConditions.attributeContains(alle,"class", "nav-focus" ));

    }
    public void selectSoritierenIsVisible() {

        Driver.getWait().until(ExpectedConditions.attributeToBe(soritieren,"aria-pressed", "true" ));

    }
    public WebElement getSortierenOption(String text){
     return  sortierenDropDown.stream().filter(e->e.getText().equals(text)).findFirst().get();

    }

    public void selectIsInVisible() {

        Driver.getWait().until(ExpectedConditions.attributeToBe(alle, "class", "nav-search-scope nav-sprite"));

    }
    public void selectSoritierenIsInVisible() {

        Driver.getWait().until(ExpectedConditions.attributeToBe(soritieren, "aria-pressed","false"));

    }

    public void getBewertung() {

        Assert.assertTrue(bewertung.getText().contains("bewertung"), "Ürün hakkinda bewertung bulunamadi...");

    }

    public void getVideoToProdukt() {

        Assert.assertTrue(produktVideo.getText().contains("VIDEO"));

    }

    public WebElement getSelectKatagorieStream(String text) {

        return optionsList.stream().filter(e -> e.getText().startsWith(text)).findFirst().get();

    }
    public void getProduktAssert(String text) {

        List<String> list = new ArrayList<>();
        for (WebElement webElement : produktNameList) {

            if(webElement.getText().toLowerCase().contains(text))
            list.add(webElement.getText());

        }
       // Assert.assertEquals(produktNameList.size(), list.size());
        Assert.assertFalse(list.isEmpty());

    }
    public void priceElement1() {

        String text = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerText;", produktPrice);
        double price = parseDouble(text.replaceAll("[^0-9.,]", "").replace(",", "."));
        System.out.println(price);
        if (price == 0)
            System.out.println("Ürün fiyati yok");
    }

    public void getProdukt() {

        getProdukt(1);

    }

    public WebElement getProdukt(int index) {
        String productName = "(//div[@class='puisg-col-inner']//h2//a)[" + index + "]";
        By locator = By.xpath(productName);
        base.scrollToElement(locator);
        return base.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void AssertToProductBild() {

        Assert.assertTrue(produkctsBild.size() > 0);
        String title = productBildName.getText();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    public void getProduktAssertToTitle() {
        String title = produktTitle.getText();
        System.out.println(title);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
        System.out.println(Driver.getDriver().getTitle());
    }


    public By getOfOptionenBold(String text) {

        String xpath1 = String.format(filtreOf1, text);
        String xpath2 = String.format(filtreOf2, text);
        String xpath3 = String.format(filtreOf3, text);
        String xpath = xpath1 + " | " + xpath2 + " | " + xpath3;

        By lfilteOption = By.xpath(xpath);
        base.scrollToElement(lfilteOption);
        return lfilteOption;
    }

    public WebElement getFiltreOptionen(String text) {

        String xpath = String.format(filtreOptionen, text);
        By locator = By.xpath(xpath);
        base.scrollToElement(locator);
        return Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement textIsVisiblee(String text) {
        return textIsVisiblee(text, 0);

    }

    public WebElement textIsVisiblee(String text, int index) {
        String meldung = "(//div[@class='sg-col-inner']//span[contains(text(),'%s')])['" + index + "']";
        String xpath = String.format(meldung, text);
        By locator = By.xpath(xpath);
        base.scrollToElement(locator);
        return Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void verifyDisplayd(String text) {
        Select select = new Select(dropDownSortieren);
        select.selectByVisibleText(text);

    }

    public void getAufsteigendProduct() {

        List<Double> prices = new ArrayList<>();

        for (WebElement element : produktPreisNeu) {
            String text = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerText;", element);
            double price = Double.parseDouble(text.replaceAll("[^0-9,]", "").replace(",", "."));

             // TODO

             if (!prices.contains(price)) {
                prices.add(price);
            }
        }

        System.out.println(prices);

        List<Double> pricesActual = new ArrayList<>(prices);
        Collections.sort(pricesActual);
        System.out.println(pricesActual);

        Assert.assertEquals(prices, pricesActual, "Liste fiyat artisina göre siralanmamis");

        /**
         *
         *  for (int i = 0; i < element.size()-1; i++) {
         *
         *                 if (element.get(i) < element.get(i+1)) {
         *
         *                 }
         *             }
         *
         */

    }

    public void getAbsteigendProduct() {

        List<Double> prices = new ArrayList<>();
        for (WebElement element : produktPreisNeu) {
            String text = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerText;", element);
            double price = Double.parseDouble(text.replaceAll("[^0-9,]", "").replace(",", "."));
            if (!prices.contains(price)) {
                prices.add(price);
            }
        }
        System.out.println(prices);

        List<Double> pricesActual = new ArrayList<>(prices);
        pricesActual.sort(Comparator.reverseOrder());
        System.out.println(pricesActual);
        Assert.assertEquals(prices, pricesActual, "Liste fiyat azalisina göre siralanmamis");

        /**
         *
         *  for (int i = 0; i < element.size()-1; i++) {
         *
         *                 if (element.get(i) < element.get(i+1)) {
         *
         *                 }
         *             }
         *
         */
    }


}


