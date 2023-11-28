package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.PropertyReader;

public class Test extends BaseSteps{

    HomePage homepage;

    @Given("Gehen Sie auf die Amazon-Startseite")
    public void gehenSieAufDieAmazonStartseite() {
        homepage = new HomePage();
        driver.navigate().to(PropertyReader.read("Config").get("url"));
    }

    @When("Klicken Sie auf die Bestseller Link am oberen Rand der Seite")
    public void klickenSieAufDeLinkAmOberenRandDerSeite() {
        click(homepage.topMenuBestsellerLink);
    }

    @Then("Nach der Klick sollte die Suchleiste am oberen Rand der Seite angezeigt werden")
    public void nachDerKlickSollteDieSuchleisteAmOberenRandDerSeiteAngezeigtWerden() {
        waitForVisibility(homepage.searchBox);
    }
}
