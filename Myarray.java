
/*
	System.in ---> Keyboard
	System.out---> Monitor	n = int(input())
	class --> a collection of data & methods(or Functions)

	In case of class --> The first letter will be CAPITAL LETTER
	In cas of method --> The name of the method, leave first word, from second words onwards
			     the first letter of every word is CAPITAL. 

		EX:   String, Integer, StringBuffer, Socket, ServerSocket --> classes
			nextInt(), equalsIgnoreCase(), toString(), parseInt(), compareTo() --> Functions
 The following program handles an array with n elements
*/

import java.util.Scanner;

public class Myarray
{
	public static void main(String args[])	
	{
		int a[]; // only an array reference
		int n;
		int small, big;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		n = sc.nextInt();		
		
		a = new int[n]; // memory is allocated to the array. here it is a dynamic array

		System.out.println("Enter values into array...");
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();

		System.out.println("The array values are...");
		for(int i=0;i<n;i++)
		  System.out.print(a[i]+"  ");


		small = big =  a[0];

		for(int i=1;i<n;i++)
		{
			if(small > a[i])
				small = a[i];

			if(big < a[i])
				big = a[i];
		}		

		System.out.println("Small = "+small);
		System.out.println("Big = "+ big);
	}
}

		








		
				
