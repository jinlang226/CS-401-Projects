package Yahtzee;

public class UpperSectionScore extends Score
{
	public int number;
	
	public UpperSectionScore(String aName, int ANumber)
	{
		name = aName;
		number = ANumber;
	}
	
	public int getDiceScore(DieInterface[] dice)
	{
		for(int i = 0; i < 5; i++)
		{
			int x = Integer.parseInt(dice[i].toString());
			if(x == number)
			{
				score += number;
				//System.out.println(number + " " + score);
			}
		}
		return score;
	}
}
