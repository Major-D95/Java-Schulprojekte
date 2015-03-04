package schritt_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* Schreiben Sie eine Java-Methode, welche eine Textdatei nach einen Suchtext durchsuchen kann. (Keine Java-Klasse verwenden).
 * 
 * Ich benutze den naiven Suchalgorithmus, da dieser Suchalgorithmus, meiner Meinung nach, für das Programm ausreicht.
 * Performantere Suchalgorithmen würden hier keine spürbaren schnelleren Ergebnisse erzielen.
*/


public class Schritt4Main
{
	
	public static void Dateiauslesen(String dateiname,String suchWort)
	{
		
		
		String txt = ""; //Darin wird Inhalt der Zeile gespeichert
		int zeile = 1;	//Für Zeilenangabe
		int anzahlTrefferInZeile=0; //Für Anzahl der Treffer in einer Zeile
		boolean suchWortInZeile=false; //Wird true, wenn gesuchtes Wort in Zeile ist 
		boolean wortVorhanden=false; //Wird true, wenn übereinstimmendes Wort gefunden wurde
		boolean keineDatei=false; //Wird true, wenn keine Datei vorhanden ist
		
		
		try
		{
			FileReader fr= new FileReader(dateiname); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			BufferedReader br = new BufferedReader(fr); //Buffered Reader wird mit FileReader Objekt als Parameter erstellt. Dient zur Pufferung der Daten 
			
			try
			{
				while((txt=br.readLine())!=null) //Solange wie der Rückgabewert der Methode nicht null ist, sonst abbruch
				{
					suchWortInZeile=false;
					
					for(int i=0;i<txt.length()-suchWort.length()+1;i++) //Schleife für gleiches jedes Zeichens
					{
						
						for(int x=0;x<suchWort.length();x++) //Schleife, so länge läuft wie Zeichen im gesuchten Wort 
						{

							
							if(suchWort.charAt(x)==txt.charAt(i+x)) //Wenn Zeichen im Suchwort mit dem im Text übereinstimmen
							{
								suchWortInZeile=true;
								wortVorhanden=true;
								if(x==suchWort.length()-1) //Wird true wenn das komplette Wort verglichen wurde und demzufolge vorhanden ist
								{
									anzahlTrefferInZeile++; //Wird inkrementiert, wenn Wort gefunden wurde 
								}
								
							}
							
							if(suchWort.charAt(x)!=txt.charAt(i+x)) //Wenn Zeichen im Suchwort mit dem im Text NICHT übereinstimmen
							{
								break; //Bricht Schleife ab, damit nicht weiter verglichen wird, wenn es eine Nichtübereinstimmung gab
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
				e.printStackTrace(); //Methode, die beim Debuggen den Fehler bis zum Ursprung zurück verfolgt.Es werden Klasse und Zeile ausgegeben.
			}
			
		} catch (FileNotFoundException e) //Wird geworfen, wenn das Verzeichnis fehlerhaft ist oder die Datei nicht vorhanden ist
		{
			keineDatei=true;
			System.out.println("Das System kann die angegebene Datei nicht finden!");
		}
		
		if(wortVorhanden==false) //Wenn kein Wort übereinstimmt
		{
			if(keineDatei==false) //Wenn eine Datei ausgelesen wurde (Wenn keine Datei vorhanden ist, kann auch kein Wort übereinstimmen)
			{
				System.out.println("Der gesuchte Text: '"+ suchWort +"' ist nicht in der Datei!");
			}
		}
	}

	public static void main(String[] args)
	{
		
		Dateiauslesen("C:/PfadZumProjektOrdner/Projekt_FOS/src/schritt_4/test.txt","Java");

	}

}
