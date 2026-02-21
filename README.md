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
- `velocity` — Current velocity of the ball
- `threshold` — Minimum velocity limit
- `resistance` — Reduction factor
- `count` — Stores number of bounces

### Algorithm Explanation
The algorithm recursively reduces velocity after each bounce.  
When velocity becomes less than the threshold, recursion stops.  
Each recursive call contributes one bounce to the final count.

### Time Complexity
`O(log n)`

### Space Complexity
`O(n)`

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
- `arr[]` — Input array
- `n` — Size of array
- `i, j` — Loop counters
- `temp` — Swap variable

### Algorithm Explanation
Adjacent elements are compared and swapped if they are in the wrong order.  
After each pass, the largest element moves to the end of the array.  
This continues until the array becomes sorted.

### Time Complexity
- `Best Case: O(n²)`
- `Average Case: O(n²)`
- `Worst Case: O(n²)`

### Space Complexity
`O(1)`

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
- `arr[]` — Input array
- `i, j` — Loop counters
- `RES` — Stores the Result of the algorithm.

### Algorithm Explanation
We know that in the worst case the "arr.length/2 + 1"th index
will be the duplicate. we use nested for loops in the first half to find
a duplicate that appears before it.

### Time Complexity
`Worst Case: O(n²)`

### Space Complexity
`O(1)`

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
- `coeff[]` — Polynomial coefficients
- `x` — Input value
- `idx` — tracking recursion stack
- `m` — number of polynomial coefficients

### Algorithm Explanation
Recursion is used to evaluate the polynomial.
At each level of recursion stack we multiply it by constant x.

### Time Complexity
`O(n)`

### Space Complexity
`O(n)`

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
- `arr[]` — Input array
- `key` — Element to search
- `i` — Loop counter
- `n` — size of array

### Algorithm Explanation
Each element is checked sequentially.  
The search stops when the element is found or array traversal ends.

### Time Complexity
`Best Case: O(1)`  
`Worst Case: O(n)`

### Space Complexity
`O(1)`

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
- `arr[]` — Input array
- `result` — Missing number
- `LowerLimit/UpperLimit` — Limits/Boundaries of the n consecutive numbers

### Algorithm Explanation
XOR operation cancels matching values.  
The remaining value represents the missing number.

### Time Complexity
`O(n)`

### Space Complexity
`O(1)`

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
- `base` — Base number
- `exponent` — Power value
- `temp` — Store the value of a calculation temporarily

### Algorithm Explanation
The base is multiplied recursively.  
Each recursive call reduces the exponent until base case condition is met.

### Time Complexity
1. `Method 1: O(logn)`
2. `Method 2: O(n)`

### Space Complexity
1. `Method 1: O(logn)`
2. `Method2: O(n)`

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
- `arr[]` — Input array
- `minIndex` — Index of minimum element
- `i, j` — Loop counters
- `n` — size of array

### Algorithm Explanation
The smallest element is selected and placed at the correct position.  
This process continues until the array becomes sorted.

### Time Complexity
`O(n²)`

### Space Complexity
`O(1)`

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
- `string` — Input string
- `i` — iterator

### Algorithm Explanation
One character is fixed at a time.  
Remaining characters are permuted recursively.

### Time Complexity
`O(n!)`

### Space Complexity
`O(n)`

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
- `n` — Number of disks
- `source` — Source rod
- `auxiliary` — Helper rod
- `destination` — Target rod

### Algorithm Explanation
The problem is divided recursively into smaller subproblems.  
Disks are moved step by step until all reach the destination rod.



### Time Complexity
`O(2ⁿ)`

### Space Complexity
`O(n)`

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
- `arr[]` — Input array
- `n` — Size of array
- `i` — Outer loop counter
- `j` — Inner loop counter
- `key` — Element to be inserted

### Algorithm Explanation
Insertion Sort works by dividing the array into sorted and unsorted parts.  
Each element from the unsorted part is picked and placed at the correct position in the sorted part.  
This process continues until the entire array becomes sorted.

### Time Complexity
- `Best Case: O(n)`
- `Average Case: O(n²)`
- `Worst Case: O(n²)`

### Space Complexity
- `O(1) — In-place sorting algorithm`

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
- `arr[]` — Sorted input array
- `key` — Element to search
- `low` — Starting index, always starts with 0
- `high` — Ending index, always starts with 'n - 1' i.e. the last index.
- `mid` — Middle index

### Algorithm Explanation
Binary Search works by repeatedly dividing the search interval in half.  
The middle element is compared with the search key.  
Based on comparison, the search space is reduced to either left or right half.  
This continues until the element is found or the search space becomes empty.

### Time Complexity
- `Best Case: O(1)`
- `Average Case: O(log n)`
- `Worst Case: O(log n)`

### Space Complexity
- `O(log n) — Recursion stack`

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
- `arr` — Array to be sorted
- `start` — Starting index of the array
- `end` — Ending index of the array
- `mid` — Middle index used to divide the array
- `tempArr1` — Temporary array for left sub-array
- `tempArr2` — Temporary array for right sub-array
- `i, j` — Index pointers for temporary arrays
- `k` — Index pointer for merged array

### Algorithm Explanation
The array is recursively divided into two halves until single-element sub-arrays are obtained.  
These sub-arrays are then merged in sorted order using temporary arrays.  
Sentinel values are used to simplify the comparison logic during merging.  
This process continues until the entire array is sorted.

### Time Complexity
`O(n log n)`

### Space Complexity
`O(n)`

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
- `arr` — Array to be sorted
- `start` — Starting index of the array
- `end` — Ending index of the array
- `pivot` — Element chosen for partitioning
- `i` — Left pointer for scanning elements
- `j` — Right pointer for scanning elements
- `pivotIndex` — Final position of the pivot

### Algorithm Explanation
Quick Sort selects the first element as the pivot and partitions the array such that elements smaller than the pivot are placed to its left and larger elements to its right.  
The pivot is then placed in its correct sorted position.  
The same process is recursively applied to the left and right sub-arrays.

### Time Complexity
- `Best Case: O(n log n)`
- `Average Case: O(n log n)`
- `Worst Case: O(n²)`

### Space Complexity
- `Average Case: O(log n)`
- `Worst Case: O(n)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/8b5822c3-dc65-4f47-9ba7-a5d3639c2e15" />


---

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

# LAB 5

---

## Program 1: Combination Triangles (CombinationTriangles.java)

### Aim
To compute the total number of possible triangles formed from a given set of points using the combination method.

### Pseudocode
    ALGO Solve(points)
        counter ← 0
        FOR i ← 0 TO n-3
            FOR j ← i+1 TO n-2
                FOR k ← j+1 TO n-1
                    print(points[i],points[j],points[k])
                    counter ← counter + 1
        PRINT counter

### Variables Used
- `points` — 2D array containing coordinates
- `i` — First loop index
- `j` — Second loop index
- `k` — Third loop index
- `idx` — Counter for number of triangles

### Algorithm Explanation
The algorithm uses three nested loops to generate all possible combinations of three distinct points.  
Each unique triplet forms one triangle.  
Total number of triangles formed equals **nC3**.

### Time Complexity
`O(n³)`

### Space Complexity
`O(1)`
---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/3a780ea0-4cfb-4671-8038-2ed9fff0ba19" />

---

## Program 2: Max Min (MaxMin.java)

### Aim
To find the maximum and minimum elements of an array using the Divide and Conquer approach.

### Pseudocode
    ALGO DivideAndConquer(arr, start, end)
        IF start = end
            RETURN {arr[start], arr[start]}
        mid ← (start + end) / 2
    
        left ← DivideAndConquer(arr, start, mid)
        right ← DivideAndConquer(arr, mid+1, end)
    
        max ← MAX(left.max, right.max)
        min ← MIN(left.min, right.min)
    
        RETURN {max, min}

### Variables Used
- `arr` — Input array
- `start` — Starting index
- `end` — Ending index
- `mid` — Middle index
- `left` — Result from left half
- `right` — Result from right half
- `carry` — Final max and min array

### Algorithm Explanation
The array is recursively divided into two halves until single elements are reached.  
Each recursive call returns the maximum and minimum of that segment.  
Final result is obtained by comparing results of left and right halves.

### Time Complexity
`O(n)`

### Space Complexity
`O(log n)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/3a780ea0-4cfb-4671-8038-2ed9fff0ba19" />

---

## Program 3: Fractional Knapsack (Knapsack.java)

### Aim
To maximize profit using the Greedy Fractional Knapsack algorithm based on profit/weight ratio.

### Pseudocode
    ALGO FractionalKnapsack(items, capacity)
        Sort items in descending order of (profit/weight)
        FOR each item
            IF capacity ≥ weight
                Take full item
                capacity ← capacity - weight
            ELSE
                Take fractional part
                BREAK

### Variables Used
- `profit[]` — Profit of items
- `weight[]` — Weight of items
- `ratio[]` — Profit/weight ratio
- `capacity` — Maximum capacity of knapsack
- `totalProfit` — Final maximum profit

### Algorithm Explanation
Items are sorted according to profit-to-weight ratio.  
The algorithm greedily selects items with the highest ratio first.  
If full item cannot be taken, a fractional part is added.

### Time Complexity
`O(n²) - Bubble Sort used, can be optimised to O(nlogn)`

### Space Complexity
`O(1)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/3a780ea0-4cfb-4671-8038-2ed9fff0ba19" />

---

## Program 4: Kth Smallest Element (QuickSelect.java)

### Aim
To find the kth smallest element in an array using QuickSelect.

### Pseudocode
    ALGO QuickSelect(arr, k, start, end)
        IF start > end
            RETURN -1
        pivotIndex ← Partition(arr, start, end)
        IF pivotIndex = k-1
            RETURN arr[pivotIndex]
        ELSE IF pivotIndex < k-1
            RETURN Solve(arr, k, pivotIndex+1, end)
        ELSE
            RETURN Solve(arr, k, start, pivotIndex-1)

### Variables Used
- `arr` — Input array
- `k` — Required smallest element position
- `start` — Starting index
- `end` — Ending index
- `pivotIndex` — Position of pivot after partition

### Algorithm Explanation
The array is partitioned similar to Quick Sort.  
If pivot position equals `k-1`, the element is returned.  
Otherwise recursion continues only in the relevant half.

### Time Complexity
- Best Case: `O(n)`
- Average Case: `O(n)`
- Worst Case: `O(n²)`

### Space Complexity
`O(log n)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/3a780ea0-4cfb-4671-8038-2ed9fff0ba19" />

---

## Program 5: Convex Hull (CovexHull.java)

### Aim
To find the Convex Hull of a set of points using the Quick Hull algorithm based on Divide and Conquer.

### Pseudocode
    ALGO QuickHull(points)
        Find leftmost and rightmost points
        Divide remaining points into two subsets
        Recursively find farthest point from line on the left
        Add extreme points to hull

### Variables Used
- `points` — Set of input points
- `leftMost` — Point with minimum x-coordinate
- `rightMost` — Point with maximum x-coordinate
- `hull` — Set of hull points
- `subsets` — Divided point sets

### Algorithm Explanation
Quick Hull works similar to Quick Sort.  
Extreme boundary points are selected first.  
Remaining points are divided and processed recursively.  
The final boundary points form the convex hull.

### Time Complexity
- Average Case: `O(n log n)`
- Worst Case: `O(n²)`

### Space Complexity
`O(n)`
---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/3a780ea0-4cfb-4671-8038-2ed9fff0ba19" />

---




