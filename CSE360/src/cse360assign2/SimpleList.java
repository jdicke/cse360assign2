/*
 * @author Joseph Dicke
 * 169
 * https://github.com/jdicke/cse360assign2/tree/master/CSE360/src/cse360assign2
 * Assignment #1 - This file contains the methods SimpleList(), add(int),
 * remove(), count(), toString(), and search(int num) which are all used
 * to do certain things with an int array of length 10.
 * 
 * 	SimpleList() - This is the constructor and creates a list of size 10 
 * 		and sets the count to 0
 * 	add(int) - This method adds a number to the beginning of the list 
 * 		and shifts everything over to the right
 * 	remove(int) - This method removes a number from the list if it is in 
 * 		the list and shifts everything from
 * 		that point to the left so there are no spaces
 * 	int count() - returns the count of numbers in the list
 * 	String toString() - Returns a string with all of the numbers in the list
 * 	int search(num) - This method returns the index of a number in the list. 
 * 		If the number is not in the list it will return -1.
 *  int first() - Returns the first element in the list
 *  int size() - Returns the current number of possible locations in the list
 *  void append(int) - Appends an integer to the end of the list and if 
 *  	the list is full will increase the size by 50% so there will be room
 *  	and also increments the count.
 */

package cse360assign2;

public class SimpleList {

	private int [] list;
	private int count;
	private int SIZE;
	
	/**
	 * Class constructor initializes list to a int array of size 10. It also
	 * sets the count int variable to 0.
	 */
	public SimpleList()
	{
		SIZE = 9;
		list = new int[SIZE];
		count = 0;
	}
	
	/**
	 * This method adds an integer at the beginning of the int array. It will also
	 * shift the rest of the integers, if any, in the list to the right.
	 * If the list is full it will increase the size by 50% so there will be room.
	 *
	 * @param  num  an integer to add to the list
	 */
	public void add(int num)
	{
		if (count == SIZE)
		{
			// List is full so expand the list by 50% first
			int [] temp_list = new int[SIZE];
			
			for ( int iterator = 0; iterator < SIZE; iterator++ )
			{
				temp_list[ iterator ] = list[ iterator ];
			}
			
			int OLD_SIZE = SIZE;
			SIZE = ( int ) ( SIZE + ( SIZE*0.5 ) );
			
			list = new int[ SIZE ];
			
			for ( int iterator = 0; iterator < OLD_SIZE; iterator++ )
			{
				list[ iterator ] = temp_list[ iterator ];
			}
		}
		count++;
		int previousValue = list[ 0 ];
		
		for (int iterator = 1; iterator < SIZE; iterator++)
		{
			int temp = previousValue;
			previousValue = list [ iterator ];
			list[ iterator ] = temp;
		}
		list[0] = num;
	}
	
	/**
	 * This method removes an integer from the list if it exists. If it does exist then
	 * it will remove it and shift the rest of the integers after that number to the left.
	 * If the list has more than 25% empty places, then the size of the list decreases.
	 *
	 * @param  num  an integer to remove from the list
	 */
	public void remove(int num)
	{
		// Check if the list has more than 25% empty places
		if ( ( double ) ( ( double ) size() / ( double ) SIZE ) > 0.25 )
		{
			int [] temp_list = new int[ SIZE ];
			
			for ( int iterator = 0; iterator < SIZE; iterator++ )
			{
				temp_list[ iterator ] = list[ iterator ];
			}
			
			SIZE--;
			
			list = new int[ SIZE ];
			
			for ( int iterator = 0; iterator < SIZE; iterator++ )
			{
				list[ iterator ] = temp_list[ iterator ];
			}	
		}
		
		int index = 0, innerCounter = 0;
		boolean found = false;
		int[] temp = new int [ SIZE ] ;
		
		for (int iterator = 0; iterator < SIZE; iterator++)
		{
			if ( list[ iterator ] == num && ( !found ) )
			{
				count--;
				found = true;
			} else
			{
				temp[ innerCounter ] = list [ iterator ];
				innerCounter++;
			}	
		}
		list = temp;
	}
	
	/**
	 * This method will always return the amount of integers in the list.
	 *
	 * return  count  the amount of integers in the list
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * This method always returns the numbers in the list in string format with
	 * one space following every number except for the last number.
	 *
	 * return  string  of the numbers in the list followed by one space
	 */
	public String toString()
	{
		String result = "";
		
		if (count > 0) 
		{
			for (int iterator = 0; iterator < SIZE; iterator++)
			{
				if ( list [iterator] != 0)
				{
					result += " " + list[iterator];
				}
			}
		}
		
		return result.trim();
	}
	
	/**
	 * This method will search for a number in the list and will return the index
	 * of that number if the list contains this number. If the list does not contain this
	 * number then it will return -1.
	 *
	 * @param  num  an integer to search for in the list
	 */
	public int search(int num)
	{
		int index = -1;
		
		for (int iterator = 0; iterator < SIZE; iterator++)
		{
			if (list[iterator] == num)
			{
				index = iterator;
				break;
			}
		}
		return index;
	}
	
	/**
	 * This method appends an integer to the end of the list.
	 * If the list is full it will increase the size by 50% so there will be room.
	 *
	 * @param  num  an integer to append to the list
	 */
	public void append(int num)
	{
		if (count == SIZE)
		{
			// List is full so expand the list by 50% first
			int [] temp_list = new int[SIZE];
			
			for ( int iterator = 0; iterator < SIZE; iterator++ )
			{
				temp_list[ iterator ] = list[ iterator ];
			}
			
			int OLD_SIZE = SIZE;
			SIZE = ( int ) ( SIZE + ( SIZE*0.5 ) );
			
			list = new int[ SIZE ];
			
			for ( int iterator = 0; iterator < OLD_SIZE; iterator++ )
			{
				list[ iterator ] = temp_list[ iterator ];
			}
		}
		count++;
		int positionToEnter = 0;
		
		for (int iterator = 0; iterator < SIZE; iterator++ )
		{
			if ( list [ iterator ] == 0 )
			{
				positionToEnter = iterator;
				list[ positionToEnter ] = num;
				break;
			}
		}
	}
	
	/**
	 * This method will return the first element in the list.
	 *
	 * @param  none
	 */
	public int first()
	{
		return list[0];
	}
	
	/**
	 * This method will return the last element in the list.
	 * If the list is empty then it will return -1.
	 * 
	 * @param  none
	 */
	public int last()
	{
		if (count > 0)
		{
			return list[ count - 1 ];
		} else {
			return -1;
		}
		
	}
	
	/**
	 * This method return the current number of possible locations
	 * in the list
	 *
	 * @param  none
	 */
	public int size()
	{
		int amountOfPossibleLocations = 0;
		for ( int iterator = 0; iterator < SIZE; iterator++ )
		{
			if ( list [ iterator ] == 0 )
			{
				amountOfPossibleLocations++;
			}
		}
		return amountOfPossibleLocations;
	}
}
