package Yahtzee;

public abstract class Score implements ScoreInterface
{
	public String name;
	public boolean isUsed = false;
	public int score;
	int total = 0;
	DieInterface[] dice;
	
	
	public String getName()
	{
		return name;
	}
	
	public abstract int getDiceScore(DieInterface[] dice);
	
	public int getScore()
	{
		if(!isUsed())
			return 0;
		else
			return score;
	}
	
	public void setScore(DieInterface[] dice)
	{
		score = getDiceScore(dice);
		isUsed = true;
	}
	
	public boolean isUsed()
	{
		return isUsed;
	}
	
	public void reset()
	{
		score = 0;
		isUsed = false;
	}
	
	public String toString()
	{
	    String scoreString = String.format("%3d", score);
	    return name + ": " + scoreString;
	}
}
