import java.util.*;

public class Lab006 

{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("How many items will you enter?");
		int number = s.nextInt();
		
		double[] user;
		user = new double[number];
		
		for(int i = 0; i < user.length; i++)
		{
			System.out.print("Number" + (i+1) + ": ");
			user[i] = s.nextDouble();
		}
		
		
		System.out.println("highest: " + max(user));
		System.out.println("lowest: " + min(user));
		System.out.println("sum: " + sum(user));
		System.out.println("average: " + ave(user));
		
		
	}
	
	public static double max(double[] user)
	{
		double highest = user[0];
		for(int i = 0; i < user.length; i++)
		{
			if(user[i] > highest)
				highest = user[i];
		}
		return highest;
	}
	
	public static double min(double[] user)
	{
		double lowest = user[0];
		for(int i = 0; i < user.length; i++)
		{
			if(user[i] < lowest)
				lowest = user[i];
		}
		return lowest;
		
	}
	
	public static double sum(double[] user)
	{
		double total = 0;
		for(int i = 0; i < user.length; i++)
			total += user[i];
		return total;
			
	}
	
	public static double ave(double[] user)
	{
		double ave = 0;
		ave = sum(user) / user.length;
		return ave;
	}
}
