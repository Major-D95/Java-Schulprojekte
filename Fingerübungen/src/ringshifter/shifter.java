package ringshifter;


public class shifter
{
	//Methode, die alle Inhalte im Array um eins nach rechts verschiebt
	public static void rightshift(char arr[])
	{
		char RAM =arr[arr.length-1];
		
		for(int i=arr.length-2;i>-1;i--)
		{
			
			arr[i+1]=arr[i];
		}
		
		arr[0]= RAM;

	}
	
	//Methode, die alle Inhalte im Array um eins nach links verschiebt
	public static void leftshift(char arr[])
	{
		char RAM =arr[0];
		
		for(int i=0;i<arr.length-1;i++)
		{
			
			arr[i]=arr[i+1];
		}
		
		arr[arr.length-1]= RAM;

	}
	
	//Methode, die n mal die Werte im Array verschiebt
	public static void doRingshiftNX(char arr[],int anz)
	{
		if(anz>0)
		{
			for(int n=0;n<anz;n++)
			{
				rightshift(arr);
			}
		}
		if(anz<0)
		{
			for(int n=anz;n<0;n++)
			{
				leftshift(arr);
			}
		}
		
	}
	
	//Methode, die das übergebene Array ausgibt
	public static void arrPrinter(char arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(i+": "+(int)arr[i]);
		}
	}
	
	public static void main(String[] args)
	{
		char arr[]={1,2,3,4,5,6,7,8,9};
		int anz=-3;
		
		doRingshiftNX(arr,anz);
		arrPrinter(arr);
	}

}
