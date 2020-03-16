import java.util.Scanner;

public class TowerOfHanoiPuzzle
{
	public static void main(String[] args)
	{
		int choice = 0;
		int choice2 = 0;
		String choice3 = "";
		String yesOrNo = "true";
		boolean cong = true;
		while(true)
		{
			Scanner s = new Scanner(System.in);
			System.out.println("Welcome to Tower of Hanoi Puzzle");
			System.out.println("Take a pick:");
			System.out.println("  1) Play a Tower of Hanoi Puzzle");
			System.out.println("  2) Exit");
			choice = s.nextInt();
			while(choice != 1 && choice != 2)
			{
				System.out.println("WE ARE HERE!");
				System.out.println("Welcome to Tower of Hanoi Puzzle");
				System.out.println("Take a pick:");
				System.out.println("  1) Play a Tower of Hanoi Puzzle");
				System.out.println("  2) Exit");
				choice = s.nextInt();
			}
			
			if(choice == 1)
			{
				System.out.println("How many disks would like to play (between 1 and 64): ");
				choice2 = s.nextInt();
				while(choice2 > 64 || choice2 < 1)
				{
					System.out.println("How many disks would like to play (between 1 and 64): ");
					choice2 = s.nextInt();
				}

				TowerOfHanoi toh = new TowerOfHanoi(choice2);
				System.out.println(toh.toString());


				System.out.println("\nThe goal is to move all " + choice2 + " disks from pole 1 to pole 3");
				double number = Math.pow(2, choice2) - 1;
				int number1 = (int)number;
				System.out.println("The least number of moves for " + choice2 + " is " + number1);


				System.out.println("Are you ready to play? (y/n)");
				choice3 = s.nextLine();
				choice3 = s.nextLine();	

				if(choice3.equalsIgnoreCase("n")) 
					break;

				while(!choice3.equalsIgnoreCase("y") && !choice3.equalsIgnoreCase("n")) 
				{
					System.out.println("Are you ready to play? (y/n)");
					choice3 = s.nextLine();
				}		
				
				if(choice3.equalsIgnoreCase("y"))
				{
					System.out.println(toh.toString());
					int numMvoes = 0;
					System.out.println("Number of Moves: " + numMvoes);
					System.out.println("Enter <from><space><to> to move a disk:");
					String move = s.nextLine();
					
					boolean done = false;
					while(!done)
					{	
						String[] Moves = move.split(" ");
						int from = Integer.parseInt(Moves[0]);
						int to = Integer.parseInt(Moves[1]);
						
						if((from < 4 && from > 0) && (to < 4 && to > 0))
						{
							if(toh.move(from, to) == false)
		 					{
		 						System.out.println("You cannot move the top disk from pole " + (from) + " to " + (to));
		 						System.out.println("The top disk of pole " + (from) + " is larger than the top disk of pole " + (to));
		 						System.out.println("Or the pole does not have any disks");
		 					}

							System.out.println(toh.toString());
							
							
							if(toh.isWin())
							{
								numMvoes++;
								System.out.println("Congratulation!!!");
								System.out.println("Number of Moves: " + numMvoes);
								System.out.println("The least number of moves for " + choice2 + " is " + number1);
								toh.reset();
								done = true;
							}
							
						}

						else if((from > 3 || from < 1) || (to > 3 || to < 1))
						{
							System.out.println("Invalide number of pole!!");
							System.out.println("You cannot move the top disk from pole " + (from) + " to " + (to));
							System.out.println(toh.toString());
						}
						
		 				numMvoes++;
						
						if(!done)
						{
							System.out.println("Number of Moves: " + numMvoes);
							System.out.println("Enter <from><space><to> to move a disk:");
							move = s.nextLine();
						}
					}	
				}
			}
			else if(choice == 2) 
			{
				break;
			}
		}
	}
}