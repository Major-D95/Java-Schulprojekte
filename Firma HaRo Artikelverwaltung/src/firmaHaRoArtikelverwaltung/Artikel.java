package firmaHaRoArtikelverwaltung;

import java.util.Scanner;

abstract class Artikel {
  
  //Anfang Attribute
  private double artikelnummer;
  private String bezeichnung;
  private double lagerbestand;
  private static int Artikelzähler=0;
  //Ende Attribute
  
  //Scannerklasse
  protected static Scanner eingabe = new Scanner(System.in);
  //Ende Scanner
  
  //Anfang Konstruktor
  public Artikel()
  {
	  Artikelzähler++;
	  System.out.println("Artikeleingabe Nr."+Artikelzähler+" gestartet");
	  System.out.println();
	  System.out.print("Bitte geben Sie die Bezeichnung des Artikels ein: ");
	  bezeichnung=eingabe.next();
	  System.out.println();
	  System.out.print("Bitte geben Sie die Artikelnummer des Artikels ein: ");
	  artikelnummer=eingabe.nextDouble();
	  System.out.println();
	  System.out.print("Bitte geben Sie den Lagerbestand des Artikels ein: ");
	  lagerbestand=eingabe.nextDouble();
	  System.out.println();
	  
	  
  }
  //Ende Konstruktor
  
  //Anfang Methoden
  //Anfang Setter/Getter Methoden
  public double getArtikelnummer() {
    return artikelnummer;
  }

  public void setArtikelnummer(double artikelnummer) {
    this.artikelnummer = artikelnummer;
  }

  public String getBezeichnung() {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) {
    this.bezeichnung = bezeichnung;
  }

  public double getLagerbestand() {
    return lagerbestand;
  }
  
  public static int getArtikelzähler()
  {
	  return Artikelzähler;
  }

  // Ende Setter/Getter Methoden
  
  //Methode, die alle Attribute ausgibt
  public void print()
  {
	  System.out.println("Artikelausgabe gestartet");
	  System.out.println("Artikelbezeichnung: "+bezeichnung);
	  System.out.println("Artikelnummer: "+artikelnummer);
	  System.out.println("Lagerbestand: "+lagerbestand);
  }
  //Ende Methoden
  
} // end of Artikel
