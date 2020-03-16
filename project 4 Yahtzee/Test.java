package Yahtzee;

public class Test 
{
	public static void main(String[] args)
	{
		DieInterface aDie = new Die();
		System.out.println(DieInterface.toDieString(aDie));
		DieInterface[] dice = new DieInterface[5];
		for(int i = 0; i < 5; i++)
		    dice[i] = new Die();
		System.out.println(DieInterface.toDiceString(dice));
		
		
	}
}
