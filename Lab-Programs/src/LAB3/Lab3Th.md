# LAB 3

## Program 1: Merge Sort (MergeSort.java)

### Aim
To sort a given array of integers using the Merge Sort algorithm based on the divide and conquer technique.

### Pseudocode

ALGO MergeSort(arr, start, end)  
IF start ≥ end  
RETURN  
END IF  
mid ← (start + end) / 2  
MergeSort(arr, start, mid)  
MergeSort(arr, mid + 1, end)  
Merge(arr, start, mid, end)

ALGO Merge(arr, start, mid, end)  
tempArr1 = arr[start:mid+1]
tempArr2 = arr[mid+1:end+1]  
tempArr1.append(∞)
tempArr2.append(∞)
Merge elements back into original array in sorted order

### Variables Used
- arr — Array to be sorted
- start — Starting index of the array
- end — Ending index of the array
- mid — Middle index used to divide the array
- tempArr1 — Temporary array for left sub-array
- tempArr2 — Temporary array for right sub-array
- i, j — Index pointers for temporary arrays
- k — Index pointer for merged array

### Algorithm Explanation
The array is recursively divided into two halves until single-element sub-arrays are obtained.  
These sub-arrays are then merged in sorted order using temporary arrays.  
Sentinel values are used to simplify the comparison logic during merging.  
This process continues until the entire array is sorted.

### Time Complexity
O(n log n)

### Space Complexity
O(n)

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/3a780ea0-4cfb-4671-8038-2ed9fff0ba19" />

---

## Program 2: Quick Sort (QuickSort.java)

### Aim
To sort a given array of integers using the Quick Sort algorithm by partitioning the array around a pivot element.

### Pseudocode

ALGO QuickSort(arr, start, end)  
IF start ≥ end  
RETURN  
END IF  
pivotIndex ← Partition(arr, start, end)  
QuickSort(arr, start, pivotIndex - 1)  
QuickSort(arr, pivotIndex + 1, end)

ALGO Partition(arr, start, end)  
pivot ← arr[start]  
i ← start + 1  
j ← end  
WHILE i ≤ j  
WHILE arr[i] ≤ pivot  
i ← i + 1  
END WHILE  
WHILE arr[j] > pivot  
j ← j - 1  
END WHILE  
IF i < j  
swap(arr[i], arr[j])  
END IF  
END WHILE  
swap(arr[start], arr[j])  
RETURN j

### Variables Used
- arr — Array to be sorted
- start — Starting index of the array
- end — Ending index of the array
- pivot — Element chosen for partitioning
- i — Left pointer for scanning elements
- j — Right pointer for scanning elements
- pivotIndex — Final position of the pivot

### Algorithm Explanation
Quick Sort selects the first element as the pivot and partitions the array such that elements smaller than the pivot are placed to its left and larger elements to its right.  
The pivot is then placed in its correct sorted position.  
The same process is recursively applied to the left and right sub-arrays.

### Time Complexity
- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n²)

### Space Complexity
- Average Case: O(log n)
- Worst Case: O(n)

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/2f13aa35-a5fe-43be-a9df-69529de7a798" />


---
