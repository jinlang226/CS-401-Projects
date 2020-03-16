public class Lab08
{
    public static void reverse(int[] data)
    {
        recursive_reverse(data, 0, data.length - 1);
    }
     
    public static void recursive_reverse(int[] data, int firstIndex, int lastIndex)
    {
    	if(lastIndex <= firstIndex)
    	{
    		return;
    	}
    	
    	int x = data[firstIndex];
    	data[firstIndex] = data[lastIndex];
    	data[lastIndex] = x; 
    	recursive_reverse(data, firstIndex+1, lastIndex-1);
    }
    
    public static void showIntArray(int[] data)
    {
    	System.out.print("[");
    	for(int x = 0; x < data.length-1; x++)
    	{
    		System.out.print(data[x] + ",");
    	}
    	System.out.print(data[data.length-1]);
    	System.out.print("] \n");
    }
    
    public static void main(String[] args)
    {
        int[] myData = {12, 5, 7, 2, 6, 32, 1, 9, 44};
        showIntArray(myData);
        reverse(myData);
        showIntArray(myData);
    } 
}
