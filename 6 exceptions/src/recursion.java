
public class recursion 
{
	public static void main(String[] args)
	{
		System.out.println("result = " + factorial(3));
	}
	
	public static int factorial(int n)
	{
		System.out.println("n = " + n + ".");
		if(n == 0)  //base case
		{
			System.out.println("Returning 1");
			return 1;
		}
		
		else //recursive case
		{
			int result = n * factorial(n-1);
			System.out.println("Returning " + result + ".");
			return result;
		}
	}
}
