

# Search Algorithms


|    ALGORITHM   | Basic concept   | O  | Ω |
| :------------:  |:---------------:|:---:|:--:|
| Linear search  | **Iterate** across the array from left-to-right, trying to find the target element | n | 1 |
| Binary search  | Given a sorted array, divide & conquer by systematically eliminating half of the remaining elements in the search for the target element| logn | 1 |


## Linear Search:

* Look at each element, one at a time, from the beginning to the end.
* This is called linear search, where we move in a line, since our array isn’t sorted.
#### Worst-case scenario:

We have to look through the entire array of n elements, either because the target element is the last element of the array or doesn't exist in the array.

##### Time complexity : O(n)

#### Best-case scenario:

The target element is the first element of the array, so we can stop looking immediately after we start.

##### Time complexity : Ω(1)

## Binary Search

* Start in the middle and move left or right depending on what we’re looking for, if our array of items is sorted.
* This is called binary search, since we can divide our problem in half with each step.

#### Worst-case scenario:

We have to divide a list of n elements in half repeatedly to find the target element, either beacause the target element will be found at the end of the last divison or doesn't exist in the array.

##### Time complexity : O(log(n))

#### Best-case scenario:

The target element is at the midpoint of the full array, and so we can stop looking immediately after we start.

##### Time complexity : Ω(1)
