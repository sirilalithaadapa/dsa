import java.util.*;
public class RadixSortADT
{
	public static void main(String args[])
	{
		int a[];
		int n,i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of elements..");
		n = sc.nextInt();
	
		a = new int[n]; //  memory allocation for the array 'a'.

		System.out.println("Enter the elements..");
		for(i=0;i<n;i++)
			a[i] = sc.nextInt();

		System.out.println("\n Before sorting....\n");
		for(i=0;i<n;i++)
		 System.out.print(a[i]+"  ");

		radixSort(a,n);
		
		System.out.println("\n After sorting....\n");
		for(i=0;i<n;i++)
		 System.out.print(a[i]+"  ");
	}

	public static void radixSort(int a[],int n)
	{
		int big, count,digit,div;
		int bucket[][]; // 10 buckets
		int b[];	// bucket count-no of elements in each bucket
		int i,j,k,p;

		b = new int[10]; // to hold no of elements in each bucket

		bucket = new int[10][15]; // allocate memory for all 10 buckets

		big = a[0];
		for(i=1;i<n;i++)	// to find the biggest number in the list
		{
			if(big<a[i])		
			  big = a[i];
		}

		count=0;
		while(big>0) // finding no of digits in the biggest number
		{
			big=big/10;
			count++;
		}

		div = 1;
		for(p=1;p<=count;p++) // repeated for number times based on the digitcount
		{
			for(i=0;i<10;i++) // initialize all bucket counts to 0
			b[i] = 0;

			for(i=0;i<n;i++)  // distribution
			{
				digit = (a[i]/div)%10;
				bucket[digit][b[digit]] = a[i]; // Placing the item in the bucket
				b[digit]++; // incrementing the respective bucket count
			}

			i=0;
			for(k=0;k<10;k++) // gather all the elements from all the buckets
			{
				for(j=0;j<b[k];j++)
				  a[i++] = bucket[k][j];
			}
			div = div * 10;					
		}
	}
}
