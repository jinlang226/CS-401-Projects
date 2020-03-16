// CS 0401 Spring 2019 Java Example 8
//   This handout demonstrates some issues relating to reference variables and
//   using them correctly to access objects.

public class Pole
{
	public static void main (String [] args)
	{
		StringBuilder S1, S2;
		S1 = new StringBuilder("Hello");
		System.out.println("S1 is " + S1);
		
		S2 = null;
		
		S2 = S1;
		System.out.println("S2 is " + S2);  
		

		S1.append(" there Java maestros!");
		System.out.println("S1 is " + S1);  

		System.out.println("S2 is " + S2);

		S1 = null;  

		
		S2.append(" This is ok");
		System.out.println("S1 is " + S1);  

		System.out.println("S2 is " + S2);
	}
}
