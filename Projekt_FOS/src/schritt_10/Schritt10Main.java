package schritt_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


// ACHTUNG ! Links m�ssen mit Backslash geschrieben sein, sonst werden sie nicht erkannt !!!!

public class Schritt10Main
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
		    
		return link; //Gibt Link zur�ck
		    
	}
	
	//Lie�t die einzelnen Links in den HTML's aus
	public static ArrayList<String> Dateiauslesen(String dateiname) 
	{
		ArrayList<String> Links = new ArrayList<String>(); //Speichert Links der HTML Dateien darin
	
		String txt = ""; //String f�r Zeileninhalt
		int counter=0; //Index f�r Arraylist
		
		try
		{
			FileReader fr= new FileReader(dateiname); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			BufferedReader br = new BufferedReader(fr); //Buffered Reader wird mit FileReader Objekt als Parameter erstellt. Dient zur Pufferung der Daten 
			
			
			try
			{
				while((txt=br.readLine())!=null)
				{


					if(txt.contains("a href")) //Wenn ein HTMLlink-Tag in der Zeile enthalten ist 
					{
						Links.add(counter,getLink(txt)); //Link wird nach entfernung des Codes in die Liste gespeichert
						counter++; //Index f�r Arraylist
						
					}
					

				}
				
			} catch (IOException e) //Wird bei einem Fehler im Lesen der Zeile geworfen
			{
				e.printStackTrace(); //Methode, die beim Debuggen den Fehler bis zum Ursprung zur�ck verfolgt.Es werden Klasse und Zeile ausgegeben.
			}
			
		} catch (FileNotFoundException e)  //Wird geworfen, wenn das Verzeichnis fehlerhaft ist oder die Datei nicht vorhanden ist
		{
			
			System.out.println("Das System kann die angegebene Datei nicht finden!");
		}
		
		return Links; //Arraylist mit den Links wird zur�ckgegeben
	}
	
	
	//Lie�t den �bergebenen Pfad aus und gibt in einer ArrayList alle in den sich befindenen HTMLs zur�rck 
	public static ArrayList<String> verzeichnisAusgabe(String verzeichnis)
	{
		ArrayList<String> HTMLDateien = new ArrayList<String>(); //Arraylist f�r HTML-Dateien
		

			File f = new File(verzeichnis); //Es wird ein File Objekt erstellt, welches als Parameter das Verzeichnis mitgegeben bekommt
			File[] fileArray = f.listFiles(); //Methode die ein File Array mit Ordnern und Dateien zur�ckgibt
			

			
			if(fileArray!=null) //Pr�ft ob Inhalt im Array ist
			{
				if(fileArray.length!=0)
				{
					for(int i=0;i<fileArray.length;i++) //Schleife, die ein Array ausgibt, in der Pfade und Dateien gespeichert sind.
					{
						
						
						if((fileArray[i].isFile())&&(fileArray[i].getName().endsWith("html"))) //Pr�ft ob es eine Datei ist und es der Dateityp ist
						{
							HTMLDateien.add(fileArray[i].getPath()); //Gibt Pfad + Dateiname aus
							
						}
	
					}
	
						
					for(int i=0;i<fileArray.length;i++) //Schleife, die ein Array ausgibt, in der Pfade und Dateien gespeichert sind.
					{
					
						if(fileArray[i].isDirectory()) //Pr�ft ob Array an der Stelle ein Ordner ist.
						{
							
						 //Und Methode ruft sich, mit dem aktuellen Verzeichnis als Parameter, rekursiv auf.
							verzeichnisAusgabe(String.valueOf(fileArray[i]));
					
						}
				
					}
			
				}else //Wenn keine Dateien im Pfad vorhanden sind
				{
				System.out.println("Es sind keine HTML Webseiten im Pfad vorhanden");
				}
				
			}else //Wenn FileArray null ist
			{

				System.out.println("Bitte einen korrekten Dateipfad angeben ! Beispiel: C:/... ");
			}


		return HTMLDateien; //R�ckgabe der HTML Dateien als Arraylist
	}
	
	//Berechnet und gibt die Rankings der HTML Seiten aus
	public static void getRanking(String path,int iterationen) //Methode, die das PageRanking der Seiten in einem Verzeichnis berechnet
	{		
	
		ArrayList<String> HTMLDateien = new ArrayList<String>(); //Liste f�r HTML Dateien
		ArrayList<String> Links = new ArrayList<String>();		//Liste die Links f�r HTML Dateien binhalten soll
		HTMLDateien=verzeichnisAusgabe(path);	    //Methodenaufruf, die die Liste mit HTML Dateien bef�llt von einem Verzeichnis
		double Rankings[]=new double[HTMLDateien.size()];	//Array mit den Rankings
		String LinkArray[][]=new String[HTMLDateien.size()][HTMLDateien.size()]; //Array f�r die Links f�r die jeweiligen HTML's
		
		//Links in Array packen
		for(int i=0;i<LinkArray.length;i++)
		{	
			Links=Dateiauslesen(HTMLDateien.get(i)); //Link wird bef�llt
			
			for(int x=0;x<Links.size();x++)
			{
				
				LinkArray[i][x]=Links.get(x); //Link wird in Array gespeichert
			
			}
			Links.clear(); //Sicherheitsl�schung
		}

		
		//Methode die das Standartranking festlegen
		for(int i=0;i<Rankings.length;i++)
		{
			Rankings[i]=1; // Ranking ist erst 0. (Wird sp�ter auf 1 gesetzt)
		}

			
			double dämpfungsfaktor=0.85; //D�mpfungsfaktor der f�r reale Berechnungen genutzt wird

			for(int z=0;z<iterationen;z++) //F�r die 100 Iterationen
			{	
				
				for(int a=0;a<HTMLDateien.size();a++) //L�uft a mal a=Anzahl der HTML Dateien
				{	
					double Zwischenergebnis=0;
					for(int x=0;x<HTMLDateien.size();x++) //Schleife f�r Durchlauf der HTML Dateien um nach Links abzusuchen und PageRank zu berechnen
					{	
						int linksAufSeite=0; //Z�hler f�r Links auf Webseite, die verlinkt
						boolean berechnen=false; //Damit nur berechnet wird, wenn auch ein Seite verlinkt
						
						for(int i=0;i<HTMLDateien.size();i++) //Schleife um die Links durchzugehen
						{
				
					
							if(LinkArray[x][i]!=null) //Damit keine Stelle gepr�ft wird, in dem kein Link ist
							{
		
								if(LinkArray[x][i].contains(HTMLDateien.get(a))) //Wenn Link in HTML Datei enthalten ist
								{
								
									berechnen=true; //Ein Link einer Webseite verlinkt auf die Seite
	
	
									for(int b=0;b<LinkArray[1].length;b++) //Schleife, die Z�hlung der Links auf der Seite
									{
										
										if(LinkArray[x][b]!=null) //Nur wenn ein Link enthalten ist
										{
	
											linksAufSeite++; //Links werden gez�hlt, wenn Inhalt nicht null ist.
										}
									}
	
								}
		
							}
						}
						
						if(berechnen) //Wenn ein Link einer Webseite verweist hat, wird berechnet
						{
			
							Zwischenergebnis+=(Rankings[x]/linksAufSeite); //Zwischenberechnung f�r den Inhalt der nach d mal in der Klammer kommt
							berechnen=false; //Wieder false, da gerechnet wurde
		
						}	
						
					}
					
					Rankings[a]=(1-dämpfungsfaktor)+dämpfungsfaktor*Zwischenergebnis; //Rest der Berechnung mit dem Zwischenergebnis
				}
		
			}
	
			//Ausgabe der PageRankings
			System.out.println("Nach "+iterationen+" Berechnung(en) sieht das PageRanking der Seiten wie folgt aus:");
			for(int x=0;x<HTMLDateien.size();x++) //F�r Ausgabe der Rankings jeder Seite
			{
				System.out.println("Ranking der Seite "+HTMLDateien.get(x)+" :"+(Rankings[x]));
				
			}

	
	}
	

	public static void main(String[] args)
	{
		
		getRanking("C:/HTML",100); //Parameter sind Pfad und Anzahl Iterationen zur Berechnung
		
	}

}
