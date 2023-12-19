Feature: Verbesserte Suchgenauigkeit

  Scenario: Verbesserte Suchgenauigkeit mit  Filteroptionen und Sortieroptionen

    Given ich gehe auf die Amazon-Startseite
    When ich sehe title Amazon.de
    Then ich klicke das DropDown Alle
    And ich sehe, dass das Dropdown erscheint
    Then ich klicke auf das DropDown die Katagorie Küche, Haushalt & Wohnen
    And ich sehe, dass den DropDown geschloßen wird
    * ich schreibe das gewünschte Produkt Staubsauger im Suchfeld ein
    Then ich klicke die suchtaste
    And Ich sehe die Liste der eingeschränkten Staubsauger
    * Ich sehe Marke Filteroption
    * Ich sehe Preis Filteroption
    * Ich sehe Verfügbarkeit Filteroption
    * Ich sehe weitere Filteroptionen
    * ich sehe, dass der Text Katagorie fetter wirddes Staubsaugers
    Then ich klicke unten dem Marke Filtreoption auf Bosch Hausgeräte
    And ich sehe die Meldung Seitenzahl von Produktmenge Ergebnissen oder Vorschlägen für staubsauger
    And ich sehe die Meldung staubsauger
    * ich sehe, dass der Text Marke fetter wird
    Then ich klicke unten dem Preis Filtreoption auf 200 bis 500 Euro
    And ich sehe, dass der Text ikiyüz bis besyüz Euro fetter wird
    * ich sehe die Meldung Seitenzahl von Produktmenge Ergebnissen oder Vorschlägen für staubsauger
    * Ich sehe, dass die Texte der ausgewählten Filteroptionen miteinander Küche, Haushalt & Wohnen, Bosch Hausgeräte und 200 bis 500 Euro fetter wird.
    Then ich klicke den DropDown Sortieren nach
    And ich sehe, dass das Soritieren Dropdown erscheint
    * ich sehe, dass das DropDown mit Preis: Aufsteigend erscheint
    * ich sehe, dass das DropDown mit Preis: Absteigend erscheint
    Then ich klicke das DropDown Preis: Aufsteigend Sortieroption
    And ich sehe, dass den Soritieren DropDown geschloßen wird
    * ich sehe die Liste der Produkte nach Preiserhöhung sortiert.
    Then ich klicke auf das zweite Produkt
    And ich sehe die ausgewählte Produktseite
    * ich sehe Produckt bild
    * ich sehe Produktname
    * ich sehe Preis
    * ich sehe Kundenbewertung
    * ich sehe eine kurze Produktvorschau














