import java.util.Random;
import java.util.Scanner;
public class SCIx
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		double money = 0;
		double washM = 0;
		double pay = 0;
		int wash = 0;
		int option = 0;
		
		//boolean optionTrue = false;
		while (true)
		{
			int type = getNumber("Welcome to SCI Gas Station! \nPlease choose your service: \n 1) Gas only"
					+ " \n 2) Gas with car wash (10c off per gallon up to 15 gallons) \n 3) Exit", 1, 3, s);
			
			if (type == 3)
			{
				System.out.println("You have successfully exit the system.");
				break;
			}
				
			option = getNumber("Please select a gasoline type" + "\n 1) 87 ($2.59 per gallon)" + 
					"\n  2) 89 ($2.69 per gallon)", 1, 5, s);
			
			money = optionN(option);
			
			if (type == 2)
			{
				wash = getNumber("Please select a type of car wash:\n" +  " 1) Basic ($5.00)\n" + 
					" 2) Shine ($7.00)\n" + " 3) Deluxe ($9.00)\n" + " 4) Premium ($11.00)\n" + 
					" 5) Cancel", 1, 5, s);	
				if (wash == 1)
					washM = 5.00;
				if (wash == 2)
					washM = 7.00;
				if (wash == 3)
					washM = 9.00;
				if (wash == 4)
					washM = 11.00;
				
				
				double paymd = payment2(pay, money, washM, s);
				calculation(paymd);
			}
			
			if (type == 1) 
			{
				double paymd = payment(pay, money);
				calculation(paymd);
			}
			
			
			
		}
	}
	

	public static double optionN(int option)
	{
		double moneyhh = 0;
		if (option == 1)
		{
			System.out.println(" 1) 87 ($2.59 per gallon)");
			moneyhh = 2.59;
		}
		if (option == 2)
		{
			System.out.println(" 2) 89 ($2.69 per gallon)");
			moneyhh = 2.69;
		}
		if (option == 3)
		{
			System.out.println(" 3) 91 ($2.74 per gallon)");
			moneyhh = 2.74;
		}
		if (option == 4)
		{
			System.out.println(" 4) 94 ($2.99 per gallon)");
			moneyhh = 2.99;
		}
		return moneyhh;
	}
	
	public static double payment2(double pay, double money, double washM, Scanner s)
	{
		Random rand = new Random();
		double aRandomNumber = (rand.nextDouble()*10)+10;
		
		System.out.printf("It took %.2f gallons to fill up your car.\n", aRandomNumber);
		if (aRandomNumber <= 15.00)
		{
			pay = aRandomNumber * (money - 0.1) + washM;
			System.out.printf("Your total is $%,.2f\n" , pay);
		}
		if (aRandomNumber > 15.00)
		{
			pay = (15 * (money - 0.1)) + ((aRandomNumber-15) * money) + washM;
			System.out.printf("Your total is $%,.2f", pay);
		}
		return pay;
	}
	
	public static double payment(double pay, double money)
	{
		Random rand = new Random();
		double aRandomNumber = (rand.nextDouble()*10)+10;
		System.out.printf("It took %.2f gallons to fill up your car.\n", aRandomNumber);
		pay = aRandomNumber * money;
		System.out.printf("Your total is $%,.2f\n" , pay);
		return pay;
	}
	
	
	
	
	public static int getNumber(String msg, int min, int max, Scanner s)
	{
		int result = 0;
		boolean a = true;
		while(a)
		{
			System.out.println(msg);
			result = s.nextInt();
			
			if(result < min || result > max)
				System.out.println("Invalid...");
			else
				a = false;
		}
		return result;
	}
	
	
	public static void calculation(double pay)
	{	
		Scanner s = new Scanner(System.in);
		System.out.println("\nPlease enter a payment amount in the following format:\n" + 
				"  <amount><space><type>\n" + 
				"    where <amount> is an integer\n" + 
				"          <space> is a blank space\n" + 
				"          <type> is either 20s, 10s, 5s, or 1s\n" + 
				"  You may enter as many times as you like. Each entry will be\n" + 
				"  added to your total until sufficient funds have been obtained.\n" + 
				"Enter your payment:");
		
		double moneyPaid = 0;
		int amount = s.nextInt();
		String currency = s.nextLine();
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
			
			int amount1 = s.nextInt();
			String currency1 = s.nextLine();
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