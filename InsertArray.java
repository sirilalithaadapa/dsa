
import java.util.Scanner;

public class InsertArray
{
	public static void main(String args[])	
	{
		int a[]; // only an array reference
		int n;
		int pos, element;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		n = sc.nextInt();		
		
		a = new int[n+1]; // memory is allocated to the array. here it is a dynamic array

		System.out.println("Enter values into array...");
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();

		System.out.println("Enter the new element to insert & position: ");
		element = sc.nextInt();
		pos = sc.nextInt();

		for(int i=n;i>pos;i--) // shift all the elements towards right
		   a[i] = a[i-1];

		a[pos] = element;// insert the new element

		System.out.println("\n Array after inserting new element:");
		for(int i=0;i<n+1;i++)
		  System.out.print(a[i]+"  ");

	}
}

		








		
				
