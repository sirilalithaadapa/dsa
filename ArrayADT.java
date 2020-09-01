
/* 
Linear search Function will return position if found,
		otherwise it returns -1.
 
Here ADT - Abstract Data type nothing but a class 

*/

public class ArrayADT
{
	public static void main(String args[])
	{
	  int a[] = {23,34,43,54,5,45,65,67,77,66,88,87,76};
	  int position,e;

	  e = Integer.parseInt(args[0]);

	  position = linearSearch(a,a.length,e);

	  if(position==-1)
		System.out.println("No key found");
	  else
		System.out.println("Key found at location:"+position);
	}

	public static int linearSearch(int b[],int n, int key)
	{
		for (int i=0;i<n;i++)
		{
			if(b[i]	== key)
				return i;
		}
		return -1;
	}
}

	   


	
