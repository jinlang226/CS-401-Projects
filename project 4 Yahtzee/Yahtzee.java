package Yahtzee;

import java.util.*;

public class Yahtzee 
{
	public static String name = "";
	public static ScoreInterface[] scores = new ScoreInterface[13];
	public static int category = 0;
	public static DieInterface[] dice = new DieInterface[5];
	public static ArrayList<ScoreInterface> newScore = new ArrayList<>();
	
	public static void main(String[] args)
	{
		String answer = "";
		Scanner s = new Scanner(System.in);
		
		String[] names = {"            Ones", "            Twos", 
				"          Threes", "           Fours", "           Fives", 
				"           Sixes"};
		
		for(int i = 0; i < 6; i++)
			scores[i] = new UpperSectionScore(names[i], i + 1);
		scores[6] = new OfAKind(" Three of a Kind", 3);
		scores[7] = new OfAKind("  Four of a Kind", 4);
		scores[8] = new FullHouse("      Full House");
		scores[9] = new Straight("  Small Straight", 4);
		scores[10] = new Straight("  Large Straight", 5);
		scores[11] = new Chance("          Chance");
		scores[12] = new OfAKind("         Yahtzee", 5);
		
		for(int i = 0; i < 13; i++)
		{
			newScore.add(scores[i]);
		}
		
		System.out.println("Would you like to play Yahtzee?");
		answer = s.nextLine();
		while(!answer.equals("y"))
		{
			if(answer.equals("n"))
			{
				System.out.println("Thank you...");
				break;
			}
			else
			{
				System.out.println("Would you like to play Yahtzee?");
				answer = s.nextLine();
			}
		}
		while(answer.equals("y"))
		{
			System.out.println("Please enter your name: ");
			name = s.nextLine();
			
			System.out.println(theCard());
			
			for(int i = 0; i < 5; i++)
			    dice[i] = new Die();
			
			for(int x = 0; x < 13; x++)
			{
				while(!scores[x].isUsed())
				{
					for(int i = 0; i < 2; i++)
					{
						if(i == 0)
							System.out.println("First Roll: ");
						else if(i == 1)
							System.out.println("Second Roll: ");
						
						System.out.println(DieInterface.toDiceString(dice));
						System.out.println("Please enter the list of dice that you want to keep: ");
						String keepDice = s.nextLine();
						
						if(!keepDice.contains("1"))
							dice[0].roll();
						if(!keepDice.contains("2"))
							dice[1].roll();
						if(!keepDice.contains("3"))
							dice[2].roll();
						if(!keepDice.contains("4"))
							dice[3].roll();
						if(!keepDice.contains("5"))
							dice[4].roll();
					}
					
					System.out.println("Third Roll: ");
					System.out.println(DieInterface.toDiceString(dice));
					
					
					
					System.out.println("Here are your scores: \n");
					
					for(int j = 0; j < newScore.size(); j++)
					{
						if(j < 10)
							System.out.println(j+1 + ". " + newScore.get(j).getName() + ": " + newScore.get(j).getDiceScore(dice));
						else
							System.out.println(j+1 + "." + newScore.get(j).getName() + ": " + newScore.get(j).getDiceScore(dice));
					}
					
					
					for(int i = 0; i < 13; i++)
					{
						if(!scores[i].isUsed())
							scores[i].reset();
					}
						
						
					System.out.println("Which category would you like to use? (1 - " + newScore.size() + "):");
					category = s.nextInt();
					s.nextLine();
					
					
					
					for(int i = 0; i < 13; i++)
					{
						if(newScore.get(category-1).getName().equals(scores[i].getName()))
						{
							scores[i].setScore(dice);
						}
					}
					
					newScore.remove(category-1);
					
					System.out.println(theCard());
					
					for(int i = 0; i < 5; i++)
					{
						dice[i].roll();
					}
				}
			}
			
			
			// this is the last line
			System.out.println("Would you like to play Yahtzee?");
			answer = s.nextLine();
			
			while(!answer.equals("y"))
			{
				if(answer.equals("n"))
				{
					System.out.println("Thank you...");
					break;
				}
				else
				{
					System.out.println("Would you like to play Yahtzee?");
					answer = s.nextLine();
				}
			}
			
			if(answer.equals("y"))
			{
				for(int i = 0; i < 13; i++)
					scores[i].reset();
				
				for(int i = 0; i < 13; i++)
				{
					newScore.add(scores[i]);
				}
			}
		}
	}
	
	public static String theCard()
	{
		int total = 0;
		for(int i = 0; i < 13; i++)
		{
			//?
			total += scores[i].getScore();
		}
		
		String card = new String();
		card += "+----------------------+ \n"; //15
		
		card += "| Name: " + name;
		for(int i = 0; i < (15-name.length()); i++)
			card += " ";
		card += "| \n";
		card += "|                      | \n";
		
		for(int j = 0; j < 13; j++)
		{
			if(!scores[j].isUsed())
				card += "| " + scores[j].getName() + ": __ | \n";
			else
			{
				card += "| " + scores[j].getName() + ": " + scores[j].getScore();
				if(scores[j].getScore() < 10)
					card += "  | \n";
				else
					card += " | \n";
			}
		}
		
		card += "| -------------------- | \n";
		
		card += "|           Total:  " + total;
		if(total < 10)
			card += "  | \n";
		else if(total >= 10 && total < 100)
			card += " | \n";
		else if(total > 99)
			card += "| \n";
		card += "| ==================== |\n" + 
				"+----------------------+";
		return card;
	}
}