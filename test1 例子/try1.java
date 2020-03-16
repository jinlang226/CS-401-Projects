public class try1 
{
	public static void main(String[] args)
	{
		int x = 5;
		int y[] = new int[2];
		y[0] = 12;
		y[1] = 23;
		modifier(x, y);
		System.out.println(x);
		System.out.println(y[0]);
		System.out.println(x + "," + y[0] + "," + y[1]);
	}
	
	public static void modifier(int x, int[] y)
	{
		x = x + 1;
		y[0] += 2;
		System.out.println(x + y[0]);
	}
}
