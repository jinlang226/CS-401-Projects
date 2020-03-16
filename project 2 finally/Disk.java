public class Disk
{
	private int DiskSize;
	private char DiskChar;
	private char PoleChar;

	public Disk(int aDiskSize, char aDiskChar, char aPoleChar)
	{
		DiskSize = aDiskSize;
		DiskChar = aDiskChar;
		PoleChar = aPoleChar;
	}

	public Disk(int aDiskSize)
	{
		DiskSize = aDiskSize;
		DiskChar = '*';
		PoleChar = '|';		
	}

	public int getSize()
	{
		if(DiskSize > 0)
			return DiskSize;
		else
			return 1;
	}

	public String toString()
	{
		String diskString = new String();
		for(int i = 0; i < (DiskSize); i ++)
			diskString = diskString + DiskChar;
		diskString = diskString + PoleChar;
		for(int i = 0; i < (DiskSize); i ++)
			diskString = diskString + DiskChar;
		return diskString;
	}

}