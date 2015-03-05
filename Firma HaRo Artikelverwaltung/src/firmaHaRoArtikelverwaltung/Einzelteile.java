package firmaHaRoArtikelverwaltung;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.11.2014
  * @author 
  */

public class Einzelteile extends Artikel {
  
  // Anfang Attribute
  private double herstellungskosten;
  // Ende Attribute
  
  //Anfang Konstruktor
  public Einzelteile()
  {
	  super();
	  
	  System.out.print("Bitte geben Sie die Herstellungskosten des Artikels ein: ");
	  herstellungskosten=eingabe.nextDouble();
	  System.out.println();
	  System.out.println("---Ende der Artikeleingabe Nr."+getArtikelzähler()+"---");
	  System.out.println();
  }
  
  //Ende Konstruktor
  
  // Anfang Setter/Getter Methoden
  public double getHerstellungskosten() {
    return herstellungskosten;
  }

  public void setHerstellungskosten(double herstellungskosten) {
    this.herstellungskosten = herstellungskosten;
  }
  
  //Ende Setter/Getter Methoden
  
//Methode, die alle Attribute ausgibt
  public void print()
  {
	  super.print();
	  System.out.println("Herstellungskosten: "+herstellungskosten);
	  System.out.println("Ende der Artikelausgabe");
	  System.out.println();

  }
  //Ende Methoden
  
} // end of Einzelteile
