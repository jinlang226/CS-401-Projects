
public class Temp 
{
	public static void main(String[] args)
	{
		int[] x = new int[10];
		int y = 0;
		try
		{
			y++;
			x[10] = 123;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Yooooooo");
		}
		finally // still excuate
		{
			System.out.println("finally");
		}
		System.out.println("y: " + y);
	}
}
