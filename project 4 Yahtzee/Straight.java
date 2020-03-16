package Yahtzee;

import java.util.Arrays;

public class Straight extends Score
{
	public int numConse;
	DieInterface[] dice;
	
	public Straight(String aName, int numConsecutiveFaces)
	{
		name = aName;
		numConse = numConsecutiveFaces;
	}
	
	public int getDiceScore(DieInterface[] dice)
	{
		int[] intDice = new int[5];
		for(int i = 0; i < 5; i++)
		{
			intDice[i] = Integer.parseInt(dice[i].toString());
		}
		Arrays.sort(intDice);
		
		int counter = 1;
		for(int i = 0; i < 5; i++)
		{
			if(i < 4)
			{
				if(intDice[i+1] == intDice[i]+1)
				{
					counter++;
				}
				else if (intDice[i + 1] == intDice[i])
				{
					continue;
				}
			}
		}	
		
		if(numConse == 4 && counter >= 4)
			return 30;
		
		if(numConse == 5 && counter == 5)
			return 40;
		else
			return 0;
	}
}
