public class Course
{
	private String number;
	private String name;
	private int capacity;

	public Course(String aNumber, String aName, int aCapacity)
	{
		number = aNumber;
		name = aName;
		capacity = aCapacity;
	}

	public String toString()
	{
		return "Course Number:" + number + "\n" + " course Name: " + name + "\n" + "  Capacity: " + capacity;
	}

	public static void mdain(String[] args)
	{
		Course aCourse = new Course("CS0401", "Intermediate Blah..", 200);
		System.out.println(aCourse);
	}
}