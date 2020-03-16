public class Course
{

	public static void main(String[] args)
	{
		Course aCourse = new Course("CS0401", "Intermediate Blah..", 200);
		System.out.println(aCourse);
		System.out.println(aCourse.getCourseNumber());
		System,out.println(aCourse.getCourseCapacity());
	}

	
	private String number;
	private String name;
	private int capacity;

	public Course(String aNumber, String aName, int aCapacity)
	{
		number = aNumber;
		name = aName;
		capacity = aCapacity;
	}

	public String getCourseNumber()
	{
		return number;
	}

	public String getCourseName()
	{
		return name;
	}

	public int getCourseCapacity()
	{
		return capacity;
	}

	public String toString()
	{
		return "Course Number:" + number + "\n" + " course Name: " + name + "\n" + "  Capacity: " + capacity;
	}

	
}