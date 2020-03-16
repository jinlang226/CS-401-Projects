public class BingoBall
{
	private int ballNumber;

	public BingoBall(int number)
	{
		//This is a constructor that constructs a Bingo ball with a given number.
		ballNumber = number;
	}

	public int getNumber()
	{
		//This method returns the integer representation of a Bingo ball (e.g., the ball number).
		return ballNumber;
	}

	public String toString()
	{
		//returns the string representation of the number of the Bingo ball
		return ballNumber + "";
	}
}