package dienstwagen;

public class Mitarbeiter 
{
	
	private String name;
	private String vorname;
	private Auto seinAuto;
	
	public Mitarbeiter(String name,String vorname)
	{
		this.vorname=vorname;
		this.name=name;
		
	}
	
	public String toString()
	{
		String returnString="Der Mitarbeiter heißt "+vorname+" "+name;
		
		if(seinAuto.getKennzeichen()!="")
		{
		returnString+=" und fährt das Auto mit dem Kennzeichen "+seinAuto.getKennzeichen();
		}
		
		return returnString;
		
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
		
	}
	
	public void setVorname(String vorname)
	{
		this.vorname=vorname;
	}
	
	public String getVorname()
	{
		return vorname;
		
	}
	
	public void setSeinAuto(Auto seinAuto)
	{
		this.seinAuto=seinAuto;
		
	}
	
	public String getSeinAuto()
	{
		return seinAuto.toString();
	}
	
}
