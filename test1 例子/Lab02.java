import java.util.Scanner;

public class Lab02 
{
	public static void main(String[] args)
	{
		double amount;
		double result;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter an amount:");
		
		amount = keyboard.nextDouble();
		result = (int)(amount * 100 + 0.5) / 100.0;
		
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
	

		System.out.println("You need the followings:");
		System.out.println(TwentyDollar + " twenty-dollar bill(s),");
		System.out.println(TenDollar + " ten-dollar bill(s),");
		System.out.println(FiveDollar + " five-dollar bill(s),");
		System.out.println(OneDollar + " one-dollar bill(s),");
		System.out.println(Quarter + " quarter(s),");
		System.out.println(Dime + " dime(s),");
		System.out.println(Nickel + " nickel(s), and");
		System.out.println(Penny + " penny(ies)");
		
		keyboard.close();
	}
}
