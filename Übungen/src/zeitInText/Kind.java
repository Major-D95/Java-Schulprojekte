package zeitInText;


public class Kind extends Eltern
{

	String Eltern;
	String Cousine;
	
	Kind(int Anzahl,String name,String Eltern,String Cousine)
	{
		super(Anzahl,name);
		
		this.Eltern=Eltern;
		this.Cousine=Cousine;
		
		
	}
	
	@Override public String toString()
	{
		return Anzahl+" "+name+" "+Eltern+" "+Cousine;
	}
	
}
