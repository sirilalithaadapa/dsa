# Sorting

Arranging data in increasing or decreasing order

There are 2 types of sortings:
1. External Sorting

2. Internal Sorting

## External Sorting techniques
These techniques are used in olden days when RAM was not found. The techniques are:
 * Polyphase Merge Sorting
 * Oscillatory Sorting
 * K way Merge sort

## Internal Sorting techniques
These are modren techniques which makes use of RAM and very fast. There are lot of internal sorting techniques some of them are:
 * Bubble Sort
 * Selection sort
 * Insertion sort
 * Shell sort
 * Merge sort
 * Quick sort
 * Counting sort
 * Binary tree sort
 * Heap sort
 * Radix sort
 
 ## Table of Sorting Algorithms:

|    ALGORITHM   | Basic concept   | O  | Ω |
| :------------:  |:---------------:|:---:|:--:|
| Bubble sort    | Swap **adjacent pairs** of elements if they are out of order, effectively **bubbling** larger elements to the right and smaller to left| n^2 | n |
| Selection sort |Find the **smallest** element of the array and swap it with the **first** unsorted element in the array  | n^2  | n^2 |
| Insertion sort | Proceed once through the array from left-to-right, **shifting** elements as necessary to insert each element into its correct place|n^2 | n |
| Shell sort | sorting pairs of elements **far-apart** from eachother, then progressively reducing the gap b/n elements compared| n ^2 | nlogn|
| Merge sort     | Split the full array into sub arrays then **merge** those sub arrays back together in the correct order| nlogn | nlogn |
| Quick sort     | choose a **pivot**, partition the array based on pivot at last pivot is in sorted psoition then recursively apply thus to sub arrays|  O(n^2) | O(n*log n) |


## Bubble sort :

This algorithm is called bubble sort, where large values “bubble” to the right.

### pseudocode 1:

<pre>Repeat n–1 times
     For i from 0 to n–2
        If i'th and i+1'th elements out of order
            Swap them</pre>

##### Time complexity : O(n ^ 2) (Both Best & Worst case scenarios)

* Since we are comparing the i'th and i+1'th element, we only need to go up to n – 2 for i. Then, we swap the two elements if they’re out of order.
* And we can stop after we’ve made n – 1 passes, since we know the largest n–1 elements will have bubbled to the right.
* We have n – 2 steps for the inner loop, and n – 1 loops, so we get n2 – 3n + 2 steps total. But the largest factor, or dominant term, is n2, as n gets larger and larger, so we can say that bubble sort is O(n2).

### pseudocode 2:

Set swap counter to non-zero value
<pre>Repeat until the swap counter is 0:
  Reset swap counter to 0
     Look at each adjacent pair 
     If two adjacent elements are not in order, swap them and add one to the swap counter</pre>


#### Worst-case scenario: 

The array is in reverse order, we have to 'bubble' each of the n elements all the the way across the array, and since we can only fully bubble one element into position per pass, we must do this n times.

##### Time complexity : O(n ^ 2) 

#### Best-case scenario: 

The array is already perfectly sorted, and we make no swaps on the first pass.

##### Time complexity : Ω(1) 

## Selection sort:

* First, we’ll look at each number, and remember the smallest one we’ve seen. Then, we can swap it with the first number in our list, since we know it’s the smallest
* Now we know at least the first element of our list is in the right place, so we can look for the smallest element among the rest, and swap it with the next unsorted element (now the second element)
* We can repeat this over and over, until we have a sorted list.This algorithm is called selection sort

### psuedocode:

<pre>
For i from 0 to n–1
   Find smallest item between i'th item and last item
   Swap smallest item with i'th item
</pre>

#### Worst-case scenario:

We have to iterate over each of the n elements of the array (to fnd the smallest unsorted elemnt ) and we must repeat this process n times, since only one elements gets sorted on each process.

##### Time complexity : O(n ^ 2) 

#### Best-case scenario:

Exactly, the same! There's no way to guarantee the array is sorted until we go through this process for all the elements.

##### Time complexity : Ω(n ^ 2) 

## Insertion sort:

* It is a in-place comparison based sorting algorithm.
* We begin by assuming that a list with one item (position 0) is already sorted. On each pass, one for each item 1 through n−1, the current item is checked against those in the already sorted sublist. As we look back into the already sorted sublist, we shift those items that are greater to the right. When we reach a smaller item or the end of the sublist, the current item can be inserted.

### pseudocode

<pre>
Call the first element of the array sorted
Repeat until all elements are sorted:
     Look at the next unsorted element. Insert into the "Sorted" portion by shifting the requisite number of elements.
</pre>

#### Worst-case scenario:

The array is in reverse order; we have to shift each of the n elements n positions each time we make a insertion.

##### Time complexity : O(n ^ 2)

#### Best-case scenario:

The array is already perfectly sorted, and we simply keep moving the line between "unsorted" and "sorted" as we keep examine each element.

##### Time complexity : Ω(n)


## Shell sort:

* inplace-sorting algorithm
* The method starts by sorting pairs of elements far apart from each other, Then progressively reducing the gap between elements compared.
* By starting with far apart elements. It can move some out of place elements into positions faster than a simple nearest neighbour echange
* Running time of shell sort is heavily dependent on the gap.

### pseudocode:

<pre> 
foreach (gap in gaps)
{
     for (i = gap; i < n; i += 1)
     {
        temp = a[i]
        for (j = i; j >= gap and a[j - gap] > temp; j -= gap)
        {
            a[j] = a[j - gap]
        }
        a[j] = temp
     }
}
</pre>

#### Worst-case scenario:

this case occurs for N equal to a power of two when elements greater and smaller than the median occupy odd and even positions respectively, since they are compared only in the last pass.

##### Time complexity : O(n ^ 2)

#### Best-case scenario:

When array is already sorted.

##### Time complexity : Ω(n log n)

## Counting sort:
Counting sort, it is an integer sorting algorithm, it is based on keys between specific range. It works by counting the number of objects having distinct key values. Then doing some arithmetic to calculate the position of each object in the output sequence.

### psuedocode:

```
count = array of k+1 zeros
for x in input do
    count[key(x)] += 1

total = 0
for i in 0, 1, ... k do
    count[i], total = total, count[i] + total

output = array of the same length as input
for x in input do
    output[count[key(x)]] = x
    count[key(x)] += 1 

return output
```
#### Time complexity : O(n + k)

## Merge Sort :

* In merge sort, the idea of algorithm is to sort smaller arrays and then combine those arrays together ( merge them ) in sorted order.
* Merge sort is based on recursion.

### pseudocode

<pre>
Sort the left half of the array ( assuming n > 1 )
Sort the right half of the array ( assuming n > 1 )
Merge the two halfs together.
</pre>

#### Worst-case scenario:

We have to split n elements up and hen recombine them, effectively doubling the sorted subarrays as we build them up

##### Time complexity : O(n log n)

#### Best-case scenario:

Even the array is sorted, we have to split and recombine it together with this algorithm

##### Time complexity : Ω(n log n)

## Quick sort

* Comparison based sorting algorithm.
* Inplace & Efficient in practice.

### pseudocode:
```
QuickSort(A, l, r):
     if l >= r:
	return
     m <- Partition(A, l, r)
     //A[m] is in the final position}
     QuickSort(A, l, m-1)
     QuickSort(A, m+1, r)
```
#### Partitioning: example

* the pivot is x = A[l]
* move i from l+1 to r maintaining the following invariant:
	* A[k] <= x for all l + 1 < k <= j
	* A[k] > x for all j + 1 <= k <= i

```
Partition(A, l, r)
    x <- A[l]
    j <- l
    for i from l + r to r:
	if A[i] <= x:
	    j <- j + 1
	    swap A[j] and A[i]
	    // A[l + 1..j] <= x, A[j + 1..i] > x
     swap A[l] and A[j]
     return j	 	
```
