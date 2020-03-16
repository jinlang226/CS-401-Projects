import java.util.*;
import java.io.*;

public class Temp2 
{
	public static void foo() throws FileNotFoundException
	{
		bar();
	}
	
	public static void bar() throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("Temp.txt"));
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		foo();
	}
}
