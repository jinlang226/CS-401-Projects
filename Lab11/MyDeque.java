package Lab11;

//CS 401 Spring 2019
//MyDeque class to implement a simple deque
//Complete the methods indicated.  Be careful about the
//special cases indicated.  See lab for details on how
//to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;

	public MyDeque(int maxItems)
	{
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
		
		//move object at location 0 to numItems - 1 over one spot to “the right” 
		//(i.e. into location 1 to numItems), 
		//then put the new object into the location 0 and increment numItems. 
		//For example, given the array below of length 9 with 6 items in it, 
		//doing an addFront of 25 will have the effect shown in the three lines below:
		
		if(theData[theData.length-1] == null)
		{
			for(int i = theData.length-1; i > 0; i--)
			{
				theData[i] = theData[i-1];
			}
			theData[0] = X;
			numItems++;
		}
	}

	public void addRear(Object X)
	{
		
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
		
		if(theData[theData.length-1] == null)
		{
			theData[numItems] = X;
			numItems++;
		}
	}

	public Object removeFront()
	{
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
		
		//store the object in location 0 in a temp variable, 
		//then move objects in loca- tion 1 to numItems - 1 over one spot to “the left” 
		//(i.e. to location 0 to numItems - 1). 
		//Set location numItems - 1 to null, decrement numItems and return the temp object. 
		//In effect, you are doing the opposite of what is shown in the addFront above.
		

		if(theData != null && numItems > 0)
		{
			Object X = theData[0];
			for(int i = 1; i <= numItems; i++)
			{
				theData[i-1] = theData[i];
			}
			theData[numItems - 1] = null;
			numItems --;
			return X;
		}
		
		return null;
	}

	public Object removeRear()
	{
		// Remove and return rear item from list.  If list is empty,
		// return null.
		//To remove, we store the last item in a temp object, 
		//decrement numItems and then return the item

		
		if(theData != null && numItems > 0)
		{
			Object X = theData[numItems-1];
			numItems--;
			return X;
		}
		
		return null;
	}
}