import java.util.Scanner;
import java.util.Random;
public class Lab04 
{
	public static void main(String[] args)
	{
		rollDice();
		Scanner keyboard = new Scanner(System.in);
		int x = 1;
		while (x == 1)
		{
			System.out.println("Would you like to continue? (y/n): ");
			String option = keyboard.nextLine();
			
			if (option.equals("y"))
			{
				rollDice();
				x = 1;
			}
			if (option.equals("n"))
			{
				System.out.print("Goodbye...");
				x = 2;
			}
		}
	}
	
	static void rollDice()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a number of rolls: ");
		int times = keyboard.nextInt();
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
			int max=12;
	        int min=2;
	        Random random = new Random();
	        int aRandomNumber = random.nextInt(max)%(max-min+1) + min;
	        
	        //System.out.println(s);
			//Random rand = new Random();
			//int aRandomNumber = (rand.nextInt()*10)+2;
			//System.out.println(aRandomNumber);
			if (aRandomNumber == 2)
				count2++;
			if (aRandomNumber == 3)
				count3++;
			if (aRandomNumber == 4)
				count4++;
			if (aRandomNumber == 5)
				count5++;
			if (aRandomNumber == 6)
				count6++;
			if (aRandomNumber == 7)
				count7++;
			if (aRandomNumber == 8)
				count8++;
			if (aRandomNumber == 9)
				count9++;
			if (aRandomNumber == 10)
				count10++;
			if (aRandomNumber == 11)
				count11++;
			if (aRandomNumber == 12)
				count12++;
		}
		System.out.println("Value: 2 Probability: " + ((double)count2 / times));
		System.out.println("Value: 3 Probability: " + ((double)count3 / times));
		System.out.println("Value: 4 Probability: " + ((double)count4 / times));
		System.out.println("Value: 5 Probability: " + ((double)count5 / times));
		System.out.println("Value: 6 Probability: " + ((double)count6 / times));
		System.out.println("Value: 7 Probability: " + ((double)count7 / times));
		System.out.println("Value: 8 Probability: " + ((double)count8 / times));
		System.out.println("Value: 9 Probability: " + ((double)count9 / times));
		System.out.println("Value: 10 Probability: " + ((double)count10 / times));
		System.out.println("Value: 11 Probability: " + ((double)count11 / times));
		System.out.println("Value: 12 Probability: " + ((double)count12 / times));
		
	}
}
