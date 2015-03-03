package paketGela_Auftragsbearbeitung;

public class Getränk
{

	public String getBezeichnung()
	{
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung = bezeichnung;
	}

	public double getLagermenge()
	{
		return lagermenge;
	}

	public void setLagermenge(double lagermenge)
	{
		this.lagermenge = lagermenge;
	}

	public double getVkpreis()
	{
		return vkpreis;
	}

	public void setVkpreis(double vkpreis)
	{
		this.vkpreis = vkpreis;
	}

	private String bezeichnung;
	private double lagermenge;
	private double vkpreis;

	public Getränk(String bezeichnung, double lagermenge, double vkpreis)
	{

		this.bezeichnung = bezeichnung;
		this.lagermenge = lagermenge;
		this.vkpreis = vkpreis;

	}

	public String toString()
	{
		
		return bezeichnung+"\t"+vkpreis;
		
	}

}
