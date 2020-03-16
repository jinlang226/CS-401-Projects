package Yahtzee;

import java.util.*;

public class OfAKind extends Score
{
	public int sameFace;
	public DieInterface[] dice;
	int repete = 0;
	
	public OfAKind(String aName, int numSameFaces)
	{
		name = aName;
		sameFace = numSameFaces;
	}
	
	public int getDiceScore(DieInterface[] dice)
	{
		int counter = 0;
		int[] intDice = new int[5];
		for(int i = 0; i < 5; i++)
		{
			intDice[i] = Integer.parseInt(dice[i].toString());
		}
		Arrays.sort(intDice);
		
		if(intDice[0] == intDice[1] && intDice[0] == intDice[2] && intDice[0] != intDice[4] 
				&& sameFace == 3)
		{
			return 3 * intDice[0];
		}
		
		else if(intDice[1] == intDice[2] && intDice[3] == intDice[2] && intDice[0] != intDice[4]
				&& sameFace == 3) 
		{
			return 3 * intDice[2];
		}
		
		else if(intDice[2] == intDice[3] && intDice[3] == intDice[4] && intDice[2] != intDice[1]
				&& sameFace == 3) 
		{
			return 3 * intDice[2];
		}
		
		else if(intDice[0] == intDice[1] && intDice[1] == intDice[2] && intDice[2] == intDice[3] 
				&& intDice[4] == intDice[3] && intDice[4] == intDice[5] && sameFace == 5)
		{
			return 50 * intDice[0];
		}
		else if(intDice[0] == intDice[1] && intDice[1] == intDice[2] && intDice[2] == intDice[3]
				&& sameFace == 4)
		{
			return 4 * intDice[0];
		}
		else if(intDice[1] == intDice[2] && intDice[2] == intDice[3] && intDice[4] == intDice[3]
				&& sameFace == 4)
		{
			return 4 * intDice[1];
		}
		return 0;
	}
}
