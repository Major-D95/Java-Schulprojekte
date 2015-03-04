package firmaHaRoArtikelverwaltung;


abstract class Verkaufsware extends Artikel
{
  // Anfang Attribute
    private double verkaufspreis;
    private static double mehrwertsteuerkosten=0;
    private static double mehrwertsteuer=0.19;
    private static double verminderteMehwertsteuer=0.07;
  // Ende Attribute
    
    
   public Verkaufsware()
   {
     super();
      System.out.print("Bitte geben Sie den Verkaufspreis des Artikels ein: ");
      verkaufspreis=eingabe.nextDouble();
      System.out.println();
      mehrwertsteuerBerechnung();
   }
   // Anfang Methoden

   
   //Methode, die die Mehrwertsteuer eines Verkaufsartikel berechnet
    public void mehrwertsteuerBerechnung()
    {
    	
     //Eingabe des Mehrwertsteuertyps 
      System.out.println("Bitte geben Sie den Mehrwertsteuertyp an:(normal,vermindert) ");
      String typ=eingabe.next();
      System.out.println();
      
      boolean mehrwertsteuerBerechnet=false; //Prüfvariable
      
      //Prüft Eingabe und berechnet Mehrwersteuer und summiert Kosten der Mehrwertsteuer
      if(typ.equals("normal"))
      {
        mehrwertsteuerkosten+=verkaufspreis*mehrwertsteuer;
        verkaufspreis+=verkaufspreis*mehrwertsteuer;
        
        mehrwertsteuerBerechnet=true;
      }
      if(typ.equals("vermindert"))
      {
        mehrwertsteuerkosten+=verkaufspreis*verminderteMehwertsteuer;
        verkaufspreis+=verkaufspreis*verminderteMehwertsteuer; 
        mehrwertsteuerBerechnet=true;
      }
      
      //Wenn boolean false bleibt, ruft sich die Methode rekursiv auf
      if(mehrwertsteuerBerechnet==false)
      {
        System.out.println("Ungültige Angabe !");
        mehrwertsteuerBerechnung();
      }  
      
    }
    
    //Methode, die die summierte Mehrwertsteuer aller Instanzen ausgibt
    public static void printMehrwertsteuerkosten()
    {
    System.out.println("Die Mehrwertsteuerkosten belaufen sich auf: "+mehrwertsteuerkosten+"€");
    }
    
    //Anfang Setter/Getter Methoden
    public double getVerkaufspreis()
    {
      return verkaufspreis;
    }
    
    public void setVerkaufspreis(double verkaufspreis)
    {
      this.verkaufspreis=verkaufspreis;
    }

    public static double getMehrwertsteuer()
    {
      return mehrwertsteuer;
    }
  
    public static void setMehrwertsteuer(double mehrwertsteuer)
    {
      Verkaufsware.mehrwertsteuer = mehrwertsteuer;
    }
  
    public static double getVerminderteMehwertsteuer()
    {
      return verminderteMehwertsteuer;
    }
  
    public static void setVerminderteMehwertsteuer(double verminderteMehwertsteuer)
    {
      Verkaufsware.verminderteMehwertsteuer = verminderteMehwertsteuer;
    }
  
    public static double getMehrwertsteuerkosten()
    {
      return mehrwertsteuerkosten;
    }
  
    public static void setMehrwertsteuerkosten(double mehrwertsteuerkosten)
    {
      Verkaufsware.mehrwertsteuerkosten = mehrwertsteuerkosten;
    }
    
    //Ende Setter/Getter Methoden
    
  // Ende Methoden
}
