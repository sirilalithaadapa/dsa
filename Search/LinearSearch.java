import java.util.Scanner;

public class LinearSearch
{
    public static int linearSearch(int[] a, int key)
    {
        for (int i = 0; i < a.length - 1; ++i)
        {
            if (a[i] == key)
            {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter elements of array:");
        for (int i = 0; i < n; ++i)
        {
        System.out.printf("Enter %d index elem:", i);
        a[i] = sc.nextInt();
        }

        System.out.print("Enter an element to search: ");
        int key = sc.nextInt();
        int pos = linearSearch(a, key);

        if (pos == -1)
        {
            System.out.printf("%d not found :(", key);
        }
        else
        {
            System.out.printf("%d found at location %d", key, pos);
        }

    }
}
