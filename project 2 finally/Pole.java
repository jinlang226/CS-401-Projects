import java.util.Arrays;
public class Pole
{
	private Disk[] disks;
	private int numberOfDisks;
	private int maxNumberOfDisk;
	private int maxDiskSize;
	private char poleChar;
	

	public Pole(int aMaxNumberOfDisk, int aMaxDiskSize, char aPoleChar)
	{
		maxNumberOfDisk = aMaxNumberOfDisk;
		maxDiskSize = aMaxDiskSize;
		poleChar = aPoleChar;
		disks = new Disk[maxNumberOfDisk];
		if(maxNumberOfDisk < 1)
			maxNumberOfDisk = 1;
		if(maxDiskSize < 1)
			maxDiskSize = 1;
	}


	public Pole(int aMaxNumberOfDisk, int aMaxDiskSize) 
	{
		maxNumberOfDisk = aMaxNumberOfDisk;
		maxDiskSize = aMaxDiskSize;
		poleChar = '|';
		disks = new Disk[maxNumberOfDisk];
		if(maxNumberOfDisk < 1)
			maxNumberOfDisk = 1;
		if(maxDiskSize < 1)
			maxDiskSize = 1;


		//this(aMaxNumberOfDisk, aMaxDiskSize, "|");
	}


	public Pole(int aMaxNumberOfDisk)
	{
		maxNumberOfDisk = aMaxNumberOfDisk;
		maxDiskSize = aMaxNumberOfDisk;
		poleChar = '|';
		disks = new Disk[maxNumberOfDisk];
		if(maxNumberOfDisk < 1)
			maxNumberOfDisk = 1;
		if(maxDiskSize < 1)
			maxDiskSize = 1;
	}


	public int getMaxNumberOfDisks()
	{
		return maxNumberOfDisk;
	}

	public int getMaxDiskSize()
	{
		return maxDiskSize;
	}

	public int getNumberOfDisks()
	{
		return numberOfDisks;
	}

	public Disk peekTopDisk()
	{
		if(isEmpty())
			return null;
		return disks[numberOfDisks - 1];
	}

	public boolean isEmpty()
	{
		return numberOfDisks == 0;
	}


	public String toString()
	{
		String output = "";
		for(int j = 0; j < maxDiskSize; j++) 
		{
			output += " ";
		}
		output += poleChar;
		for(int j = 0; j < maxDiskSize; j++) 
		{
			output += " ";
		}
		output += "\n";

		for(int i = maxNumberOfDisk - 1; i >= 0; i--) 
		{	
			if(disks[i] == null) 
			{
				for(int j = 0; j < maxDiskSize; j++) 
				{
					output += " ";
				}
				output += poleChar;
				for(int j = 0; j < maxDiskSize; j++) 
				{
					output += " ";
				}		
			} 
			else
			{
				for(int j = 0; j < maxDiskSize - disks[i].getSize(); j++) 
				{
					output += " ";
				}
				output += disks[i].toString();
				for(int j = 0; j < maxDiskSize - disks[i].getSize(); j++) 
				{
					output += " ";
				}
			}
			output += "\n";
		}

		for(int i = 0; i <= ((2 * maxDiskSize)); i++) 
		{
			output += "=";
		}
		
		return output;
	}
	

	public boolean addDisk(Disk aDisk)
	{

		boolean check = false;

		if(numberOfDisks >= maxNumberOfDisk)
		{
			return false;
		}

		else if(aDisk.getSize() > maxDiskSize)
			return false;
		
		else
		{
			if(maxNumberOfDisk == 1)
			{
				disks[0] = aDisk;
				numberOfDisks++;
				check = true;
			}
			else if(maxNumberOfDisk > 1)
			{
				if(disks[0] == null)
				{
					disks[0] = aDisk;
					numberOfDisks ++;
					check = true;
					//System.out.println("disks[0].getSize() " + disks[0].getSize());
					//System.out.println("aDisk.getSize()" + aDisk.getSize());
				}
				else
				{
					for(int i = 1; i < disks.length; i++)
					{
						if(disks[i] == null)
						{						
							disks[i] = aDisk;
							numberOfDisks++;
							check = true;
							//System.out.println("!!!!disks[i].getSize() " + disks[i].getSize());
							//System.out.println("!!!1aDisk.getSize()" + aDisk.getSize());
							break;
						}
						else if(aDisk.getSize() < disks[i].getSize() && disks[i] == null)
						{
							//System.out.println("before disks[i].getSize() " + disks[i].getSize());
							disks[i] = aDisk;
							numberOfDisks++;
							check = true;
							//System.out.println("after disks[i].getSize() " + disks[i].getSize());
							//System.out.println("aDisk.getSize()" + aDisk.getSize());
							break;
						}
						
					}
				}
			}
		}
		return check;
	}

	public Disk removeDisk()
	{
		if(numberOfDisks == 0)
			return null;
		// remove disk 
		// return removed disk
		Disk toRemove = disks[numberOfDisks - 1];
		disks[numberOfDisks - 1] = null;
		numberOfDisks--;
		return toRemove;
	}

	

}