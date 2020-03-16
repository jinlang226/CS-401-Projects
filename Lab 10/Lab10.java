// CS 0401 Spring 2019
// Lab 10
// You must modify this file so that it works as described in the lab handout.
import java.util.*;
import java.io.*;
public class Lab10
{
	public static void main(String[] args) throws IOException
	{
		boolean conti = true;
		
		while(conti)
		{
			Scanner inScan, fScan = null;
			int[] A = new int[5];
			inScan = new Scanner(System.in);
			System.out.println("Please enter the file to read from: ");
			String fName = inScan.nextLine();
			
			try
			{
				fScan = new Scanner(new File(fName));
				String nextItem;
				int nextInt = 0;
				int i = 0;
				
				while (fScan.hasNextLine())
				{
					nextItem = fScan.nextLine();
					try
					{
						nextInt = Integer.parseInt(nextItem);
						A[i] = nextInt;
						i++;
					}
					catch (NumberFormatException e)
					{
						System.out.println(nextItem + " is not an integer -- ignored");
					}
					catch (ArrayIndexOutOfBoundsException e2)
					{
						//resize the array to twice the previous size, 
						//copying the data into the larger array. Then add the new item to the array. 
						//Also, print out a brief message indicating the resizing has been done.
						int size = A.length;
						int size2 = A.length*2;
						int[] B = A;
						A = new int[size2];
						for(int j = 0; j < B.length; j++)
						{
							A[j] = B[j];
						}
						System.out.println("Resizing array from " + size + " to " + size2);
						nextInt = Integer.parseInt(nextItem);
						A[i] = nextInt;
						i++;
					}
				}

				System.out.println("Here are your " + i + " items:");
				for (int j = 0; j < i; j++)
				{
					System.out.println(A[j] + " ");
				}
				conti = false;
				fScan.close();
			}
			
			catch (IOException e1)
			{
				System.out.println("Your file is invalid -- please re-enter");
			}
		}
	}
}
