package vererbungFahrzeuge;


public class FahrzeugTest
{

	public static void main(String[] args)
	{
		System.out.println("Start des Programms");
		
		Fahrzeug fahrzeugArray[] = new Fahrzeug[6];
		
		for(int i=0;i<3;i++)
		{
			fahrzeugArray[i]=new Pkw();
		}
		
		for(int i=2;i<6;i++)
		{
			fahrzeugArray[i]=new Motorrad();
		}
		
		for(int i=0;i<fahrzeugArray.length;i++)
		{
			fahrzeugArray[i].print();
		}
		
		
		
	}

}
