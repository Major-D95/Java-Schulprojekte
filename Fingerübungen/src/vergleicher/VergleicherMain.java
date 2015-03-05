package vergleicher;


public class VergleicherMain
{
	
	//Methode, die zwei gleichlange Arrays vergleicht
	//Wenn gleich wird 0 zur�ckgegeben, ansonsten die Position
	public static int vergleicher(int A[],int B[])
	{
		int returnValue=0; //Wert der zur�ckgegeben wird
		
		for(int i=0;i<A.length;i++) // Kontrukt pr�ft Array auf Ungleichheit
		{
			if (A[i]!=B[i])
			{
				returnValue=i+1;
			}
			
		}
		
		
		
		return returnValue; //R�ckgabewert
	}
	
	
	public static void main(String[] args)
	{	
		//Arrays die verglichen werden
		int A[]={10,20,30,40,50,60,70,80,90,100};
		int B[]={10,20,30,40,50,60,70,80,90,100};
		System.out.println("Servus");
		System.out.println(A[3]);
		
		System.out.println(vergleicher(A,B)); // Methodenaufruf mit Ausgabe des R�ckgabewertes

	}

}
