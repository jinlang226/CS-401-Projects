import java.util.*;

public class Ave 
{
	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		System.out.print("How many person?");
		int numStudents = inScan.nextInt();
		
		if (numStudents <= 0)
		{
			System.out.println("Cannot calculate!");
		}
		else
		{
			//calculate average
			int sum = 0;
			int counter = 0;
			
			while(counter != numStudents)
			{
				System.out.print("Enter the score #" + (counter + 1) + ":");
				int score = inScan.nextInt();
				
				while(score < 0 || score > 100)
				{
					System.out.println("Invalid score. Please enter again:");
					score = inScan.nextInt();
				}
				
				sum += score;
				counter++;
			}
			
			System.out.println("The average is " + ((double)sum / numStudents));
			
		}	
	}
}


//continue, skip all, return
//break, skip
