package dienstwagen;

public class Starter {

	public static void main(String[] args) 
	{
		
		Mitarbeiter mitarbeiterNo1 = new Mitarbeiter("Schmidt","Peter");
		
		Auto autoNo1 = new Auto("MKK PS 345","BMW","Blau");
		
		//mitarbeiterNo1.setSeinAuto(autoNo1);
		//autoNo1.setSeinFahrer(mitarbeiterNo1);

		//System.out.println(mitarbeiterNo1.toString());
		System.out.println(autoNo1.toString());
		

	}

}
