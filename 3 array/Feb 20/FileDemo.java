import java.io.*;
import java.util.*;

public class FileDemo
{
	public static void main(String[] args) throws IOException
	{
		File aFile = new File("courseList.txt");
		Scanner fileScanner = new Scanner(aFile);

		//print the whole thing
		while(fileScanner.hasNextLine());
		{
			System.out.println(fileScanner.nextLine());
		}
		
		String s = fileScanner.nextLine();
		System.out.println(s);

		System.out.println(fileScanner.nextLine());

		//difference still have s if I want to
		//but I do not have reference of that string, after print, I lost it
		//whether do you still need that string

		fileScanner.close();

	}
}