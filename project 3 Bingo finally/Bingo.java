import java.io.*;
import java.util.*;

public class Bingo 
{
	public static void main(String args[]) throws IOException
	{		
		File file = new File("players.txt");
		Scanner S = new Scanner(file);
		Scanner s = new Scanner(System.in);	
		String first = "";
		String last = "";
		double amount = 0;
		BingoPlayer x;
		ArrayList<Double> amounts = new ArrayList<Double>();
		ArrayList<BingoPlayer> players = new ArrayList<BingoPlayer>();
		
		//information is how many card the user want 
		//int[] information = new int[numberPlayer];
		
		double currentMoney = S.nextDouble();
		S.nextLine();
		//System.out.println(currentMoney);
		int numberPlayer = S.nextInt();
		S.nextLine();
		//System.out.println(numberPlayer);
		
		String[] user = new String[numberPlayer];
		
		for(int i = 0; i < numberPlayer; i ++)
		{
			String readLines = S.nextLine();
			user[i] = readLines;
		}

		Arrays.sort(user);
		
		for(int i = 0; i < numberPlayer; i++)
		{
			String[] info = user[i].split(",");
			first = info[0];
			last = info[1];
			amount = Double.parseDouble(info[2]);
			amounts.add(amount);
			//x = new BingoPlayer(first, last, amount);
			//players.add(x);
			//System.out.println((i+1) + ". " + players.get(i).getFullInfo());
		}	
		
		while(true)
		{
			ArrayList<BingoPlayer> newPlayers = new ArrayList<BingoPlayer>();
			int card = 0;
			String answer = "";
			double pot = 0;
			
			int option = 0; //draw a ball
			BingoCage bingoCage = new BingoCage();
			ArrayList<BingoBall> bingoBall = new ArrayList<BingoBall>();	
			
			//card the user have
			ArrayList<Integer> information = new ArrayList<Integer>();
			
			System.out.println("******************************");
			System.out.println("* Welcome to SCI Bingo House *");
			System.out.println("******************************");
			System.out.println("These are all available players:");
			

			for(int i = 0; i < numberPlayer; i++)
			{
				String[] info = user[i].split(",");
				first = info[0];
				last = info[1];
				x = new BingoPlayer(first, last, amounts.get(i));
				players.add(x);
				System.out.println((i+1) + ". " + players.get(i).getFullInfo());
			}	
			
			System.out.print("\n");
			
			S.close();
			
			for(int i = 0; i < numberPlayer; i++)
			{
				System.out.println(players.get(i).getFullName() + ", would you like to play this round? (y/n): ");
				answer = s.nextLine();
				while(!answer.equals("y"))
				{
					if(answer.equals("n"))
					{
						information.add(0);
						break;
					}
					System.out.println(players.get(i).getFullName() + ", would you like to play this round? (y/n): ");
					answer = s.nextLine();
				}				

				if(answer.equals("y"))
				{
					System.out.println("How many Bingo card would you like to buy? (1-4) ");
					card = s.nextInt();
					s.nextLine();
					//information is how many card the user want 										
	
					while(card > 4 || card < 1)
					{
						System.out.println("How many Bingo card would you like to buy? (1-4) ");
						card = s.nextInt();
						s.nextLine();
					}
					
					information.add(card);
					
					if(information.get(i) != 0)
					{						
						currentMoney += information.get(i) * 0.5;
						x = players.get(i);
						x.remove(information.get(i) * 1);
						
						double n = amounts.get(i) - information.get(i) * 1;
						amounts.set(i, n);

						pot += information.get(i) * 0.5;						
						BingoCard[] userCards = new BingoCard[card];
						for(int j = 0; j < card; j++)
						{
							userCards[j] = new BingoCard();
						}
						x.addBingoCards(userCards);	
						newPlayers.add(x);
					}
				}
			}
			
			boolean continueToPlay = true;
			
			for(int i = 0; i < information.size(); i++)
			{
				if(information.get(i) != 0)
				{				
					continueToPlay = false;
				}
			}
			if(continueToPlay == true)
				System.out.println("Thank you!!");

			if(continueToPlay == false)
			{
				System.out.println("House: $" + currentMoney);
				System.out.println("Pot: $" + pot);
				System.out.println("Balls : [ ]");
				for(int j = 0; j < newPlayers.size(); j++)
				{
					System.out.println(j+1 + ". " + newPlayers.get(j).toString());
				}			
			}	

			boolean alreadyBingo = false;		
			while(!alreadyBingo)
			{	
				for(int i = 0; i < newPlayers.size(); i++)
				{
					if(!(newPlayers.get(i).isBingo()))
					{
						System.out.println("There is no winning card yet.");
						System.out.println("There are two options from here");
						System.out.println(" 1) Draw a ball, 2) Draw balls until Bingo: ");
						option = s.nextInt();
						s.nextLine();
							
						while(option != 1 && option != 2)
						{
							System.out.println(" Invalid input, please try again!");
							System.out.println(" 1) Draw a ball, 2) Draw balls until Bingo: ");
							option = s.nextInt();
							s.nextLine();
						}
							
						if(option == 1)
						{									
							while(!newPlayers.get(i).isBingo())
							{
								BingoBall number = bingoCage.draw();						
								bingoBall.add(number);													
								int num = Integer.parseInt(number.toString());
								for(int j = 0; j < newPlayers.size(); j++)
									newPlayers.get(i).marks(num);
							}
						}									
							
						else if(option == 2)
						{
							BingoBall number = bingoCage.draw();						
							bingoBall.add(number);			
							System.out.println("House: $" + currentMoney);
							System.out.println("Pot: $" + pot);									
							System.out.println("Balls: " + bingoBall);							
							int num = Integer.parseInt(number.toString());												
							
							for(int j = 0; j < newPlayers.size(); j++)
							{
								newPlayers.get(i).marks(num);
								System.out.println(j+1 + ". " + newPlayers.get(j).toString());
							}		
						}
					}
					
					if(newPlayers.get(i).isBingo())
					{
						System.out.println(newPlayers.get(i).getFullName() + " says this card is a winning card");
						newPlayers.get(i).getBingoCards();
						System.out.println("These are balls that have been drawn so far in this round:");
						System.out.println("Balls : " + bingoBall);
						System.out.println("Is it a winning card (y/n)");
						String yesOrNo = s.nextLine();
						while(!yesOrNo.equals("y"))
						{
							System.out.println("Is it a winning card (y/n)");
							yesOrNo = s.nextLine();
						}
						if(yesOrNo.equals("y"))
						{
							System.out.println("This round is over. \n");
							
							for(int k = 0; k < numberPlayer; k++)
							{
								if(players.get(k).isBingo())
								{
									amounts.set(k, amounts.get(k)+ pot);
									players.get(k).add(pot);
								}
							}

							outputFile(players, currentMoney, amounts);
							newPlayers.clear();
							players.clear();

							
							bingoCage.reset();
							bingoBall = new ArrayList<BingoBall>();
							alreadyBingo = true;
							break;
						}
					}	
				}			
			}	
		}
	}

	public static void outputFile(ArrayList<BingoPlayer> players, double currentMoney, ArrayList<Double> amounts)
   	{
	    try 
	   	{
		    BufferedWriter out = new BufferedWriter(new FileWriter("players.txt"));
		    out.write(currentMoney + "\n");
		    out.write(players.size() + "\n");
		    for(int i = 0; i < players.size(); i++)
		    {
		    	String[] info2 = players.get(i).getFullInfo().split(" ");
				String firstName = info2[0];
				String lastName = info2[1];
		    	out.write(firstName + "," + lastName + "," + amounts.get(i) + "\n");
		    }
		    out.close();
	    }
	    catch (IOException e) 
	    {
	    }
   	}
}