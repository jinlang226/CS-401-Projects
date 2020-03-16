import java.util.Scanner;

public class example 
{
	
	public static void main(String[] args)
	{
		
		//for(int i = 0; i < 10; i++)
		int i;
		for(i = 0; i < 10; i++)	
		{
			System.out.println(i);
		}
		System.out.println("After for:" + i);
		stillanother();
	}
	
	public static void diffwhile()	
	{
		int i = 0;
		while(i<10)
		{
			System.out.println(i);
			i++;
		}
	}
	
	
	public static void stillanother()
	{
		int result = 0;
		Scanner inScan = new Scanner(System.in);
		System.out.print("Enter an integer:");
		int n = inScan.nextInt();
		
		for (int i = 1; i <= n; i++)
		{
			result = result + i;
		}
		System.out.println("1 + .. + " + n + "is " + result);
	}
	
	public static void switchclass()
	{
		int n = 3;
		if (n == 1)
			System.out.println("one");
		else if (n == 2)
			System.out.println("Two");
		else
			System.out.println("no");
		
		System.out.println("Stitch");
		switch(n)
		{
			case 1:
				System.out.println("one");
				break;
			case 3:
				System.out.println("Three");
				break;
			default:
				System.out.println("not on, two, or three");
				break;
		}
	}
	
}
