public class SongTester
{
	public static void main(String[] args)
	{
		Song aSong = new Song("abc", "3:25", "MJ", "Kid Song");
		System.out.println(aSong);
		System.out.println("length in second: " + aSong.getLength());
	}
}