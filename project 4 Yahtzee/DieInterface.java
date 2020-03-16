package Yahtzee;

public interface DieInterface
{
	public static String[] dieFaces =
		{"+---+\n|   |\n| o |\n|   |\n+---+",
		 "+---+\n|o  |\n|   |\n|  o|\n+---+",
		 "+---+\n|o  |\n| o |\n|  o|\n+---+",
		 "+---+\n|o o|\n|   |\n|o o|\n+---+",
		 "+---+\n|o o|\n| o |\n|o o|\n+---+",
		 "+---+\n|o o|\n|o o|\n|o o|\n+---+"};

	public static String toDieString(DieInterface aDie)
	{
		return dieFaces[aDie.getFaceValue() - 1];
	}

	public static String toDiceString(DieInterface[] dice)
	{
		StringBuilder result = new StringBuilder();

		String[] dies1, dies2, dies3, dies4, dies5;
		
		dies1 = dieFaces[dice[0].getFaceValue() - 1].split("\n");
		dies2 = dieFaces[dice[1].getFaceValue() - 1].split("\n");
		dies3 = dieFaces[dice[2].getFaceValue() - 1].split("\n");
		dies4 = dieFaces[dice[3].getFaceValue() - 1].split("\n");
		dies5 = dieFaces[dice[4].getFaceValue() - 1].split("\n");
		
		for(int i = 0; i < 5; i++)
		{
			result.append(dies1[i] + " " + dies2[i] + " " + dies3[i]
					+ " " + dies4[i] + " " + dies5[i] + "\n");
		}
		result.append("  1     2     3     4     5");
		
		return result.toString();
	}

    public int roll();
	public int getFaceValue();
}
