package Yahtzee;

import java.util.Arrays;

public class FullHouse extends Score
{
	int repete = 0;
	
	public FullHouse(String aName)
	{
		name = aName;
	}
	
	public int getDiceScore(DieInterface[] dice)
	{
		int[] intDice = new int[5];
		for(int i = 0; i < 5; i++)
		{
			intDice[i] = Integer.parseInt(dice[i].toString());
		}
		Arrays.sort(intDice);
		
		if(intDice[0] == intDice[1] && intDice[0] == intDice[2] && intDice[4] == intDice[3] 
				&& intDice[0] != intDice[4])
		{
			return 25;
		}
		
		else if(intDice[1] == intDice[2] && intDice[3] == intDice[2] && intDice[0] == intDice[4] 
				&& intDice[1] != intDice[0])
		{
			return 25;
		}
		
		else if(intDice[2] == intDice[3] && intDice[3] == intDice[4] && intDice[0] == intDice[1] 
				&& intDice[2] != intDice[1])
		{
			return 25;
		}
		else
			return 0;
	}
}
