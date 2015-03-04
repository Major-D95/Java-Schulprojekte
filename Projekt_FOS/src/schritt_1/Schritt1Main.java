package schritt_1;

import java.io.File;
import java.util.Scanner;

/*Schritt 1: Schreiben Sie eine Java Methode, welche in der Lage ist eine beliebige 
 * Verzeichnisstruktur eines Datentr�gers auszulesen. Entwickeln Sie eine weitere Methode, 
 * die nur Dateien mit bestimmten Dateiendungen zur�ckgibt (z.B. nur .txt).
 */


public class Schritt1Main
{
	//Scanner Deklaration
	private static Scanner eingabe;

	//Methode, die als Parameter ein Verzeichnis erwartet und dann auslie�t.
	public static void verzeichnisAuslesen(String verzeichnis)
	{
		
		try //Try/Catch f�r die Pfadeingabe per Scanner
		{
			File f = new File(verzeichnis); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			File[] fileArray = f.listFiles(); //Methode die ein File Array mit Ordnern und Dateien zur�ckgibt
			
			if(fileArray!=null) //Pr�ft ob Inhalt im Array ist
			{		
				boolean noFile = true; //boolean, dass false gesetzt wird, wenn eine Datei erkannt wird

				for(int i=0;i<fileArray.length;i++) //Schleife, die alle Dateien im aktuellen Verzeichnis ausgibt
				{
					
					
					if(fileArray[i].isFile()) //Pr�ft ob es eine Datei
					{
						noFile=false; //Wird false gesetzt da es eine Datei gibt
						System.out.println("---"+fileArray[i].getName()); //Gibt Dateiname aus
						
					}

				}
				
				if(noFile) //Ausgabe, wenn keine Datei im Ordner ist
				{
					System.out.println("-Leer-");
				}
					
				
			for(int i=0;i<fileArray.length;i++) //Schleife, die die Ordner ausgibt
			{
			
				if(fileArray[i].isDirectory()) //Pr�ft ob Array an der Stelle ein Ordner ist.
				{
					//Wenn ja, Pfad wir ausgeben
					System.out.println(fileArray[i].getPath());

				 //Und Methode ruft sich, mit dem aktuellen Verzeichnis als Parameter, rekursiv auf.
					verzeichnisAuslesen(String.valueOf(fileArray[i]));
			
				}
		
			}
			
			}
		}
		
		catch(NullPointerException a) //Exception bei falscher Eingabe
		{
			System.out.println("Bitte einen korrekten Dateipfad angeben ! Beispiel: C:/... "); 
			verzeichnisAuslesen(verzeichnisEingabe()); //Ruft Methode erneuert auf
		}
		
	}
	
	
	
	//�berladene Methode, die zus�tzlich eine Dateiendung erwartet und dann nur Dateien dieses Typs ausgibt
	public static void verzeichnisAuslesen(String verzeichnis,String Endung)
	{
		
		try //Try/Catch f�r die Pfadeingabe per Scanner
		{
			File f = new File(verzeichnis); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			File[] fileArray = f.listFiles(); //Methode die ein File Array mit Ordnern und Dateien zur�ckgibt 
			
			if(fileArray!=null) //Pr�ft ob Inhalt im Array ist
			{		
				boolean noFile = true; //boolean, dass false gesetzt wird, wenn eine Datei erkannt wird

				for(int i=0;i<fileArray.length;i++) //Schleife, die alle Dateien mit einer bestimmten Dateiendung im aktuellen Verzeichnis ausgibt
				{
					
					
					if((fileArray[i].isFile())&&(fileArray[i].getName().endsWith(Endung))) //Pr�ft ob es eine Datei ist und es der Dateityp ist
					{
						noFile=false; //Wird false gesetzt da es eine Datei gibt
						System.out.println("---"+fileArray[i].getName()); //Gibt Dateiname aus
						
					}

				}
				if(noFile) //Ausgabe, wenn keine Datei im Ordner ist
				{
					System.out.println("-Leer-");
				}
					
				
			for(int i=0;i<fileArray.length;i++) //Schleife, die alle Ordner rekursiv aufruft.
			{
			
				if(fileArray[i].isDirectory()) //Pr�ft ob Array an der Stelle ein Ordner ist.
				{
					//Wenn ja, Pfad wir ausgeben
					System.out.println(fileArray[i].getPath());

				 //Und Methode ruft sich, mit dem aktuellen Verzeichnis als Parameter, rekursiv auf.
					verzeichnisAuslesen(String.valueOf(fileArray[i]),Endung);
			
				}
		
			}
			
			}
		}
		catch(NullPointerException a) //Exception bei falscher Eingabe oder fehlender Datei
		{
			System.out.println("Bitte einen korrekten Dateipfad angeben ! Beispiel: C:/... "); 
		}
		
	}
	
	
	
	//Methode, die ein Verzeichnis mithilfe einen Scanners eingeben l�sst und dann zur�ckgibt.
	public static String verzeichnisEingabe()
	{
		eingabe = new Scanner(System.in); //Scanner wird instanziert
		
		System.out.print("Bitte geben Sie ein Verzeichnis ein: ");

		return eingabe.next(); //Eingebenes Verzeichnis wird zur�ckgegeben
	}
	

	
	public static void main(String[] args)
	{
	
			verzeichnisAuslesen("C:/TestVerzeichnis"); //F�r Verzeichniseingabe per Konsole verzeichnisEingabe als Parameter �bergeben
	
	}

}
