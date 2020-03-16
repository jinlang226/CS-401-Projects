import java.util.Scanner;
import java.util.Random;
public class Lab04 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		
		int x = 1;
		while (x == 1)
		{
			System.out.println("Please enter a number of rolls: ");
			int times = keyboard.nextInt();
			keyboard.nextLine();
			
			rollDice(times, random);
			
			System.out.println("Would you like to continue? (y/n): ");
			String option = keyboard.nextLine();
			
			if (option.equals("y"))
			{
				rollDice(times, random);
				x = 1;
			}
			if (option.equals("n"))
			{
				System.out.print("Goodbye...");
				x = 2;
			}
		}
	}
	
	static void rollDice(int times, Random random)
	{
		
		int a;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		int count7 = 0;
		int count8 = 0;
		int count9 = 0;
		int count10 = 0;
		int count11 = 0;		
		int count12 = 0;
		
		for (a = 1; a <= times; a++)
		{
			int max=6;
	        int min=1;
	        int randomnumber = random.nextInt(max)%(max-min+1) + min;
	        int randomnumber2 = random.nextInt(max)%(max-min+1) + min;
	        
	        int sum = randomnumber + randomnumber2;

			if (sum == 2)
				count2++;
			if (sum == 3)
				count3++;
			if (sum == 4)
				count4++;
			if (sum == 5)
				count5++;
			if (sum == 6)
				count6++;
			if (sum == 7)
				count7++;
			if (sum == 8)
				count8++;
			if (sum == 9)
				count9++;
			if (sum == 10)
				count10++;
			if (sum == 11)
				count11++;
			if (sum == 12)
				count12++;
		}
		System.out.println("Value: 2 Probability: " + ((double)count2 / (times*2)));
		System.out.println("Value: 3 Probability: " + ((double)count3 / (times*2)));
		System.out.println("Value: 4 Probability: " + ((double)count4 / (times*2)));
		System.out.println("Value: 5 Probability: " + ((double)count5 / (times*2)));
		System.out.println("Value: 6 Probability: " + ((double)count6 / (times*2)));
		System.out.println("Value: 7 Probability: " + ((double)count7 / (times*2)));
		System.out.println("Value: 8 Probability: " + ((double)count8 / (times*2)));
		System.out.println("Value: 9 Probability: " + ((double)count9 / (times*2)));
		System.out.println("Value: 10 Probability: " + ((double)count10 / (times*2)));
		System.out.println("Value: 11 Probability: " + ((double)count11 / (times*2)));
		System.out.println("Value: 12 Probability: " + ((double)count12 / (times*2)));
		
	}
}
