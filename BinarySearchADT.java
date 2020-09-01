
/* Here we are implementing binary search function which returns the position
upon successful finding otherwise returns -1.
*/

public class BinarySearchADT // Here ADT stands for Abstract data type (ie., class)
{
	public static void main(String args[])
	{
		int a[] = {3,5,7,12,17,23,34,45,56,67,77,89,94};
		int key,position;

		key = Integer.parseInt(args[0]); // search key from command line
		
		position = binarySearch(a,a.length,key);

		if(position == -1)
			System.out.println("Sorry...No key found...");
		else
			System.out.println("Key found at "+position+ "location...");
	}

	public static int binarySearch(int b[],int n,int key)
	{
		int lb, ub, mid;
		
		lb = 0; 
		ub = n-1;

		while(lb<=ub)   // fail means (lb>ub)
		{	
			mid = (lb+ub)/2;
			if(b[mid] == key)
				return mid;
			else
			if(b[mid]<key)	
				lb = mid+1;
			else
				ub = mid-1;
		}
		return -1;
	}
}
		
		
