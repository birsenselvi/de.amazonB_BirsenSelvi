package pageObjects;


import driver.Driver;
import io.cucumber.java.eo.Do;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import stepdefs.BaseSteps;
import utils.Utilities;

import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class ProduktPage {

    BaseSteps base = new BaseSteps();


    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".nav-search-scope.nav-sprite")
    public WebElement alle;
    @FindBy(css = ".nav-search-scope.nav-sprite span")
    public WebElement alleIn;
    @FindBy(css = ".s-suggestion-container")
    public List<WebElement>searchProdukts;

    @FindBy(xpath = "//li[@class='a-dropdown-item']")
    public List<WebElement>sortierenDropDown;

    @FindBy(xpath = "//div[@class='puisg-col-inner']//span[@class='a-price']")
    public List<WebElement> ausSteigendProduct;

    @FindBy(xpath = "//div[@class='puisg-col-inner']//h2")
    public List<WebElement> produktNameList;
    @FindBy(css = "div#centerCol div h1 span")
    public WebElement produktTitle;
    @FindBy(css="select option")
    public List<WebElement> optionsList;
    @FindBy(css=".a-dynamic-image-container")
    public WebElement productBild;
    @FindBy(css="#ivImagesTab #ivTitle")
    public WebElement productBildName;
    @FindBy(css=".a-spacing-small.item.imageThumbnail.a-declarative")
    public List<WebElement>produkctsBild;
    @FindBy(xpath = "(//span[@class='a-offscreen'])[1]")
    public WebElement produktPrice;
    @FindBy(xpath = "(//span[@id='acrCustomerReviewText'])[1]")
    public WebElement bewertung;
    @FindBy(xpath = "//li//span[@id='videoCount']")
    public WebElement produktVideo;
    @FindBy(xpath = "//span[@class='aok-offscreen'][1]")
    public WebElement pruducktToPrice;
    @FindBy(xpath = "//span[@class='a-price' ]//span[@class='a-offscreen']")
    public List<WebElement> produktPreisNeu;
    @FindBy(css= "#s-result-sort-select")
    public WebElement dropDownSortieren;
    String filtreOf1 = "//span[@class= 'a-color-state a-text-bold' and text()='%s'] ";
    String filtreOf2 = "//span[@class= 'a-size-base a-color-base puis-bold-weight-text' and text()='%s']";
    String filtreOf3 = "//span[@class= 'a-size-base a-color-base a-text-bold' and text()='%s']";

    String filtreOptionen = "//a[@class = 'a-link-normal s-navigation-item']//*[contains(.,'%s')]";
    public void getBewertung(){

            Assert.assertTrue(bewertung.getText().contains("bewertung"),"Ürün hakkinda bewertung bulunamadi...");

    }
    public void getVideoToProdukt(){

            Assert.assertTrue(produktVideo.getText().contains("VIDEO"));

    }
    public WebElement getSelectKatagorieStream(String text) {

        WebElement element = null;
        for (WebElement option : optionsList) {
            if (option.isDisplayed() & option.isEnabled()) {
             element  = optionsList.stream().filter(e -> e.getText().startsWith(text)).findFirst().get();
            }
        }
        return element;
    }
    public void priceElement1(){

            String text = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerText;", produktPrice);
            double price= parseDouble(text.replaceAll("[^0-9.,]", "").replace(",", "."));
            System.out.println(price);
            if(price == 0)
            System.out.println("Ürün fiyati yok");

    }
    public void getProdukt(){

        getProdukt(1);

    }
    public WebElement getProdukt(int index){
        String productName = "(//div[@class='puisg-col-inner']//h2//a)[" + index + "]";
        By locator = By.xpath(productName);
        base.scrollToElement(locator);
       return base.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void AssertToProductBild(){

        Assert.assertTrue(produkctsBild.size()>0);
        String title = productBildName.getText();
        System.out.println(title);

    }

    public void getProduktAssertToTitle(){
        String title = produktTitle.getText();
        System.out.println(title);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));

    }
    public void selectIsVisible(){
       Select select = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox")));
       List<String> selects = new ArrayList<>();
        for (WebElement allSelectedOption : select.getAllSelectedOptions()) {
            selects.add(allSelectedOption.getText());
        }
        Assert.assertFalse(selects.isEmpty());
    }
    public void selectIsInVisible(String text){
      Assert.assertEquals(alleIn.getText(), text);
    }
    public By getOfOptionenBold(String text){

        String xpath1 = String.format(filtreOf1, text);
        String xpath2 = String.format(filtreOf2, text);
        String xpath3 = String.format(filtreOf3, text);
        String xpath = xpath1 + " | " + xpath2 + " | " + xpath3;
        By lfilteOption = By.xpath(xpath);
        base.scrollToElement(lfilteOption);
        return lfilteOption;
    }
    public WebElement getFiltreOptionen(String text){
        String xpath = String.format(filtreOptionen, text);
        By locator = By.xpath(xpath);
        base.scrollToElement(locator);
        return Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public WebElement textIsVisiblee(String text){
       return textIsVisiblee(text,0);

    }
    public WebElement textIsVisiblee(String text, int index){
        String meldung = "(//div[@class='sg-col-inner']//span[contains(text(),'%s')])['"+index+"']";
        String xpath = String.format(meldung,text);
        By locator = By.xpath(xpath);
        base.scrollToElement(locator);
        return  Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public void sortierenDropDown(String text){
        Select select = new Select(dropDownSortieren);
        List<WebElement> options = select.getOptions();
        String actualOptionText = null;
        List<String> expectedOptions = Arrays.asList(text);
        if (options.size() == expectedOptions.size()) {

            for (int i = 0; i < options.size(); i++) {
                actualOptionText = options.get(i).getText().trim();
            }
            Assert.assertEquals(expectedOptions,actualOptionText,"DropDown 5 option icermiyor");

        }

        }

    public void getAufsteigendProduct2() {

        List<Double> prices = new ArrayList<>();
        for (WebElement element : produktPreisNeu) {
            String text = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].innerText;", element);
            double price = Double.parseDouble(text.replaceAll("[^0-9,]", "").replace(",", "."));

            if(!prices.contains(price)){
                prices.add(price);
                }


        }
        System.out.println(prices);

        List<Double>pricesActual=new ArrayList<>(prices);
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
            if(!prices.contains(price)) {
                prices.add(price);
            }
        }
        System.out.println(prices);

        List<Double>pricesActual=new ArrayList<>(prices);
        pricesActual.sort(Comparator.reverseOrder());
        System.out.println(pricesActual);
        Assert.assertEquals(prices,pricesActual,"Liste fiyat azalisina göre siralanmamis");

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


