package Yahtzee;

public class UpperSectionScoreTester
{
	public static void main(String[] args)
	{
		String[] names = {"  Ones", "  Twos", "Threes", " Fours", " Fives", " Sixes"};
		ScoreInterface[] scores = new ScoreInterface[6];
		for(int i = 0; i < 6; i++)
			scores[i] = new UpperSectionScore(names[i], i + 1);

		DieInterface[] dice = new DieInterface[5];
		for(int i = 0; i < 5; i++)
			dice[i] = new Die();

		System.out.println(DieInterface.toDiceString(dice));
		
		System.out.println("Here are your scores: \n");
		

		for(int j = 0; j < 6; j++)
			System.out.println(scores[j].getName() + ": " + scores[j].getDiceScore(dice));
	}
}