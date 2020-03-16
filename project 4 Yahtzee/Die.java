package Yahtzee;
import java.util.*;

public class Die implements DieInterface
{
	public int value = 0;
	
	public int roll()
	{
		Random rand = new Random();
		value = rand.nextInt(6)+1;
		return value;
	}
	
	public int getFaceValue()
	{
		if(value == 0)
			roll();
		return value;
	}
	
	public String toString()
	{
		return value + "";
	}
}
