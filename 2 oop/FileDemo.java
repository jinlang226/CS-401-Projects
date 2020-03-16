import java.io.*;
import java.util.*;

public class FileDemo
{
	public static void main(String[] args) throws IOException
	{
		File aFile = new File("courseList.txt");
		Scanner fileScanner = new Scanner(aFile);

		int numCourses = Integer.parseInt(fileScanner.nextLine());

		Course[] setOfCourses;
		setOfCourses = new Course[numCourses];

		for(int i = 0; i < numCourses; i++)
		{
			String line = fileScanner.nextLine();
			String[] lines = line.split(",");
			setOfCourses[i] = new Course(lines[0], lines[1], Integer.parseInt(lines[2]));

		}
		System.out.println(setOfCourses[5])
	

		int[] x;
		//array in java is an object
		x = new int[10];



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