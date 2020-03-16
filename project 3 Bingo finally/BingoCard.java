import java.util.*;
public class BingoCard
{
	private BingoNumber numbers[][];
	private BingoNumber oldNumbers[][];

	public BingoCard()
	{
		numbers = new BingoNumber[5][5];
		oldNumbers = new BingoNumber[5][5];
		Random rand = new Random();
		ArrayList<Integer> used = new ArrayList<Integer>();

		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(j == 0)
				{
					int rNumber = rand.nextInt(14)+1;
					while(used.contains(rNumber))
					{
						rNumber = rand.nextInt(14)+1;
					}
					used.add(rNumber);
					numbers[i][j] = new BingoNumber(rNumber);
					oldNumbers[i][j] = new BingoNumber(rNumber);
				}

				if(j == 1)
				{
					int rNumber = rand.nextInt(14)+16;
					while(used.contains(rNumber))
					{
						rNumber = rand.nextInt(14)+16;
					}
					used.add(rNumber);
					numbers[i][j] = new BingoNumber(rNumber);
					oldNumbers[i][j] = new BingoNumber(rNumber);
				}

				if(j == 2)
				{
					int rNumber = rand.nextInt(14)+31;
					while(used.contains(rNumber))
					{
						rNumber = rand.nextInt(14)+31;
					}
					used.add(rNumber);
					numbers[i][j] = new BingoNumber(rNumber);
					oldNumbers[i][j] = new BingoNumber(rNumber);
				}

				if(j == 3)
				{
					int rNumber = rand.nextInt(14)+46;
					while(used.contains(rNumber))
					{
						rNumber = rand.nextInt(14)+46;
					}
					used.add(rNumber);
					numbers[i][j] = new BingoNumber(rNumber);
					oldNumbers[i][j] = new BingoNumber(rNumber);
				}

				if(j == 4)
				{
					int rNumber = rand.nextInt(14)+61;
					while(used.contains(rNumber))
						rNumber = rand.nextInt(14)+61;
					used.add(rNumber);
					numbers[i][j] = new BingoNumber(rNumber);
					oldNumbers[i][j] = new BingoNumber(rNumber);
				}
			}
		}
		numbers[2][2].mark();
		oldNumbers[2][2].mark();
	}

	public String toString()
	{
		String output 	= "  B  I  N  G  O \n";
		String signs 	= "+--+--+--+--+--+\n";
		output += signs;

		for(int i = 0; i < 5; i++)
		{
			output += "|";
			for(int j = 0; j < 5; j++)
			{		
				if(numbers[i][j].getNumber() < 10 && !numbers[i][j].isMarked())
					output += " ";
				output += numbers[i][j].toString();
				output += "|";
			}
			output += '\n' + signs;
		}
		return output;
	}

	public String toString(BingoNumber[][] numbs)
	{
		String output = "  B  I  N  G  O\n";
		String signs = "+--+--+--+--+--+\n";
		output += signs;

		for(int i = 0; i < 5; i++)
		{
			output += "|";
			for(int j = 0; j < 5; j++)
			{		
				if(numbs[i][j].getNumber() < 10 && !numbs[i][j].isMarked())
					output += " ";
				output += numbs[i][j].toString();
				output += "|";
			}
			output += '\n' + signs;
		}
		return output;
	}

	public BingoNumber getNumber(int row, int column)
	{
		// returns the reference to the BingoNumber object at a given row and a given column.
		return numbers[row][column];	
	}

	public String toSideBySideString()
	{
		// returns the string representation of the Bingo card side-by-side, one with marks, and one without. 
		// This string allows the host to verify whether a player actually wins.
		
		String combine = "";
		String[] splitOutput = this.toString().split("\n");
		String[] oldBoardOutput = this.toString(oldNumbers).split("\n");
		for(int i = 0; i < 12; i++)
		{
			combine += splitOutput[i] + "  " + oldBoardOutput[i] + "\n";
		} 	
		return combine;
	}

	public boolean mark(int number)
	{
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{		
				if(numbers[i][j].getNumber() == number)
				{
					numbers[i][j].mark();
					return true;
				}
			}
		}
		return false;
	}
}