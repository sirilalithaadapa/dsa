import java.util.Scanner;

public class MergeSortADT
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
		
		mergepass(a,0,n-1); // calling sorting function

		System.out.println("\n After sorting...");
		display(a,n);
	}

	public static void mergepass(int a[], int lb,int ub)// divide the list into 2 sublists
	{
		int mid;
		if(lb!=ub)// if(a.length!=1)
		{
			mid = (lb+ub)/2;
			mergepass(a,lb,mid); // divide further left sublist
			mergepass(a,mid+1,ub); // divide further right sublist
			mergeSort(a,lb,mid,ub);
		}
	}

	public static void mergeSort(int a[], int lb,int mid,int ub)
	{
		int i; // indicates the starting position of left sublist
		int j; // indicates the starting position of right sublist
		int k; // index of temp array (third list)
		int temp[];
		temp = new int[20];
	
		i = lb;
		j = mid+1;
		k = lb;
		while((i<=mid) && (j<=ub))// as long as there are elements in both sublists, we do merge -->repeat the loop
		{
			if(a[i] <= a[j])
			{
				temp[k] = a[i];
				k++; i++;
			}
			else
			{
				temp[k] = a[j];
				k++; j++;
			}		
		} // MERGE
		
		while(i<=mid) // case 2, dumping remaining elements in the sublist1
		{
			temp[k] = a[i];
			k++; i++;
		}	
		while(j<=ub)// case 3, dumping remaining elements in the sublist 2
		{
			temp[k] = a[j];
			k++; j++;		
		}
		for(i=lb;i<=ub;i++) 	// post all the elements from temp to back orginial array 'a'
			a[i] = temp[i];
	}

	public static void display(int a[],int n)
	{
		for(int i=0;i<n;i++)
		 System.out.print(a[i]+"   ");
	}
}
