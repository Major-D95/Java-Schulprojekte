package ueben;

public class Starter 
{

	public static void main(String[] args) 
	{
		
		Player p1 = new Player();
		
		Room r1 = new Room();
		
		p1.setName("Player 1");
		
		r1.setName("Haus");
		
		p1.setPosition(r1);
		
		r1.setName("Garten");
		
		System.out.println(p1.getPosition().getName());

	}

}
