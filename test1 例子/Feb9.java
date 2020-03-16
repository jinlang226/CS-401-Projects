import java.util.Random;
import java.util.Scanner;
public class Feb9
{
	public static void main(String[] args)
	{
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to SCI Gas Station! \nPlease choose your service: \n 1) Gas only");
		System.out.println(" 2) Gas with car wash (10c off per gallon up to 15 gallons) \n 3) Exit");
		int option = keyboard.nextInt();
		
		while (option != 3)
		{
			while (option > 3 || option < 1)
			{
				System.out.println("Invalid option!");
				System.out.println("Please choose your service: ");
				System.out.println(" 1) Gas only");
				System.out.println(" 2) Gas with car wash (10c off per gallon up to 15 gallons");
				System.out.println(" 3) Exit");
				option = keyboard.nextInt();
			}
			if (option == 2)
				option2();
			if (option == 1)
				option1();

			System.out.println("\nWelcome to SCI Gas Station! \nPlease choose your service: \n 1) Gas only");
			System.out.println(" 2) Gas with car wash (10c off per gallon up to 15 gallons) \n 3) Exit");
			option = keyboard.nextInt();
		}
	}

	public static void option2()
	{
		double wash = 0;
		System.out.println("Please select a type of car wash:\n" +  " 1) Basic ($5.00)\n" + 
					" 2) Shine ($7.00)\n" + " 3) Deluxe ($9.00)\n" + " 4) Premium ($11.00)\n" + 
					" 5) Cancel");
		Scanner keyboard = new Scanner(System.in);
		int option3 = keyboard.nextInt();
		if (option3 == 1 || option3 == 2 || option3 == 3 || option3 == 4)
		{
			if (option3 == 1)
				wash = 5.00;
			if (option3 == 2)
				wash = 7.00;
			if (option3 == 3)
				wash = 9.00;
			if (option3 == 4)
				wash = 11.00;
			System.out.println("Please select a gasoline type");
			System.out.println(" 1) 87 ($2.59 per gallon)");
			System.out.println(" 2) 89 ($2.69 per gallon)");
			System.out.println(" 3) 91 ($2.74 per gallon)");
			System.out.println(" 4) 94 ($2.99 per gallon)");
			System.out.println(" 5) Cancel");
			int option4 = keyboard.nextInt();
			keyboard.nextLine();
			while (option4 > 5 || option4 < 1)
			{
				System.out.println("Invalid option!");
				System.out.println("Please selsct a gasoline type");
				System.out.println(" 1) 87 ($2.59 per gallon)");
				System.out.println(" 2) 89 ($2.69 per gallon)");
				System.out.println(" 3) 91 ($2.74 per gallon)");
				System.out.println(" 4) 94 ($2.99 per gallon)");
				System.out.println(" 5) Cancel");
				option4 = keyboard.nextInt();
				keyboard.nextLine();
			}	
			while (option4 == 5)
				break;
			
			double money = 0;
			if (option4 < 5 && option4 > 0)
			{
				System.out.println("You order is as follows:");
				if (option4 == 1)
				{
					System.out.println(" 1) 87 ($2.59 per gallon)");
					money = 2.59;
				}
				if (option4 == 2)
				{
					System.out.println(" 2) 89 ($2.69 per gallon)");
					money = 2.69;
				}
				if (option4 == 3)
				{
					System.out.println(" 3) 91 ($2.74 per gallon)");
					money = 2.74;
				}
				if (option4 == 4)
				{
					System.out.println(" 4) 94 ($2.99 per gallon)");
					money = 2.99;
				}
				System.out.println("Confirm your order? (y/n): ");
				String answer = keyboard.nextLine();

				while (!answer.equals("y") && !answer.equals("n"))
				{
					System.out.println("Invalid option!!!");
					System.out.println("Confirm your order? (y/n): ");
					answer = keyboard.nextLine();
				}
					
				if (answer.equals("y"))
				{
					double pay = 0;
					Random rand = new Random();
					double aRandomNumber = (rand.nextDouble()*10)+10;
					System.out.printf("It took %.2f gallons to fill up your car.\n", aRandomNumber);
					if (aRandomNumber <= 15.00)
					{
						pay = aRandomNumber * (money - 0.1) + wash;
						System.out.printf("Your total is $%,.2f\n" , pay);
					}
					if (aRandomNumber > 15.00)
					{
						pay = (15 * (money - 0.1)) + ((aRandomNumber-15) * money) + wash;
						System.out.printf("Your total is $%,.2f", pay);
					}
					
					
					System.out.println("\nPlease enter a payment amount in the following format:\n" + 
							"  <amount><space><type>\n" + 
							"    where <amount> is an integer\n" + 
							"          <space> is a blank space\n" + 
							"          <type> is either 20s, 10s, 5s, or 1s\n" + 
							"  You may enter as many times as you like. Each entry will be\n" + 
							"  added to your total until sufficient funds have been obtained.\n" + 
							"Enter your payment:");
					
					double moneyPaid = 0;
					int amount = keyboard.nextInt();
					String currency = keyboard.nextLine();
					if(currency.contains("20s")) 
					{
						moneyPaid += amount * 20;
					}
					else if(currency.contains("10s")) 
					{
						moneyPaid += amount * 10;
					}
					else if(currency.contains("5s")) 
					{
						moneyPaid += amount * 5;
					}
					else if(currency.contains("1s")) 
					{
						moneyPaid += amount * 1;
					}
					while (moneyPaid < pay)
					{
						System.out.println("You have added $" + moneyPaid + " to your total.");
						System.out.printf("You have paid $" + moneyPaid + " out of $%.2f", pay);
						System.out.printf("\nYou still owe $%,.2f", (pay - moneyPaid));
						System.out.println("\nEnter your payment: ");
						
						int amount1 = keyboard.nextInt();
						String currency1 = keyboard.nextLine();
						if(currency1.contains("20s")) 
						{
							moneyPaid += amount1 * 20;
						}
						else if(currency1.contains("10s")) 
						{
							moneyPaid += amount1 * 10;
						}
						else if(currency1.contains("5s")) 
						{
							moneyPaid += amount1 * 5;
						}
						else if(currency1.contains("1s")) 
						{
							moneyPaid += amount1 * 1;
						}
					}
					double charge = moneyPaid-pay;
					System.out.printf("Your charge is $%,.2f\n", charge);
					
					double result;
					result = (int)(charge * 100 + 0.5) / 100.0;
					int TwentyDollar = (int) result / 20;
					double result2 = (result - TwentyDollar * 20) * 100 / 100;
					int TenDollar = (int) result2 / 10;
					double result3 = (result2 - TenDollar * 10) * 100 / 100;
					int FiveDollar = (int) result3 / 5;
					double result4 = (result3 - FiveDollar * 5) * 100 / 100;
					int OneDollar = (int) result4 / 1;
					double result5 = (result4 - OneDollar * 1) * 100 / 100;
					int Quarter = (int) (result5 / 0.25);
					double result6 = (result5 - Quarter * 0.25) * 100 / 100;
					int Dime = (int) (result6 / 0.1);
					double result7 = (result6 - Dime * 0.1) * 100 / 100;
					int Nickel = (int) (result7 / 0.05);
					double result8 = (result7 - Nickel * 0.05) * 100 / 100;
					int Penny = (int) (result8 / 0.01) * 100 / 100;
					String sornot = "";
					if (TwentyDollar != 0)
					{
						System.out.println(TwentyDollar + " twenty");
					}
					if (TenDollar != 0)
					{
						if (TenDollar > 1)
							sornot = "s";
						System.out.println(TenDollar + " ten" + sornot);
					}
					if (FiveDollar != 0)
					{
						if (FiveDollar > 1)
							sornot = "s";
						System.out.println(FiveDollar + " five" + sornot);
					}
					if (OneDollar != 0)
					{
						if (OneDollar > 1)
							sornot = "s";
						System.out.println(OneDollar + " one" + sornot);
					}
					if (Quarter != 0)
					{
						if (Quarter > 1)
							sornot = "s";
						System.out.println(Quarter + " quarter" + sornot);
					}
					if (Dime != 0)
					{
						if (Dime > 1)
							sornot = "s";
						System.out.println(Dime + " dime" + sornot);
					}
					if (Nickel != 0)
					{
						if (Nickel > 1)
							sornot = "s";
						System.out.println(Nickel + " nickel" + sornot);
					}
					if (Penny != 0)
					{
						if (Penny > 1)
							sornot = "ies";
						else 
							sornot = "y";
						System.out.println(Penny + " penn" + sornot);
					}
					System.out.println("Thank you for shooping at SCI gas station");
				}
			}
		}
		
	}

	public static void option1()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please select a gasoline type");
		System.out.println(" 1) 87 ($2.59 per gallon)");
		System.out.println(" 2) 89 ($2.69 per gallon)");
		System.out.println(" 3) 91 ($2.74 per gallon)");
		System.out.println(" 4) 94 ($2.99 per gallon)");
		System.out.println(" 5) Cancel");
		int option4 = keyboard.nextInt();
		keyboard.nextLine();
		while (option4 > 5 || option4 < 1)
		{
			System.out.println("Invalid option!");
			System.out.println("Please selsct a gasoline type");
			System.out.println(" 1) 87 ($2.59 per gallon)");
			System.out.println(" 2) 89 ($2.69 per gallon)");
			System.out.println(" 3) 91 ($2.74 per gallon)");
			System.out.println(" 4) 94 ($2.99 per gallon)");
			System.out.println(" 5) Cancel");
			option4 = keyboard.nextInt();
			keyboard.nextLine();
		}	
		while (option4 == 5)
			break;
			
		double money = 0;
		if (option4 < 5 && option4 > 0)
		{
			System.out.println("You order is as follows:");
			if (option4 == 1)
			{
				System.out.println(" 1) 87 ($2.59 per gallon)");
				money = 2.59;
			}
			if (option4 == 2)
			{
				System.out.println(" 2) 89 ($2.69 per gallon)");
				money = 2.69;
			}
			if (option4 == 3)
			{
				System.out.println(" 3) 91 ($2.74 per gallon)");
				money = 2.74;
			}
			if (option4 == 4)
			{
				System.out.println(" 4) 94 ($2.99 per gallon)");
				money = 2.99;
			}
			System.out.println("Confirm your order? (y/n): ");
			String answer = keyboard.nextLine();
		
			while (!answer.equals("y") && !answer.equals("n"))
			{
				System.out.println("Invalid option!!!");
				System.out.println("Confirm your order? (y/n): ");
				answer = keyboard.nextLine();
			}
					
			if (answer.equals("y"))
			{
				double pay = 0;
				Random rand = new Random();
				double aRandomNumber = (rand.nextDouble()*10)+10;
				System.out.printf("It took %.2f gallons to fill up your car.\n", aRandomNumber);
				
				pay = aRandomNumber * money;
				System.out.printf("Your total is $%,.2f\n" , pay);
			
					
				System.out.println("\nPlease enter a payment amount in the following format:\n" + 
							"  <amount><space><type>\n" + 
							"    where <amount> is an integer\n" + 
							"          <space> is a blank space\n" + 
							"          <type> is either 20s, 10s, 5s, or 1s\n" + 
							"  You may enter as many times as you like. Each entry will be\n" + 
							"  added to your total until sufficient funds have been obtained.\n" + 
							"Enter your payment:");
					
				double moneyPaid = 0;
				int amount = keyboard.nextInt();
				String currency = keyboard.nextLine();
				if(currency.contains("20s")) 
					moneyPaid += amount * 20;
				else if(currency.contains("10s")) 
					moneyPaid += amount * 10;
				else if(currency.contains("5s")) 
					moneyPaid += amount * 5;
				else if(currency.contains("1s")) 
					moneyPaid += amount * 1;
				while (moneyPaid < pay)
				{
					System.out.println("You have added $" + moneyPaid + " to your total.");
					System.out.printf("You have paid $" + moneyPaid + " out of $%.2f", pay);
					System.out.printf("\nYou still owe $%,.2f", (pay - moneyPaid));
					System.out.println("\nEnter your payment:");
					
					int amount1 = keyboard.nextInt();
					String currency1 = keyboard.nextLine();
					if(currency1.contains("20s")) 
						moneyPaid += amount1 * 20;
					else if(currency1.contains("10s")) 
						moneyPaid += amount1 * 10;
					else if(currency1.contains("5s")) 
						moneyPaid += amount1 * 5;
					else if(currency1.contains("1s")) 
						moneyPaid += amount1 * 1;	
				}
				double charge = moneyPaid-pay;
				System.out.printf("Your charge is $%,.2f\n", charge);
					
				double result;
				result = (int)(charge * 100 + 0.5) / 100.0;
				int TwentyDollar = (int) result / 20;
				double result2 = (result - TwentyDollar * 20) * 100 / 100;
				int TenDollar = (int) result2 / 10;
				double result3 = (result2 - TenDollar * 10) * 100 / 100;
				int FiveDollar = (int) result3 / 5;
				double result4 = (result3 - FiveDollar * 5) * 100 / 100;
				int OneDollar = (int) result4 / 1;
				double result5 = (result4 - OneDollar * 1) * 100 / 100;
				int Quarter = (int) (result5 / 0.25);
				double result6 = (result5 - Quarter * 0.25) * 100 / 100;
				int Dime = (int) (result6 / 0.1);
				double result7 = (result6 - Dime * 0.1) * 100 / 100;
				int Nickel = (int) (result7 / 0.05);
				double result8 = (result7 - Nickel * 0.05) * 100 / 100;
				int Penny = (int) (result8 / 0.01) * 100 / 100;
				String sornot = "";
				if (TwentyDollar != 0)
					System.out.println(TwentyDollar + " twenty");
				if (TenDollar != 0)
				{
					if (TenDollar > 1)
						sornot = "s";
					System.out.println(TenDollar + " ten" + sornot);
				}
				if (FiveDollar != 0)
				{
					if (FiveDollar > 1)
						sornot = "s";
					System.out.println(FiveDollar + " five" + sornot);
				}
				if (OneDollar != 0)
				{
					if (OneDollar > 1)
						sornot = "s";
					System.out.println(OneDollar + " one" + sornot);
				}
				if (Quarter != 0)
				{
					if (Quarter > 1)
						sornot = "s";
					System.out.println(Quarter + " quarter" + sornot);
				}
				if (Dime != 0)
				{
					if (Dime > 1)
						sornot = "s";
					System.out.println(Dime + " dime" + sornot);
				}
				if (Nickel != 0)
				{
					if (Nickel > 1)
						sornot = "s";
					System.out.println(Nickel + " nickel" + sornot);
				}
				if (Penny != 0)
				{
					if (Penny > 1)
						sornot = "ies";
					else 
						sornot = "y";
					System.out.println(Penny + " penn" + sornot);
				}
				System.out.println("Thank you for shooping at SCI gas station"); 
			}
		}
	}
}