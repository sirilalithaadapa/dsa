import java.util.*;

public class QuickSortADT
{
	public static void main(String args[])
	{	
		Scanner sc = new Scanner(System.in);
		int n; 			// n is number of elements
		int a[],i;		// array reference

		System.out.println("Enter the size");
		n = sc.nextInt();

		a = new int[n];	// dynamic memory allocation for array 'a'

		System.out.println("Enter elements..."); // input the array
		for(i=0;i<n;i++)
		  a[i] = sc.nextInt();
	
		System.out.println("Before Sorting....");
		for(i=0;i<n;i++)
		System.out.print(a[i]+"  ");

		quickSort(a,0,n-1);
	
		System.out.println("\nAfter Sorting....");
		for(i=0;i<n;i++)
		System.out.print(a[i]+"  ");
		
	}	
	public static void quickSort(int a[], int left, int right)
	{
		int pivot, l,u,temp;

		l= left;
		u = right;
		pivot = left; // pivot or key starts always from leftmost item

		while(left!=right)
		{
			while((a[right] >= a[pivot] ) && (left!=right)) // R to L
			right--;

			if(left!=right)	// swap
			{
				temp = a[pivot];
				a[pivot] = a[right];
				a[right] = temp;
	
				pivot = right; // change the pos of pivot
			}
		
			while(( a[left]<=a[pivot] ) && (left!=right))// L to R
			left++;
		
			if(left!=right)	// swap
			{
				temp = a[pivot];
				a[pivot] = a[left];
				a[left] = temp;
		
				pivot = left; // change the pos of pivot
			}
		} 
	
		if(l<pivot) 	// apply quicksort if left sublist exists
		 quickSort(a,l,pivot-1);

		if(pivot<u)	//apply quicksort if right sublist exists
	 	 quickSort(a,pivot+1,u);
	}
}