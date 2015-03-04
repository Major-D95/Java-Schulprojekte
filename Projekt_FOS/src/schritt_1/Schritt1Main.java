package schritt_1;

import java.io.File;
import java.util.Scanner;

/*Schritt 1: Schreiben Sie eine Java Methode, welche in der Lage ist eine beliebige 
 * Verzeichnisstruktur eines Datenträgers auszulesen. Entwickeln Sie eine weitere Methode, 
 * die nur Dateien mit bestimmten Dateiendungen zurückgibt (z.B. nur .txt).
 */


public class Schritt1Main
{
	//Scanner Deklaration
	private static Scanner eingabe;

	//Methode, die als Parameter ein Verzeichnis erwartet und dann ausließt.
	public static void verzeichnisAuslesen(String verzeichnis)
	{
		
		try //Try/Catch für die Pfadeingabe per Scanner
		{
			File f = new File(verzeichnis); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			File[] fileArray = f.listFiles(); //Methode die ein File Array mit Ordnern und Dateien zurückgibt
			
			if(fileArray!=null) //Prüft ob Inhalt im Array ist
			{		
				boolean noFile = true; //boolean, dass false gesetzt wird, wenn eine Datei erkannt wird

				for(int i=0;i<fileArray.length;i++) //Schleife, die alle Dateien im aktuellen Verzeichnis ausgibt
				{
					
					
					if(fileArray[i].isFile()) //Prüft ob es eine Datei
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
			
				if(fileArray[i].isDirectory()) //Prüft ob Array an der Stelle ein Ordner ist.
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
	
	
	
	//Überladene Methode, die zusätzlich eine Dateiendung erwartet und dann nur Dateien dieses Typs ausgibt
	public static void verzeichnisAuslesen(String verzeichnis,String Endung)
	{
		
		try //Try/Catch für die Pfadeingabe per Scanner
		{
			File f = new File(verzeichnis); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			File[] fileArray = f.listFiles(); //Methode die ein File Array mit Ordnern und Dateien zurückgibt 
			
			if(fileArray!=null) //Prüft ob Inhalt im Array ist
			{		
				boolean noFile = true; //boolean, dass false gesetzt wird, wenn eine Datei erkannt wird

				for(int i=0;i<fileArray.length;i++) //Schleife, die alle Dateien mit einer bestimmten Dateiendung im aktuellen Verzeichnis ausgibt
				{
					
					
					if((fileArray[i].isFile())&&(fileArray[i].getName().endsWith(Endung))) //Prüft ob es eine Datei ist und es der Dateityp ist
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
			
				if(fileArray[i].isDirectory()) //Prüft ob Array an der Stelle ein Ordner ist.
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
	
	
	
	//Methode, die ein Verzeichnis mithilfe einen Scanners eingeben lässt und dann zurückgibt.
	public static String verzeichnisEingabe()
	{
		eingabe = new Scanner(System.in); //Scanner wird instanziert
		
		System.out.print("Bitte geben Sie ein Verzeichnis ein: ");

		return eingabe.next(); //Eingebenes Verzeichnis wird zurückgegeben
	}
	

	
	public static void main(String[] args)
	{
	
			verzeichnisAuslesen("C:/TestVerzeichnis"); //Für Verzeichniseingabe per Konsole verzeichnisEingabe als Parameter übergeben
	
	}

}
