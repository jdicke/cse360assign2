/*
 * @author Joseph Dicke
 * 169
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
 */

package cse360assign2;

public class SimpleList {

	private int [] list;
	private int count;
	private final int SIZE = 10;
	
	/**
	 * Class constructor initializes list to a int array of size 10. It also
	 * sets the count int variable to 0.
	 */
	public SimpleList()
	{
		list = new int[SIZE];
		count = 0;
	}
	
	/**
	 * This method adds an integer at the beginning of the int array. It will also
	 * shift the rest of the integers, if any, in the list to the right.
	 *
	 * @param  num  an integer to add to the list
	 */
	public void add(int num)
	{
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
	 *
	 * @param  num  an integer to remove from the list
	 */
	public void remove(int num)
	{
		int index = 0, innerCounter = 0;
		int[] temp = new int [ SIZE ] ;
		
		for (int iterator = 0; iterator < SIZE; iterator++)
		{
			if (list[iterator] != num)
			{
				temp[ innerCounter ] = list [ iterator ];
				innerCounter++;
			} else
			{
				count--;
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
		
		for (int iterator = 0; iterator < SIZE-1; iterator++)
		{
			result += list[iterator] + " ";
		}
		
		result += list[SIZE - 1];
		
		return result;
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
			}
		}
		return index;
	}
}
