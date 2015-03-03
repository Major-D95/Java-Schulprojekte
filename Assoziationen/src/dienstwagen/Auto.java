package dienstwagen;

public class Auto 
{

	private String kennzeichen;
	private String hersteller;
	private String farbe;
	private Mitarbeiter seinFahrer;
	
	public Auto(String kennzeichen,String hersteller,String farbe)
	{
		
		this.kennzeichen=kennzeichen;
		this.hersteller=hersteller;
		this.farbe=farbe;
		
	}
	
	public String toString()
	{
	
		String returnString="Das Auto ist vom Hersteller "+hersteller+" , hat die Farbe "+farbe+" und besitzt das Kennzeichen "+kennzeichen;
		
		
		if(seinFahrer.getVorname()!=null)
		{
			returnString+=" und wird vom Fahrer "+seinFahrer.getVorname()+" "+seinFahrer.getName()+" gefahren";
		}
		
		return returnString;
		
	}
	
	
	
	public String getKennzeichen() 
	{
		return kennzeichen;
	}
	
	public void setKennzeichen(String kennzeichen) 
	{
		this.kennzeichen = kennzeichen;
	}
	
	public String getHersteller() 
	{
		return hersteller;
	}
	
	public void setHersteller(String hersteller) 
	{
		this.hersteller = hersteller;
	}
	
	public String getFarbe() 
	{
		return farbe;
	}
	
	public void setFarbe(String farbe) 
	{
		this.farbe = farbe;
	}
	
	public Mitarbeiter getSeinFahrer() 
	{
		return seinFahrer;
	}
	
	public void setSeinFahrer(Mitarbeiter seinFahrer) 
	{
		this.seinFahrer = seinFahrer;

	}
	
	
	
}
