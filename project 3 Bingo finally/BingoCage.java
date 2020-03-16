import java.util.*;

public class BingoCage
{
	private ArrayList<BingoBall> balls;

	public BingoCage()
	{
		reset();		
		//This is a constructor that constructs a Bingo cage containing 75
		//unique Bingo balls (75 objects of type BingoBall).
	}

	public BingoBall draw()
	{
		Random rand = new Random();
		int randomCage = rand.nextInt(75);
		
		//System.out.println(randomCage);
		
		
		//This method randomly returns a Bingo ball (object of typeBingoBall). 
		//Note that if there are no more Bingo balls left, this method should return null.
		if(balls.isEmpty())
			return null;
		else
		{
			while(randomCage >= balls.size())
			{
				randomCage = rand.nextInt(75);
			}
			return balls.remove(randomCage);
		}			
	}

	public void reset()
	{
		//resets the cage back to the original 75 unique Bingo balls
		balls = new ArrayList<BingoBall>();
		
		for(int i = 0; i < 75; i++)
		{
			balls.add(new BingoBall(i + 1));
			//random
		}
	}
}