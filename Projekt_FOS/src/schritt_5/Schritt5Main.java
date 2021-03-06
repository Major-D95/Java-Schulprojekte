package schritt_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Schritt5Main
{
	
	//Lie�t alle Textdateien in einem Pfad aus und gibt sie an die untere Methode weiter um sie auszulesen
	public static void verzeichnisAusgabe(String verzeichnis,String text)
	{
		
			File f = new File(verzeichnis);
			File[] fileArray = f.listFiles();
			
			if(fileArray!=null) //Pr�ft ob Inhalt im Array ist
			{	
				if(fileArray.length!=0)
				{

					for(int i=0;i<fileArray.length;i++) //Schleife, die ein Array ausgibt, in der Pfade und Dateien gespeichert sind.
					{
						
						
						if((fileArray[i].isFile())&&(fileArray[i].getName().endsWith(".txt"))) //Pr�ft ob es eine Datei ist und es der Dateityp ist
						{
	
							System.out.println(fileArray[i].getPath()); //Gibt Pfad + Dateiname aus
							Dateiauslesen(fileArray[i].getPath(),text);
						}
	
					}
				
			
					
				
					for(int i=0;i<fileArray.length;i++) //Schleife, die ein Array ausgibt, in der Pfade und Dateien gespeichert sind.
					{
					
						if(fileArray[i].isDirectory()) //Pr�ft ob Array an der Stelle ein Ordner ist.
						{
		
		
							//Und Methode ruft sich, mit dem aktuellen Verzeichnis als Parameter, rekursiv auf.
							verzeichnisAusgabe(String.valueOf(fileArray[i]),text);
					
						}
				
					}
					
				}else //Wenn keine Dateien im Pfad vorhanden sind
				{
					System.out.println("Es sind keine Dateien im Pfad vorhanden");
				}
				
			}else //Wenn FileArray null ist
			{

				System.out.println("Bitte einen korrekten Dateipfad angeben ! Beispiel: C:/... ");
			}
			
		}
		
	//Sucht in einer Textdatei ein Suchwort und gibt es aus, wenn es gefunden wurde
	public static void Dateiauslesen(String pfad,String suchWort)
	{
	
		String txt = ""; //Darin wird Inhalt der Zeile gespeichert
		int zeile = 1;	//F�r Zeilenangabe
		int anzahlTrefferInZeile=0; //F�r Anzahl der Treffer in einer Zeile
		boolean suchWortInZeile=false; //Wird true, wenn gesuchtes Wort in Zeile ist 
		boolean wortVorhanden=false; //Wird true, wenn �bereinstimmendes Wort gefunden wurde
		boolean keineDatei=false; //Wird true, wenn keine Datei vorhanden ist
		
		
		try
		{
			FileReader fr= new FileReader(pfad); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			BufferedReader br = new BufferedReader(fr); //Buffered Reader wird mit FileReader Objekt als Parameter erstellt. Dient zur Pufferung der Daten 
			
			try
			{
				while((txt=br.readLine())!=null) //Solange wie der R�ckgabewert der Methode nicht null ist, sonst abbruch
				{
					suchWortInZeile=false;
					
					for(int i=0;i<txt.length()-suchWort.length()+1;i++) //Schleife f�r gleiches jedes Zeichens
					{
						
						for(int x=0;x<suchWort.length();x++) //Schleife, so l�nge l�uft wie Zeichen im gesuchten Wort 
						{

							
							if(suchWort.charAt(x)==txt.charAt(i+x)) //Wenn Zeichen im Suchwort mit dem im Text �bereinstimmen
							{
								suchWortInZeile=true;
								wortVorhanden=true;
								if(x==suchWort.length()-1) //Wird true wenn das komplette Wort verglichen wurde und demzufolge vorhanden ist
								{
									anzahlTrefferInZeile++; //Wird inkrementiert, wenn Wort gefunden wurde 
								}
								
							}
							
							if(suchWort.charAt(x)!=txt.charAt(i+x)) //Wenn Zeichen im Suchwort mit dem im Text NICHT �bereinstimmen
							{
								break; //Bricht Schleife ab, damit nicht weiter verglichen wird, wenn es eine Nicht�bereinstimmung gab
							}
							
						}
						
						

					}
					if(suchWortInZeile==true) //Wenn das gesuchte Wort in der Zeile war
					{
						System.out.println("Der gesuchte Text befindet sich in Zeile: "+zeile+" "+anzahlTrefferInZeile+"x !"); //Ausgabe mit Zeilenummer
					}
					
					anzahlTrefferInZeile=0; //Wird 0 gesetzt, da neue Zeile beginnt
					zeile++; //Wird inkrementiert, da neue Zeile beginnt
				}
				
			} catch (IOException e) //Wird bei einem Fehler im Lesen der Zeile geworfen
			{
				System.out.println("Fehler beim Lesen der Datei");
				e.printStackTrace(); //Methode, die beim Debuggen den Fehler bis zum Ursprung zur�ck verfolgt.Es werden Klasse und Zeile ausgegeben.
			}
			
		} catch (FileNotFoundException e) //Wird geworfen, wenn das Verzeichnis fehlerhaft ist oder die Datei nicht vorhanden ist
		{
			keineDatei=true;
			System.out.println("Das System kann die angegebene Datei nicht finden!");
		}
		
		if(wortVorhanden==false) //Wenn kein Wort �bereinstimmt
		{
			if(keineDatei==false) //Wenn eine Datei ausgelesen wurde (Wenn keine Datei vorhanden ist, kann auch kein Wort �bereinstimmen)
			{
				System.out.println("Der gesuchte Text: '"+ suchWort +"' ist nicht in der Datei!");
			}
		}
		System.out.println(); //F�r die �bersichtlichkeit
	}
	
	

	public static void main(String[] args)
	{
		verzeichnisAusgabe("C:/Pfad","Java");
		
	}

}
