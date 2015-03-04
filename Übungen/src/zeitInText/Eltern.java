package zeitInText;


public class Eltern
{
	int Anzahl;
	String name;
	static String test;
	
	public static void testMethode(String test)
	{
		Eltern.test=test;
	}
	
	Eltern(int Anzahl,String name)
	{
		this.Anzahl=Anzahl;
		this.name=name;
	}
	
	@Override public String toString()
	{
		return Anzahl+" "+name;
	}
}
