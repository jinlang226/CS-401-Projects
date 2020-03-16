public class tryle
{
	private int DiskSize;
	private char DiskChar;
	private char PoleChar;
	private String diskString = "";

	public tryle(int aDiskSize, char aDiskChar, char aPoleChar)
	{
		DiskSize = aDiskSize;
		DiskChar = aDiskChar;
		PoleChar = aPoleChar;
		//String diskString = DiskChar * （DiskSize / 2） + PoleChar + "*" * （DiskSize / 2);
		for(int i = 0; i < (DiskSize); i ++)
			diskString = diskString + DiskChar;
		diskString = diskString + PoleChar;
		for(int i = 0; i < (DiskSize); i ++)
			diskString = diskString + DiskChar;
		
	}

	public tryle(int aDiskSize)
	{
		DiskSize = aDiskSize;
		DiskChar = '*';
		PoleChar = '|';
		for(int i = 0; i < (DiskSize); i ++)
			diskString = diskString + DiskChar;
		diskString = diskString + PoleChar;
		for(int i = 0; i < (DiskSize); i ++)
			diskString = diskString + DiskChar;

	}

	public int getSize()
	{
		return DiskSize;
	}

	public String toString()
	{
		return diskString;
	}

}