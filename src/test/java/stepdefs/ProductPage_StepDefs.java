package stepdefs;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.ProduktPage;
import utils.Utilities;

public class ProductPage_StepDefs {
    BaseSteps base = new BaseSteps();
    HomePage home = new HomePage();
    ProduktPage produkt = new ProduktPage();

    @Given("ich gehe auf die Amazon-Startseite")
    public void ichGeheAufDieAmazonStartseite() {

      base.goToHome();
    }
    @When("ich sehe title Amazon.de")
    public void ichSeheTitleAmazonDe() {

        base.waitForVisibility(home.logo);
        base.click(home.cookies);

    }

    @Then("ich klicke das DropDown Alle")
    public void ichKlickeDasDropDownAlle() {

        base.click(produkt.alle);

    }

    @And("ich sehe, dass das Dropdown erscheint")
    public void ichSeheDassDasDropdownErscheint() {

        produkt.selectIsVisible();

    }

    @Then("ich klicke auf das DropDown die Katagorie Küche, Haushalt & Wohnen")
    public void ichKlickeAufDasDropDownDieKatagorieKücheHaushaltWohnen() {

       base.click(produkt.getSelectKatagorieStream("Küche, Haushalt & Wohnen"));

    }

    @And("ich sehe, dass den DropDown geschloßen wird")
    public void ichSeheDassDenDropDownGeschloßenWird() {

        produkt.selectIsInVisible("Küche, Haushalt & Wohnen");

    }

    @And("ich schreibe das gewünschte Produkt Staubsauger im Suchfeld ein")
    public void ichSchreibeDasGewünschteProduktStaubsaugerImSuchfeldEin() {

        base.sendKeys(home.searchBox, "Staubsauger");

    }

    @Then("ich klicke die suchtaste")
    public void ichKlickeDieSuchtaste() {
        base.click(home.suchTaste);
    }

    @And("Ich sehe die Liste der eingeschränkten Staubsauger")
    public void ichSeheDieListeDerEingeschränktenStaubsauger() {

        base.waitForVisibility(produkt.textIsVisiblee("Staubsauger"));

    }

    @And("Ich sehe Marke, Preis, Staubsauger Art, Verfügbarkeit und weitere Filteroptionen")
    public void ichSeheMarkePreisStaubsaugerArtVerfügbarkeitUndWeitereFilteroptionen() {

        base.waitForVisibility(produkt.getOfOptionenBold("Marke"));
        base.waitForVisibility(produkt.getOfOptionenBold("Preis"));
        base.waitForVisibility(produkt.getOfOptionenBold("Verfügbarkeit"));
        base.waitForVisibility(produkt.getOfOptionenBold("Staubsauger Art"));

    }

    @And("ich sehe, dass der Text Katagorie fetter wirddes Staubsaugers")
    public void ichSeheDassDerTextKatagorieFetterWirddesStaubsaugers() {

        base.waitForVisibility(produkt.getOfOptionenBold("Küche, Haushalt & Wohnen"));

    }

    @Then("ich klicke unten dem Marke Filtreoption auf Bosch Hausgeräte")
    public void ichKlickeUntenDemMarkeFiltreoptionAufBoschHausgeräte() {
        base.click(produkt.getFiltreOptionen("Rowenta"));
    }

    @And("ich sehe die Meldung Seitenzahl von Produktmenge Ergebnissen oder Vorschlägen für staubsauger")
    public void ichSeheDieMeldungVonErgebnissenOderVorschlägenFürStaubsauger() {

        base.waitForVisibility(produkt.textIsVisiblee("für"));


    }

    @And("ich sehe, dass der Text Marke fetter wird")
    public void ichSeheDassDerTextMarkeFetterWird() {

        base.waitForVisibility(produkt.getOfOptionenBold("Rowenta"));
    }

    @Then("ich klicke unten dem Preis Filtreoption auf 200 bis 500 Euro")
    public void ichKlickeUntenDemPreisFiltreoptionAufBisEuro() {

        base.click(produkt.getFiltreOptionen("200 bis 500 EUR"));

    }

    @And("ich sehe, dass der Text ikiyüz bis besyüz Euro fetter wird")
    public void ichSeheDassDerTextBisEuroFetterWird() {

        base.waitForVisibility(produkt.getOfOptionenBold("200 bis 500 EUR"));

    }

    @And("Ich sehe, dass die Texte der ausgewählten Filteroptionen miteinander Küche, Haushalt & Wohnen, Bosch Hausgeräte und 200 bis 500 Euro fetter wird.")
    public void ichSeheDassDieTexteDerAusgewähltenFilteroptionenMiteinanderKücheHaushaltWohnenBoschHausgeräteund200bis500EuroFetterWird() {

        base.waitForVisibility(produkt.getOfOptionenBold("Küche, Haushalt & Wohnen"));
        base.waitForVisibility(produkt.getOfOptionenBold("Rowenta"));
        base.waitForVisibility(produkt.getOfOptionenBold("200 bis 500 EUR"));



    }

    @Then("ich klicke den DropDown Sortieren nach")
    public void ichKlickeDenDropDownSortierenNach() {

        base.click(produkt.textIsVisiblee("Sortieren nach:"));

    }

    @And("ich sehe, dass das DropDown mit fünf optionen \\(Empfohlen, Preis: Aufsteigend, Preis: Absteigend, Durchschn. Kundenbewertung und Neuheiten) erscheint")
    public void ichSeheDassDasDropDownMitfünfOptionenEmpfohlenPreisspanneKundenbewertungVerfügbarkeitUndNeuheitenErscheint() {

        produkt.sortierenDropDown("Empfohlen, Preis: Aufsteigend, Preis: Absteigend, Durchschn. Kundenbewertung Neuheiten");

    }

    @Then("ich klicke das DropDown Preis: Aufsteigend Sortieroption")
    public void ichKlickeDasDropDownAufsteigendSortieroption() {

        base.click(produkt.sortierenDropDown.get(2));
    }

    @And("ich sehe die Liste der Produkte nach Preiserhöhung sortiert.")
    public void ichSeheDieListeDerProdukteNachPreiserhöhungSortiert() {

       Utilities.sleep(2000);
        produkt.getAbsteigendProduct();

    }

    @Then("ich klicke auf das zweite Produkt")
    public void ichKlickeAufDasZweiteProdukt() {

        base.click(produkt.getProdukt(10));
        
    }
    @And("ich sehe die ausgewählte Produktseite")
    public void ichSeheDieAusgewählteProduktseite() {

        produkt.getProduktAssertToTitle();

    }
    @And("ich sehe Produckt bild")
    public void ichSeheProducktBild() {

        produkt.AssertToProductBild();

    }
    @And("ich sehe Produktname")
    public void ichSeheProduktname() {

        produkt.getProduktAssertToTitle();
    }
    @And("ich sehe Preis")
    public void ichSehePreis() {
        Utilities.sleep(1000);
        produkt.priceElement1();
    }
    @And("ich sehe Kundenbewertung")
    public void ichSeheKundenbewertung() {
        produkt.getBewertung();

    }
    @And("ich sehe eine kurze Produktvorschau")
    public void ichSeheEineKurzeProduktvorschau() {

        produkt.getVideoToProdukt();

    }
}
