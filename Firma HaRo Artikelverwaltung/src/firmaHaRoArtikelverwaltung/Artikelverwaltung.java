package firmaHaRoArtikelverwaltung;


import java.util.ArrayList;
import java.util.Scanner;



public class Artikelverwaltung
{
	static Scanner eingabe = new Scanner(System.in);
	//Methode die, die den Mehrwertsteuerprozentsatz festlegt
	//Ohne Methodenauruf bei Start sind Standartwerte gesetzt
	public static void Mehrwertsteuerabfrage()
	{
		 //????
		System.out.print("Bitte geben Sie die aktuelle Mehrwertsteuer in Prozent ein: ");
		Verkaufsware.setMehrwertsteuer(eingabe.nextDouble()/100);
		System.out.println();
		System.out.print("Bitte geben Sie die aktuelle verminderte Mehrwersteuer in Prozent ein: ");
		Verkaufsware.setVerminderteMehwertsteuer(eingabe.nextDouble()/100);
		System.out.println();
		
		
	}
	
	public static void main(String[] args)
	{
		

		Mehrwertsteuerabfrage();

	
		
		ArrayList<Artikel> ArtikelArrayList = new ArrayList<Artikel>(); //ArrayList als Datenstruktur
		
		for(int i=0;i<1;i++)
		{
			ArtikelArrayList.add(new Erzeugnisse());
		}
		
		for(int i=0;i<ArtikelArrayList.size();i++)
		{
			ArtikelArrayList.get(i).print();
		}	
		
		ArtikelArrayList.get(1).setArtikelnummer(23);		
		
		System.out.println(ArtikelArrayList.get(1).getArtikelnummer());
		Verkaufsware.printMehrwertsteuerkosten(); //Ausgabe der Mehrwertsteuerkosten
		
	}

}
