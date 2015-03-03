package paketGela_Auftragsbearbeitung;

import java.util.ArrayList;

public class Auftrag
{

	private String auftragsdatum;
	private Kunde seinKunde;
	ArrayList<Auftragsposition> positionsliste = new ArrayList<Auftragsposition>();

	public Auftrag(String auftragsdatum, Kunde seinKunde)
	{
		this.auftragsdatum = auftragsdatum;
		this.seinKunde = seinKunde;
		// positionsliste.add(new Auftragsposition());
	}

	public Auftragsposition holeAuftragspositionsstelle(int auftragsposition)
	{
		return positionsliste.get(auftragsposition);
	}

	public int anzahlAuftragspositionen()
	{
		return positionsliste.size();
	}

	public void setAuftragsdatum(String auftragsdatum)
	{
		this.auftragsdatum = auftragsdatum;
	}

	public String getAuftragsdatum()
	{

		return auftragsdatum;
	}

	public void positionHinzufügen(Auftragsposition neuePosition)
	{
		positionsliste.add(neuePosition);
	}

	public String getKunde()
	{
		return seinKunde.getName();
	}

	public void setKunde(Kunde newKunde)
	{
		seinKunde = newKunde;
	}

	public double berechneAuftragssumme()
	{

		double auftragsSumme = 0;

		for (int i = 0; i < positionsliste.size(); i++)
		{
			auftragsSumme += positionsliste.get(i).berechneVerkaufspreis();

		}

		return auftragsSumme;

	}

	public String konsolenanzeigeAuftragsposition(int index)
	{
		String datenAuftragsposition = positionsliste.get(index).toString();

		return datenAuftragsposition;

	}

	public String konsolenanzeigeAKop()
	{
		
		return "Auftragsbestätigung \r "
				+ "\rAuftrag des Kunden "+seinKunde.toString()+" vom "+auftragsdatum+"\r"
				+ "\rArtikel:\t\tVKP/St. Menge\tGesamt "
				+ "\r------------------------------------------------------";

	}

	public String konsolenanzeigeAPos()
	{
		
		String returnString = "";

		for (int i = 0; i < positionsliste.size(); i++)
		{
			returnString += konsolenanzeigeAuftragsposition(i) + "\r";

		}
		returnString += "------------------------------------------------------\r"
				+ "Auftragssumme:\t\t\t\t"+berechneAuftragssumme()+"€";
		return returnString;
		
	}

	public void printAuftragsbestätigung()
	{

		System.out.println(konsolenanzeigeAKop());
		System.out.println(konsolenanzeigeAPos());
		
	}

}
