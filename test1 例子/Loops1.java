import javax.swing.JOptionPane;
public class Loops1 
{
	public static void main (String args[])
	{
		String input;
		int number;
		
		input = JOptionPane.showInputDialog("Enter a number " + "in the range of 1 through 100.");
		number = Integer.parseInt(input); 
		
		while (number < 1 || number > 100) 
		{
			input = JOptionPane.showInputDialog("Invalid input Enter a number in the range o 1 through 100."); 
			number = Integer.parseInt(input);
		}
		System.exit(0);
	}
}
