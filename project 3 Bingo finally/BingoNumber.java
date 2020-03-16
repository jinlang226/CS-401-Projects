public class BingoNumber
{
	private int number;
	private boolean marked;

	public BingoNumber(int aNumber)
	{
		number = aNumber;
		marked = false;
	}

	public int getNumber()
	{
		return number;
	}

	public boolean isMarked()
	{
		if(marked)
			return true;
		else
			return false;
	}

	public String toString()
	{
		// returns a two-digit string presentation of a BingoNumber. 
		// The output string depends on whether the number if marked. 
		// If the number is not marked yet, simply show the number. 
		//However, if the number is marked, the output string will simply be XX.
		if(marked)
		{
			return "XX";
		}
		else
		{
			return "" + number;
		}
	}

	public String toNumberString()
	{
		// return returns a two-digit string representation of a BingoNumber as if it has not been marked yet.
		return "" + number;
	}

	public void mark()
	{
		// return Note that once the number is marked. 
		// It cannot be unmarked because we are not going to supply a method that will let users unmark a Bingo number.
		marked = true;
	}
}