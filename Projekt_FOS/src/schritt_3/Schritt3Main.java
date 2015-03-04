package schritt_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Schritt3Main
{
	
	//Methode, die eine Textdatei nach einem Wort durchsucht und die Zeile ausgibt. Parameter sind Pfad und Dateiname, sowie ein gesuchtes Wort.
	public static void Dateiauslesen(String dateiname,String suchWort)
	{
		String txt = ""; //Darin wird Inhalt der Zeile gespeichert
		int zeile = 1;	//Für Zeilenangabe
		boolean keineDatei=false; //Wird true, wenn keine Datei vorhanden ist
		boolean wortVorhanden=false; //Wird true, wenn übereinstimmendes Wort gefunden wurde
		
		try
		{
			FileReader fr= new FileReader(dateiname); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			BufferedReader br = new BufferedReader(fr); //Buffered Reader wird mit FileReader Objekt als Parameter erstellt. Dient zur Pufferung der Daten 
			
			try
			{
				
				while((txt=br.readLine())!=null) //Solange wie der Rückgabewert der Methode nicht null ist, sonst abbruch
				{
					
						if(txt.contains(suchWort)) //Wenn gesuchtes Wort in Zeile vorhanden ist
						{
							wortVorhanden=true; //Es wurde eine Übereinstimmung gefunden
							System.out.println("Der gesuchte Text befindet sich in Zeile: "+zeile); //Kontrollausgabe mit Zeile
						}
					
					zeile++; //Zeile wird hochgezählt
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
		Dateiauslesen("C:/PfadZumProjektOrdner/Projekt_FOS/src/schritt_3/test.txt","Java");

	}

}
