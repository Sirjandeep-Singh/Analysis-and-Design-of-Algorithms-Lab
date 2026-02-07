# Algorithms Design and Analysis — Lab Programs

This repository contains Java implementations of fundamental algorithms with documentation including aim, pseudocode, variables used, logic, time complexity, and space complexity.

---
# LAB 1

## Program 1: Ball Tips Problem (BallTips.java)

### Aim
To calculate the number of times a ball will bounce until its velocity drops below a minimum threshold using recursion.

### Pseudocode

ALGO CountBounces(velocity)
    resistance ← 0.57
    threshold ← 1
    IF velocity < threshold  
        RETURN 0  
    END IF  
    newVelocity ← velocity × resistance  
    RETURN 1 + CountBounces(newVelocity)  

### Variables Used
- velocity — Current velocity of the ball  
- threshold — Minimum velocity limit  
- resistance — Reduction factor  
- count — Stores number of bounces  

### LAB3.Algorithm Explanation
The algorithm recursively reduces velocity after each bounce.  
When velocity becomes less than the threshold, recursion stops.  
Each recursive call contributes one bounce to the final count.

### Time Complexity
O(log n)

### Space Complexity
O(n)

---

## Program 2: Bubble Sort (BubbleSortAlgo.java)

### Aim
To sort an array of integers using the Bubble Sort technique.

### Pseudocode

ALGO BubbleSort(arr, n)  
FOR i ← 0 TO n - 1  
    FOR j ← 0 TO n - i - 2  
        IF arr[j] > arr[j + 1]  
            SWAP arr[j] AND arr[j + 1]  
        END IF  
    END FOR  
END FOR  

### Variables Used
- arr[] — Input array  
- n — Size of array  
- i, j — Loop counters  
- temp — Swap variable

### LAB3.Algorithm Explanation
Adjacent elements are compared and swapped if they are in the wrong order.  
After each pass, the largest element moves to the end of the array.  
This continues until the array becomes sorted.

### Time Complexity
Best Case: O(n²)  
Average Case: O(n²)  
Worst Case: O(n²)

### Space Complexity
O(1)

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/95568fd5-3985-4573-8d59-21df97520bcc" />


---

## Program 3: Early Duplicate Detection (EarlyDupe.java)

### Aim
To detect duplicate elements in an array using early termination with at least half the array as duplicates.

### Pseudocode

ALGO FindDuplicate (arr)
RES ← arr.length / 2 + 1
FOR i ← arr.length/2 TO 1  
    FOR j ← i - 1 TO 1 
        IF arr[i] == arr[j]
              RES ← i
        END IF
    END FOR
END FOR  

### Variables Used
- arr[] — Input array  
- i, j — Loop counters
- RES — Stores the Result of the algorithm.
  
### LAB3.Algorithm Explanation
We know that in the worst case the "arr.length/2 + 1"th index 
will be the duplicate. we use nested for loops in the first half to find 
a duplicate that appears before it.

### Time Complexity  
Worst Case: O(n²)

### Space Complexity
O(1)

---

## Program 4: Polynomial Evaluation Using Horner’s Method (horner.java)

### Aim
To evaluate a polynomial expression efficiently using Horner’s method.

### Pseudocode

ALGO HornerEvaluation(coeff, idx, m, x)  
IF(idx == m + 1) 
    RETURN 0
END IF
RETURN coeff[idx] + x * HornerEvaluation(coeff, idx + 1, m , x)

### Variables Used
- coeff[] — Polynomial coefficients  
- x — Input value  
- idx — tracking recursion stack
- m — number of polynomial coefficients

### LAB3.Algorithm Explanation
Recursion is used to evaluate the polynomial.
At each level of recursion stack we multiply it by constant x.

### Time Complexity
O(n)

### Space Complexity
O(n)

---

## Program 5: Linear Search (LinearSearch.java)

### Aim
To search for a given element in an array using Linear Search.

### Pseudocode

ALGO LinearSearch(arr, n)
FOR i ← 0 TO n - 1  
    IF arr[i] == key  
        PRINT "Element Found"  
        EXIT  
    END IF  
END FOR  

PRINT "Element Not Found"  

### Variables Used
- arr[] — Input array  
- key — Element to search  
- i — Loop counter
- n — size of array

### LAB3.Algorithm Explanation
Each element is checked sequentially.  
The search stops when the element is found or array traversal ends.

### Time Complexity
Best Case: O(1)  
Worst Case: O(n)

### Space Complexity
O(1)

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/a381f6d8-2293-478d-9dba-942c3da27e15" />


---

## Program 6: Missing Number in Consecutive Sequence (nConsecutive.java)

### Aim
To find the missing number from a sequence of consecutive integers without using arithmetic operations.

### Pseudocode

ALGO FindMissing(arr, lowerLimit, upperLimit)  
result ← 0  

FOR each element IN array  
    result ← result ^ element  
END FOR  

FOR i ← lowerLimit to UpperLimit
    result ← result ^ i
END FOR

PRINT result  

### Variables Used
- arr[] — Input array  
- result — Missing number
- LowerLimit/UpperLimit — Limits/Boundaries of the n consecutive numbers

### LAB3.Algorithm Explanation
XOR operation cancels matching values.  
The remaining value represents the missing number.

### Time Complexity
O(n)

### Space Complexity
O(1)

---

## Program 7: Power Calculation Using Recursion (power.java)

### Aim
To compute the power of a number using recursion.

### Pseudocode

### Method 1
ALGO Power(base, exponent)  
IF exponent == 0  
    RETURN 1  
END IF  

temp ← Power(base, exponent/2)
IF(exponent % 2 != 0)
    RETURN temp * temp * base
ELSE
    RETURN temp * temp
END IF

### Method 2
ALGO Power(base, exponent)
IF exponent == 0  
    RETURN 1  
END IF  

RETURN base × Power(base, exponent - 1)  


### Variables Used
- base — Base number  
- exponent — Power value
- temp — Store the value of a calculation temporarily

### LAB3.Algorithm Explanation
The base is multiplied recursively.  
Each recursive call reduces the exponent until base case condition is met.

### Time Complexity
## 1
O(logn)
## 2
O(n)

### Space Complexity
## 1
O(logn)
## 2
O(n)

---

## Program 8: Selection Sort (selectionSortAlgo.java)

### Aim
To sort an array using Selection Sort algorithm.

### Pseudocode

ALGO SelectionSort(arr, n)
FOR i ← 0 TO n - 2  
    minIndex ← i  
    FOR j ← i + 1 TO n - 1  
        IF arr[j] < arr[minIndex]  
            minIndex ← j  
        END IF  
    END FOR  
    SWAP arr[i] AND arr[minIndex]  
END FOR  

### Variables Used
- arr[] — Input array  
- minIndex — Index of minimum element  
- i, j — Loop counters
- n — size of array

### LAB3.Algorithm Explanation
The smallest element is selected and placed at the correct position.  
This process continues until the array becomes sorted.

### Time Complexity
O(n²)

### Space Complexity
O(1)

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/0543fbe9-722e-44fa-94ca-6fb12b356abd" />


---

## Program 9: String Permutation (StringPerm.java)

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

### LAB3.Algorithm Explanation
One character is fixed at a time.  
Remaining characters are permuted recursively.

### Time Complexity
O(n!)

### Space Complexity
O(n)

---

## Program 10: Towers of Hanoi (TowersOfHanoi.java)

### Aim
To solve the Towers of Hanoi problem using recursion.

### Pseudocode

ALGO TowersOfHanoi(n , source, auxiliary, destination)  
IF n == 1  
    PRINT move disk from source to destination  
    RETURN  
END IF  

CALL TowersOfHanoi(n - 1, source, destination, auxiliary)  
CALL TowersOfHanoi(1, source, auxiliary, destination)
CALL TowersOfHanoi(n - 1, auxiliary, source, destination)  

### Variables Used
- n — Number of disks  
- source — Source rod  
- auxiliary — Helper rod  
- destination — Target rod  

### LAB3.Algorithm Explanation
The problem is divided recursively into smaller subproblems.  
Disks are moved step by step until all reach the destination rod.



### Time Complexity
O(2ⁿ)

### Space Complexity
O(n)

---
# LAB 2

---

## Program 1: Insertion Sort(InsSort.java)

### Aim
To sort a given array of integers using the Insertion Sort algorithm and analyze its performance for different input sizes.

### Pseudocode

ALGO InsertionSort  
FOR i ← 1 TO n - 1  
    key ← arr[i]  
    j ← i - 1  
    WHILE j ≥ 0 AND arr[j] > key  
        arr[j + 1] ← arr[j]  
        j ← j - 1  
    END WHILE  
    arr[j + 1] ← key  
END FOR  

### Variables Used
- arr[] — Input array  
- n — Size of array  
- i — Outer loop counter  
- j — Inner loop counter  
- key — Element to be inserted  

### LAB3.Algorithm Explanation
Insertion Sort works by dividing the array into sorted and unsorted parts.  
Each element from the unsorted part is picked and placed at the correct position in the sorted part.  
This process continues until the entire array becomes sorted.

### Time Complexity
- Best Case: **O(n)**  
- Average Case: **O(n²)**  
- Worst Case: **O(n²)**  

### Space Complexity
- **O(1)** — In-place sorting algorithm  

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/4d07b890-80a2-475a-a5b5-1ff34e04facd" />

---

## Program 2: Binary Search(BinSearch.java)

### Aim
To search for a given element in a sorted array using the Binary Search algorithm and analyze its performance.

### Pseudocode

ALGO RecursiveBinarySearch(arr, low, high, key)  
IF low > high  
    RETURN "Not Found"  
END IF  

mid ← (low + high) / 2  

IF arr[mid] == key  
    RETURN "Found"  
ELSE IF arr[mid] < key  
    RETURN RecursiveBinarySearch(arr, mid + 1, high, key)  
ELSE  
    RETURN RecursiveBinarySearch(arr, low, mid - 1, key)  
END IF  


### Variables Used
- arr[] — Sorted input array  
- key — Element to search  
- low — Starting index, always starts with 0
- high — Ending index, always starts with 'n - 1' i.e. the last index.
- mid — Middle index  

### LAB3.Algorithm Explanation
Binary Search works by repeatedly dividing the search interval in half.  
The middle element is compared with the search key.  
Based on comparison, the search space is reduced to either left or right half.  
This continues until the element is found or the search space becomes empty.

### Time Complexity
- Best Case: **O(1)**  
- Average Case: **O(log n)**  
- Worst Case: **O(log n)**  

### Space Complexity
- **O(log n)** — Recursion stack  

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/0630ff44-e203-416e-ab1e-8afc7baadf99" />

---

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
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/42d71fe9-a122-480f-8eb1-f810184947d6" />


---


