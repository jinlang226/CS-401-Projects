import java.util.Random;

public class jin 
{
    public static void main(String[] args) 
    {
        int max=20;
        int min=10;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
        s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
        s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
        s = random.nextInt(max)%(max-min+1) + min;
        System.out.println(s);
    }
}