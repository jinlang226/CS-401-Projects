public class TowerOfHanoi
{
	private Pole[] poles;
	private int numberOfDisks;
	private int poleNumber;

	TowerOfHanoi()
	{
		numberOfDisks = 7;
		poleNumber = 3;
		poles = new Pole[poleNumber];
		for(int i = 0; i < poleNumber; i++)
			poles[i] = new Pole(numberOfDisks);
		// Add correct number of disks t the pole
		for(int i = 7; i > 0; i--)
			poles[0].addDisk(new Disk(i));
		
	}

	TowerOfHanoi(int aNumberOfDisks)
	{
		numberOfDisks = aNumberOfDisks;
		poleNumber = 3;
		poles = new Pole[poleNumber];
		for(int i = 0; i < poleNumber; i++)
			poles[i] = new Pole(numberOfDisks);
		if(numberOfDisks < 1)
			numberOfDisks = 1;
		for(int i = numberOfDisks; i > 0; i--)
			poles[0].addDisk(new Disk(i));
	}

	public Disk peekTopDisk(int aPoleNumber)
	{
		poleNumber = aPoleNumber;
		/*
		

		if(poleNumber > 0 && poleNumber < 4)
		{	
			return poles[poleNumber].peekTopDisk();
		}
		else if(poleNumber < 1 || poleNumber > 3)
			return null;
		
		return null;
		*/


		if(aPoleNumber < 1 || aPoleNumber > 3)
		{
			return null;
		}
		else
			return poles[poleNumber-1].peekTopDisk();
		
	}

	public int getNumberOfDisks(int aPoleNumber)
	{
		poleNumber = aPoleNumber;
		if(aPoleNumber < 1 || aPoleNumber > 3)
			return -1;
		else
			return poles[poleNumber-1].getNumberOfDisks();

	}
	
	public String toString()
	{
		String output = "";
		for(int i = 0; i < poles[0].getMaxNumberOfDisks(); i++) 
			output += " ";
		output += "1";
		for(int i = 0; i < poles[0].getMaxNumberOfDisks() * 2 + 1; i++) 
			output += " ";
		output += "2";
		for(int i = 0; i < poles[0].getMaxNumberOfDisks() * 2 + 1; i++) 
			output += " ";
		output += "3\n";

		String[] pole1 = poles[0].toString().split("\n");
		String[] pole2 = poles[1].toString().split("\n");
		String[] pole3 = poles[2].toString().split("\n");

		for(int i = 0; i < poles[0].getMaxNumberOfDisks()+2; i++) 
		{
			if(i == poles[0].getMaxNumberOfDisks()+1)
				output += pole1[i] + "=" + pole2[i] + "=" + pole3[i];
			else 
				output += pole1[i] + " " + pole2[i] + " " + pole3[i] + "\n";
		}

		return output;
	}

	public boolean move(int fromPole, int toPole)
	{
		fromPole -= 1;
		toPole -= 1;
		if((fromPole >= 0 && fromPole <= 2) && (toPole >= 0 && toPole <= 2))
		{
			//  Check if the from pole has disks
			if(poles[fromPole].getNumberOfDisks() != 0)
			{
				//Chcek if toPole is full
				if(poles[toPole].getNumberOfDisks() != poles[toPole].getMaxNumberOfDisks())
				{
					//Check top is sammler than the bottom
					if(poles[toPole].getNumberOfDisks() != 0 && poles[fromPole].peekTopDisk().getSize() < poles[toPole].peekTopDisk().getSize())
					{
						poles[toPole].addDisk(poles[fromPole].removeDisk());
						return true;
					}
					else if(poles[toPole].getNumberOfDisks() == 0)
					{
						poles[toPole].addDisk(poles[fromPole].removeDisk());
						return true;
					}

				}
			}
		}
		return false;
	}

	public void reset()
	{
		poles = new Pole[poleNumber];
		//numberOfDisks = aNumberOfDisks;
		poleNumber = 3;
		for(int i = 0; i < poleNumber; i++)
			poles[i] = new Pole(numberOfDisks);
		if(numberOfDisks < 1)
			numberOfDisks = 1;
		for(int i = numberOfDisks; i > 0; i--)
			poles[0].addDisk(new Disk(i));
	}

	public boolean isWin()
	{
		if(poles[poles.length-1].getNumberOfDisks() == poles[poles.length-1].getMaxNumberOfDisks())
			return true;
		else
			return false;
	}
	/*
	public static void main(String[] args)
	{
		TowerOfHanoi t = new TowerOfHanoi();
		System.out.println(t.peekTopDisk(1));
	}
	*/
}

