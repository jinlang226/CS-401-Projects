package Lab09;

public class MySquare extends MyRectangle 
{
	public MySquare(int x, int y, int side)
	{
		super(x, y, side, side);
	}
	
	public MySquare()
	{
		int x = 0;
		int y = 0;
		int side = 0;
	}
	
	public String toString()
	{
		StringBuilder S = new StringBuilder();
		S.append("Side: " + width);
		S.append(" X: " + startX);
		S.append(" Y: " + startY);
		return S.toString();
	}
	
	public void setSize(int w, int h)
	{
		if(w != h)
		{
			System.out.println("Sides must be equal. " + w + " != " + h + " so no action taken");
		}
		else
		{
			super.setSize(w, h);
		}
	}
	
	public void setSide(int side)
	{
		setSize(side, side);
	}
}
