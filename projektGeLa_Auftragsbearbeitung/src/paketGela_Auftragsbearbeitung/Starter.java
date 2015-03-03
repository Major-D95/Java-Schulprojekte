package paketGela_Auftragsbearbeitung;

public class Starter
{

	public static void main(String[] args)
	{

		Kunde kunde1 = new Kunde("Finke Getränke KG");

		Getränk getraenk1 = new Getränk("Coca light, 0,3l", 500, 1.10);
		Getränk getraenk2 = new Getränk("Lemonlimoande, 0,3l", 500, 0.90);
		Getränk getraenk3 = new Getränk("Apfelschorle, 0,5l", 1000, 1.00);
		Getränk getraenk4 = new Getränk("Blauquelle nat., 0,7l", 1000, 0.45);
		Getränk getraenk5 = new Getränk("Himbeersaft, 1,0l", 300, 1.75);

		Auftrag auftrag1 = new Auftrag("27.Feb.2015", kunde1);

		auftrag1.positionHinzufügen(new Auftragsposition(20, getraenk1));
		auftrag1.positionHinzufügen(new Auftragsposition(50, getraenk3));
		auftrag1.positionHinzufügen(new Auftragsposition(30, getraenk5));
		auftrag1.positionHinzufügen(new Auftragsposition(60, getraenk4));
		auftrag1.positionHinzufügen(new Auftragsposition(10, getraenk2));
			
		auftrag1.printAuftragsbestätigung();
		

	}

}
