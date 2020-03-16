import java.io.*;
public class File 
{
	public static void main(String args[]) throws IOException
	{
		PrintWriter outputFile = new PrintWriter("StudentData.txt");
		outputFile.println("Jim");
		outputFile.close();
	}
}
