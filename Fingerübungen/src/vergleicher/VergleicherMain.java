package vergleicher;


public class VergleicherMain
{
	
	//Methode, die zwei gleichlange Arrays vergleicht
	//Wenn gleich wird 0 zurückgegeben, ansonsten die Position
	public static int vergleicher(int A[],int B[])
	{
		int returnValue=0; //Wert der zurückgegeben wird
		
		for(int i=0;i<A.length;i++) // Kontrukt prüft Array auf Ungleichheit
		{
			if (A[i]!=B[i])
			{
				returnValue=i+1;
			}
			
		}
		
		
		
		return returnValue; //Rückgabewert
	}
	
	
	public static void main(String[] args)
	{	
		//Arrays die verglichen werden
		int A[]={10,20,30,40,50,60,70,80,90,100};
		int B[]={10,20,30,40,50,60,70,80,90,100};
		
		
		
		System.out.println(vergleicher(A,B)); // Methodenaufruf mit Ausgabe des Rückgabewertes

	}

}
