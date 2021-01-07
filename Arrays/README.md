# Dynamic Arrays

**Problem** : Might not know maximum size when allocating an array.

**All problems in computer science can be solved by another level of indirection**

Dynamic Array is a Abstract data type with the following operations:

* **Get(i):** returns element at location i
* **Set(i, val):** Sets element i to val
* **PushBack(val):** Adds val to the end
* **Revove(i):** Removes element at location i
* **Size():** the number of elements

## Get(i)
```
if i < 0 or i >= size:
	ERROR : index out of range
return arr[i]
```

## Set(i, val)
```
if i < 0 or i >= size:
	ERROR: index out of range
arr[i] = val
```

## PushBack(val)
```
if size = capacity:
   allocate new_arr[2 X capacity]
   for i from 0 to size - 1:
	new_arr[i] <- arr[i]
   free arr
   arr <- new_arr; capacity <- 2 x capacity
arr[size] <- val
size <- size + 1
```

## Remove(i)
```
if i < 0 or i >= size:
   ERROR: index out of range
for j from i to size - 2
   arr[j] <- arr[j + 1]
size <- size - 1
```

## size()
```
return size
```

# Runtime:
* Get(i): O(1)
* Set(i, val): O(1)
* PushBack(val): O(n)  => often constant, but can take O(n)
* Remove(i): O(n)
* size(): O(1)
