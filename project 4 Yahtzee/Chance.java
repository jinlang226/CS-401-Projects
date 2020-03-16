package Yahtzee;

public class Chance extends Score
{
	public DieInterface[] dice;
	
	public Chance(String AName)
	{
		name = AName;
	}
	
	public int getDiceScore(DieInterface[] dice)
	{
		for(int i = 0; i < 5; i++)
		{
			int x = Integer.parseInt(dice[i].toString());
			score += x;
		}
		return score;
	}
	
}
