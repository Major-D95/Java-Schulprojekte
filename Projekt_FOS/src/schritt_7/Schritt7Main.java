package schritt_7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Schritt7Main
{
	//Methode, die den Code in der Zeile, in der sich der Link befindet, entfernt
	public static String getLink( String link)
	  {
		String linkAnfang="<a href=\""; //Variable, in der gespeichert ist, was vor dem eigentlichen Link steht
		String linkEnde="\">";			//Variable in der gespeichert istm was nach dem eigentlichen Link steht
		
	    int pos = link.indexOf(linkAnfang); //Speichert sich den Index, der nach dem Inhalt der Variable linkAnfang kommt

	    link=link.substring(pos + linkAnfang.length()); //Schneidet alles bis zum eigentlichen Link ab
	    
	    pos=link.indexOf(linkEnde); //Speichert sich den Index, der vor dem Inhalt der Variable linkEnde kommt
	    
	    link=link.substring(0,pos); //Schneidet alles nach dem eigentlichen Link ab
	    
	    return link; //Gibt Link zurück
	    
	  }
	
	//Ließt eine HTML Datei aus und sucht nach Links in ihr
	public static void Dateiauslesen(String dateiname)
	{
		String txt = ""; //Darin wird Inhalt der Zeile gespeichert
		boolean keineDatei=false; //Wird true, wenn keine Datei vorhanden ist
		boolean linkVorhanden=false; //Wird true, wenn übereinstimmendes Wort gefunden wurde
		
		try
		{
			FileReader fr= new FileReader(dateiname); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			BufferedReader br = new BufferedReader(fr); //Buffered Reader wird mit FileReader Objekt als Parameter erstellt. Dient zur Pufferung der Daten 
			
			try
			{
				
				while((txt=br.readLine())!=null) //Solange wie der Rückgabewert der Methode nicht null ist, sonst abbruch
				{
					
						if(txt.contains("a href")) //Wenn gesuchtes Wort in Zeile vorhanden ist
						{
							linkVorhanden=true;
							System.out.println(getLink(txt)); //Aufruf lässt Code aus dem Link entfernen und gibt ihn aus
							
						}
					
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
		
		if(linkVorhanden==false) //Wenn kein Link in Datei ist
		{
			if(keineDatei==false) //Wenn eine Datei ausgelesen wurde...
			{
				System.out.println("Es ist kein Link in der HTML Datei vorhanden !");
			}
		}
	}
	
	public static void main(String[] args)
	{
		
		Dateiauslesen("C:/PfadZuEinerHTMLDatei/Datei.html");

	}
	
}
