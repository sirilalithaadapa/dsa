
import java.util.Scanner;

public class SelectionSortADT
{
	public static void main(String args[])
	{
		int a[]; // array reference

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int n = sc.nextInt();

		a = new int[n]; // dynamic memory allocation in java for array

		System.out.println("Enter the array elements");		
		for(int i=0;i<n;i++)
		   a[i] = sc.nextInt();

		System.out.println("\n Before sorting...");
		display(a,n);
		
		selectionSort(a,n); // calling sorting function

		System.out.println("\n After sorting...");
		display(a,n);
	}

	public static void selectionSort(int a[], int n)
	{
		int i,j,temp,min;

		for(i=0;i<n;i++)
		{
			min = i;
			for(j=i+1;j<n;j++) // inner loop for finding minimum element
			{
			  if(a[min] > a[j])
				min = j;
			}
			if(min!=i) // to perform swapping
			{
			   temp = a[min]; a[min] = a[i]; a[i] = temp;	
			}
		}	
	}
	public static void display(int a[],int n)
	{
		for(int i=0;i<n;i++)
		 System.out.print(a[i]+"   ");
	}
}
