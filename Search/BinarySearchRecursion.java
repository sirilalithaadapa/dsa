import java.util.Scanner;

class BinarySearchRecursion {
    public static int search(int[] nums, int lb, int ub, int key) {
        if (lb > ub) {
            return -1;
        }

        int mid = lb + (ub - lb) / 2;

        if (nums[mid] == key) {
            return mid;
        } else if (nums[mid] < key) {
            return search(nums, mid + 1, ub, key);
        } else {
            return search(nums, lb, mid + 1, key);
        }
    }

    public static int binarySearch(int[] nums, int key) {
        return search(nums, 0, nums.length - 1, key);
    }

    public static void main(String[] args) {
        int a[];   // only a array reference
        int n;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        n = sc.nextInt();

        a = new int[n];

        // Take array input
        System.out.println("Enter values into array:");
        for (int i = 0; i < n; ++i)
        {
            System.out.printf("Enter %d index elem:", i);
            a[i] = sc.nextInt();
        }

        System.out.print("Enter an element to search: ");
        int key = sc.nextInt();

        int position = binarySearch(a, key);

        if (position == -1)
        {
            System.out.println("Key not found :(");
        }
        else {
            System.out.println("Key found at " + (position + 1) + " position");
        }
  }
}
