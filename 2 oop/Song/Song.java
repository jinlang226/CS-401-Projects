public class Song 
{
	private String title;
	private String length;
	private String artist;
	private String genra;
	
	public Song(String aTitle, String aLength, String anArtist, String aGenra)
	{
		title = aTitle;
		length = aLength;
		artist = anArtist;
		genra = aGenra;
	}

	public int getLength()
	{
		int result = 0;
		String[] numStrings = length.split(":");
		int first = Integer.parseInt(numStrings[0]);
		int second = Integer.parseInt(numStrings[1]);
		return (first * 60) + second;
	}

	public String toString()
	{
		return "title: " + title + "length: " + length + "artist: " + 
				artist + "genra: " + genra;
	}
}













