package paketGela_Auftragsbearbeitung;

public class Auftragsposition
{

	private double menge;
	private Getränk getränk;

	public Auftragsposition()
	{

	}

	public Auftragsposition(double menge, Getränk getränk)
	{
		this.menge = menge;
		this.getränk = getränk;
	}

	public double getMenge()
	{
		return menge;
	}

	public void setMenge(double menge)
	{
		this.menge = menge;
	}

	public Getränk getGetränk()
	{
		return getränk;
	}

	public void setGetränk(Getränk getränk)
	{
		this.getränk = getränk;
	}

	public double berechneVerkaufspreis()
	{
		return menge * getränk.getVkpreis();
	}

	public String toString()
	{

		return getränk.toString() + "\t" + menge + "\t"
				+ berechneVerkaufspreis()+"€";
	}
}
