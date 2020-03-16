public class Polygon
{
	private int[] xpoints;
	private int[] ypoints;
	private int npoints;

	public Polygon(int[] xs, int[] ys, int numPoints)
	{
		xpoints = xs;
		ypoints = yes;
		npoints = numPoints;
	}
	public String toString()
	{
		String result = "";
		for(int i = 0; i < npoints; i++)
			result = result + "(" xpotints[i] + "," + ypoints[i] + ")";
		return result;
	}
}