# LAB 4

---

## Program 1: Iterative Quick Sort (IterativeQuickSort.java)

### Aim
To sort a given array of integers using **Iterative Quick Sort** (prioritizing smaller sublists).

### Pseudocode

ALGO IterativeQuickSort(arr, n)
CREATE stack
PUSH (1, n)
WHILE stack is not empty
POP (low, high)
IF low < high
pivotIndex ← Partition(arr, low, high)
IF high - pivotIndex > pivotIndex - low
PUSH (pivotIndex + 1, high)
PUSH (low, pivotIndex − 1)
ELSE
PUSH (low, pivotIndex − 1)
PUSH (pivotIndex + 1, high)
END IF
END IF
END WHILE


### Variables Used
- arr[] — Input array
- n — Size of array
- stack — Stores sub-array indices
- low, high — Range of sub-array
- pivotIndex — Final position of pivot

### Algorithm Explanation
Recursive calls in Quick Sort are replaced using an explicit stack.  
The array is partitioned around a pivot element.  
Sub-array indices are pushed onto the stack instead of recursion.  
This avoids recursive overhead while maintaining Quick Sort logic.

### Time Complexity
- Best Case: **O(n log n)**
- Average Case: **O(n log n)**
- Worst Case: **O(n²)**

### Space Complexity
- Average Case: **O(log n)**
- Worst Case: **O(n)**

---

## Program 2: Binary Search for Uneven Subarrays(BinSearchforUneven.java)

### Aim
To search for an element in a sorted array using Binary Search(uneven Subarray division).

### Pseudocode
ALGO BinarySearch(arr, key)
LOW ← 1
HIGH ← arr.length
WHILE LOW <= HIGH
PIVOT ← (LOW + HIGH)/3
IF arr[PIVOT] == key
RETURN PIVOT
ELSE IF arr[PIVOT] < key
LOW ← PIVOT + 1
ELSE
HIGH ← PIVOT - 1
END IF
END LOOP
RETURN -1;


### Variables Used
- arr[] — Sorted input array
- key — Element to search
- low — Starting index
- high — Ending index
- Pivot — Pivot index

### Algorithm Explanation
Binary Search repeatedly divides the search space into one-third and two-third..  
The algorithm terminates when the element is found or the search space becomes empty.

### Time Complexity
- Best Case: **O(1)**
- Average Case: **O(log n)**
- Worst Case: **O(log n)**

### Space Complexity
- **O(1)**

---

## Program 3: String Permutation (StringPermutations.java)

### Aim
To generate all permutations of a given string using recursion.

### Pseudocode

ALGO StringPermutation(string, idx ← 1)
IF idx == length(string)  
PRINT string  
ELSE  
FOR i ← idx TO length(string) - 1
string.swap(i , idx)  
CALL StringPermutation(string, idx + 1)
string.swap(i, idx)
END FOR  
END IF

### Variables Used
- string — Input string
- i — iterator

### Algorithm Explanation
One character is fixed at a time.  
Remaining characters are permuted recursively.

### Time Complexity
O(n!)

### Space Complexity
O(n) - Recursion Stack

---
