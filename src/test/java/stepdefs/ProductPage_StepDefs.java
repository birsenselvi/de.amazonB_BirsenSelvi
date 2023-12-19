package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

        produkt.selectIsVisible1();

    }

    @Then("ich klicke auf das DropDown die Katagorie Küche, Haushalt & Wohnen")
    public void ichKlickeAufDasDropDownDieKatagorieKücheHaushaltWohnen() {
       base.click(produkt.getSelectKatagorieStream("Küche"));

    }

    @And("ich sehe, dass den DropDown geschloßen wird")
    public void ichSeheDassDenDropDownGeschloßenWird() {

        produkt.selectIsInVisible();

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

       // base.waitForVisibility(produkt.textIsVisiblee("Staubsauger"));
          produkt.getProduktAssert("staubsauger");

    }

    @And("Ich sehe Marke Filteroption")
    public void ichSeheMarkeFilteroption() {

        base.waitForVisibility(produkt.getOfOptionenBold("Marke"));

    }
    @And("Ich sehe Preis Filteroption")
    public void ichSehePreisFilteroption() {

        base.waitForVisibility(produkt.getOfOptionenBold("Preis"));
    }
    @And("Ich sehe Verfügbarkeit Filteroption")
    public void ichSeheVerfügbarkeitFilteroption() {

        base.waitForVisibility(produkt.getOfOptionenBold("Verfügbarkeit"));
    }
    @And("Ich sehe weitere Filteroptionen")
    public void ichSeheWeitereFilteroptionen() {

        base.waitForVisibility(produkt.getOfOptionenBold("Staubsauger Art"));
    }


    @And("ich sehe, dass der Text Katagorie fetter wirddes Staubsaugers")
    public void ichSeheDassDerTextKatagorieFetterWirddesStaubsaugers() {

        base.waitForVisibility(produkt.getOfOptionenBold("Küche, Haushalt & Wohnen"));

    }

    @Then("ich klicke unten dem Marke Filtreoption auf Bosch Hausgeräte")
    public void ichKlickeUntenDemMarkeFiltreoptionAufBoschHausgeräte() {
        base.click(produkt.getFiltreOptionen("AEG"));
    }

    @And("ich sehe die Meldung Seitenzahl von Produktmenge Ergebnissen oder Vorschlägen für staubsauger")
    public void ichSeheDieMeldungVonErgebnissenOderVorschlägenFürStaubsauger() {

        base.waitForVisibility(produkt.textIsVisiblee("für"));

    }
    @And("ich sehe die Meldung staubsauger")
    public void ichSeheDieMeldungStaubsauger() {

        base.waitForVisibility(produkt.textIsVisiblee("staubsauger"));

    }

    @And("ich sehe, dass der Text Marke fetter wird")
    public void ichSeheDassDerTextMarkeFetterWird() {

        base.waitForVisibility(produkt.getOfOptionenBold("AEG"));
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
        base.waitForVisibility(produkt.getOfOptionenBold("AEG"));
        base.waitForVisibility(produkt.getOfOptionenBold("200 bis 500 EUR"));



    }

    @Then("ich klicke den DropDown Sortieren nach")
    public void ichKlickeDenDropDownSortierenNach() {

        base.click(produkt.textIsVisiblee("Sortieren nach:"));

    }
    @And("ich sehe, dass das Soritieren Dropdown erscheint")
    public void ichSeheDassDasSoritierenDropdownErscheint() {
        produkt.selectSoritierenIsVisible();
    }

    @And("ich sehe, dass das DropDown mit Preis: Aufsteigend erscheint")
    public void ichSeheDassDasDropDownMitPreisAufsteigendPreisspanneErscheint() {

        produkt.verifyDisplayd("Preis: Aufsteigend");

    }
    @And("ich sehe, dass das DropDown mit Preis: Absteigend erscheint")
    public void ichSeheDassDasDropDownMitPreisAbsteigendErscheint() {

       produkt.verifyDisplayd("Preis: Absteigend");

    }

    @Then("ich klicke das DropDown Preis: Aufsteigend Sortieroption")
    public void ichKlickeDasDropDownAufsteigendSortieroption() {

        base.click(produkt.getSortierenOption("Preis: Aufsteigend"));
    }

    @And("ich sehe, dass den Soritieren DropDown geschloßen wird")
    public void ichSeheDassDenSoritierenDropDownGeschloßenWird() {
        produkt.selectSoritierenIsInVisible();

    }
    @And("ich sehe die Liste der Produkte nach Preiserhöhung sortiert.")
    public void ichSeheDieListeDerProdukteNachPreiserhöhungSortiert() {

        Utilities.sleep(1000);
        produkt.getAufsteigendProduct();

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
       // Utilities.sleep(1000);
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
