package firmaHaRoArtikelverwaltung;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.11.2014
  * @author 
  */

public class Rohstoffe extends Artikel {
  
  // Anfang Attribute
  private double einkaufspreis;
  // Ende Attribute
  
  //Anfang Konstruktor
  public Rohstoffe()
  {
	  super();
	  
	  System.out.print("Bitte geben Sie den Einkaufspreis des Artikels ein: ");
	  einkaufspreis=eingabe.nextDouble();
	  System.out.println();
	  System.out.println("---Ende der Artikeleingabe Nr."+getArtikelzähler()+"---");
	  System.out.println();
  }
  
  //Anfang Setter/Getter Methoden
  public double getEinkaufspreis() {
    return einkaufspreis;
  }

  public void setEinkaufspreis(double einkaufspreis) {
    this.einkaufspreis = einkaufspreis;
  }
  
  //Ende Setter/Getter Methoden
  
//Methode, die alle Attribute ausgibt
  public void print()
  {
	  super.print();
	  System.out.println("Einkaufspreis: "+einkaufspreis);
	  System.out.println("Ende der Artikelausgabe");
	  System.out.println();

  }
  // Ende Methoden
} // end of Rohstoffe
