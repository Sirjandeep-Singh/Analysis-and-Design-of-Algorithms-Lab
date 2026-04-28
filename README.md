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

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/125f942e-49e1-4795-b0b7-b2d65bc640ea" />

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
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/1aa2ab2b-4923-4d66-8761-22f237f42683" />

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
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/6fe52cca-b3ee-4098-bcb8-ef646e6c0cdf" />

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
`O(nlogn) - Quick Sort Used` 

### Space Complexity
`O(1)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/d5a36abd-a924-46db-84b6-4d41bbc7ae72" />

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
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/38ff467b-43c3-431e-a2f6-f2c445f21472" />

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
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/59c6286d-29f5-4bff-8582-f0590c282faf" />

---

# LAB 6

---

## Program 1: Activity Selection (ActivitySelection.java)

### Aim
To select the maximum number of non-overlapping activities using a greedy approach.

### Pseudocode

    ALGO ActivitySelection(arr)
        SORT activities based on end time
        prevEndTime ← -∞
        totalActivities ← 0

        FOR each activity
            IF startTime ≥ prevEndTime
                totalActivities ← totalActivities + 1
                prevEndTime ← endTime
            END IF
        END FOR

        RETURN totalActivities

### Variables Used
- `arr[][]` — Array containing start and end times
- `prevEndTime` — Stores last selected activity end time
- `totalActivities` — Count of selected activities

### Algorithm Explanation
Activities are sorted based on end time.  
The earliest finishing activity is selected first.  
Next activity is selected only if it starts after or at the end of the last selected activity.  
This ensures maximum number of non-overlapping activities.

### Time Complexity
`O(n log n)`

### Space Complexity
`O(1)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/a22146c5-68e4-43ab-a4ec-ce9d995a26af" />

---

## Program 2: Cycle Detection (CycleDetection.java)

### Aim
To detect a cycle in an undirected graph using Disjoint Set Union (DSU).

### Pseudocode

    ALGO CycleDetection(adjMatrix)
        CREATE DSU of size n

        FOR i ← 0 TO n-1
            FOR j ← i+1 TO n-1
                IF edge exists
                    px ← find(i)
                    py ← find(j)

                    IF px == py
                        RETURN cycle detected
                    END IF

                    UNION(i, j)
                END IF
            END FOR
        END FOR

        RETURN no cycle

### Variables Used
- `adjMatrix[][]` — Graph representation
- `DSU` — Disjoint set structure
- `px, py` — Parent representatives

### Algorithm Explanation
Each edge is checked using DSU.  
If two vertices belong to the same set, adding the edge forms a cycle.  
Otherwise, they are merged using union operation.

### Time Complexity
`O(E α(n))`

### Space Complexity
`O(n)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/5a4b9dd8-b8da-4b72-aef8-5988cb10db67" />

---

## Program 3: Dijkstra Algorithm (DijsktraAlgo.java)

### Aim
To find shortest paths from a source vertex to all other vertices using Dijkstra’s algorithm.

### Pseudocode

    ALGO Dijkstra(adjMatrix, source)
        INITIALIZE distance array with ∞
        distance[source] ← 0

        CREATE priority queue

        WHILE queue not empty
            u ← extract minimum

            FOR each neighbor v
                IF distance[u] + weight(u,v) < distance[v]
                    UPDATE distance[v]
                END IF
            END FOR
        END WHILE

        RETURN distance

### Variables Used
- `adjMatrix[][]` — Graph representation
- `distances[]` — Stores shortest distances
- `visited[]` — Tracks visited nodes
- `priorityQueue` — Custom priority queue

### Algorithm Explanation
The closest unvisited node is selected each time.  
Distances are updated using relaxation.  
Priority queue ensures efficient minimum selection.

### Time Complexity
`O((V + E) log V)`

### Space Complexity
`O(V)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/097b5590-ce30-4db6-8808-0fd4c1fe99b4" />

---

## Program 4: Kruskal Algorithm (Kruskal.java)

### Aim
To find the Minimum Spanning Tree (MST) of a graph using Kruskal’s algorithm.

### Pseudocode

    ALGO Kruskal(adjMatrix)
        CONVERT adjacency matrix to edge list
        SORT edges by weight

        CREATE DSU
        totalWeight ← 0

        FOR each edge (u, v)
            IF find(u) ≠ find(v)
                ADD edge to MST
                UNION(u, v)
                totalWeight ← totalWeight + weight
            END IF
        END FOR

        RETURN totalWeight

### Variables Used
- `edgeList[][]` — List of edges
- `DSU` — Disjoint set structure
- `totalWeight` — MST weight
- `edgesUsed` — Count of edges included

### Algorithm Explanation
Edges are processed in increasing order of weight.  
An edge is added only if it does not form a cycle.  
DSU efficiently detects cycles.

### Time Complexity
`O(E log E)`

### Space Complexity
`O(E)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/497aa872-10d0-48d6-a160-d2e8540f1999" />

---

## Program 5: Prim’s Algorithm (Prims.java)

### Aim
To construct a Minimum Spanning Tree (MST) using Prim’s algorithm.

### Pseudocode

    ALGO Prims(adjMatrix, source)
        INITIALIZE weights[] ← ∞
        weights[source] ← 0

        CREATE priority queue

        WHILE MST not complete
            u ← extract minimum

            FOR each neighbor v
                IF weight(u,v) < weights[v]
                    UPDATE weights[v]
                    SET parent[v] ← u
                END IF
            END FOR
        END WHILE

        RETURN parent array

### Variables Used
- `adjMatrix[][]` — Graph representation
- `weights[]` — Minimum edge weights
- `near[]` — Parent array (MST)
- `connected[]` — Tracks included vertices

### Algorithm Explanation
The algorithm starts from a source vertex.  
At each step, it selects the minimum weight edge connecting MST to a new vertex.  
Priority queue ensures efficient selection.

### Time Complexity
`O((V + E) log V)`

### Space Complexity
`O(V)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/f5be33ad-00b8-452f-b0ef-4dcd68797403" />

---

# LAB 7

---

## Program 1: Multi Stage Graph Traversal (MultiStageGraphBFSTraversal.java)

### Aim
To determine the number of stages in a multi-stage graph using traversal.

### Pseudocode

    ALGO MultiStageTraversal(adjMatrix, source)
        RETURN Traverse(adjMatrix, source, 0)

    ALGO Traverse(adjMatrix, source, stage)
        FOR i ← 0 TO n-1
            IF edge exists from source to i
                stage ← Traverse(adjMatrix, i, stage)
                BREAK
            END IF
        END FOR

        RETURN stage + 1

### Variables Used
- `adjMatrix[][]` — Graph representation
- `source` — Starting vertex
- `stage` — Tracks number of stages

### Algorithm Explanation
The algorithm recursively traverses the graph starting from the source node.  
At each node, it moves to the next connected vertex.  
Traversal continues until no further edges are found.  
Each recursive return increments the stage count, representing levels in the graph.

### Time Complexity
`O(V²)`

### Space Complexity
`O(V)`

---

# LAB 8

---

## Program 1: Multi Stage Graph Shortest Path (Forward Approach) (MSGShortestPath.java)

### Aim
To find the shortest path in a Multi-Stage Graph using the Forward Dynamic Programming approach.

### Pseudocode

    ALGO ForwardMSG(adjMatrix, source)
        INITIALIZE cost[] ← ∞
        cost[lastVertex] ← 0

        FUNCTION Solve(current)
            IF cost[current] ≠ ∞
                RETURN cost[current]

            FOR i ← current+1 TO n-1
                IF edge exists
                    temp ← weight(current,i) + Solve(i)
                    IF temp < cost[current]
                        cost[current] ← temp
                        d[current] ← i
                    END IF
                END IF
            END FOR

            RETURN cost[current]

### Variables Used
- `adjMatrix[][]` — Graph representation
- `cost[]` — Stores minimum cost from vertex to destination
- `d[]` — Stores next vertex in the shortest path
- `current` — Current vertex
- `i` — Loop counter

### Algorithm Explanation
The algorithm starts from the source and recursively computes the shortest path to the destination.  
It explores all forward edges and chooses the path with minimum cumulative cost.  
Memoization is used to avoid recomputation of subproblems.

### Time Complexity
`O(V*d)` - `d` is the maximum out degree of a vertex possible.

### Space Complexity
`O(V)`

---

## Program 2: Multi Stage Graph Shortest Path (Backward Approach) (MSGShortestPath.java)

### Aim
To find the shortest path in a Multi-Stage Graph using the Backward Dynamic Programming approach.

### Pseudocode

    ALGO BackwardMSG(adjMatrix)
        INITIALIZE cost[] ← ∞
        cost[lastVertex] ← 0

        FOR i ← n-2 DOWNTO 0
            FOR j ← i+1 TO n-1
                IF edge exists
                    IF weight(i,j) + cost[j] < cost[i]
                        cost[i] ← weight(i,j) + cost[j]
                        d[i] ← j
                    END IF
                END IF
            END FOR
        END FOR

        RETURN cost[0]

### Variables Used
- `adjMatrix[][]` — Graph representation
- `cost[]` — Stores minimum cost to destination
- `d[]` — Stores next vertex in path
- `i, j` — Loop counters

### Algorithm Explanation
The algorithm starts from the last vertex and moves backward.  
For each vertex, it calculates the minimum cost using already computed future costs.  
This eliminates recursion and builds the solution iteratively.

### Time Complexity
`O(V*d)` - `d` is the maximum out degree of a vertex possible.

### Space Complexity
`O(V)`

---

## Program 3: Matrix Chain Multiplication (MatrixChainMultiplication.java)

### Aim
To determine the most efficient way to multiply a chain of matrices using Dynamic Programming.

### Pseudocode

    ALGO MatrixChainOrder(p[])
        n ← length(p) - 1
        CREATE memo[n][n]
        CREATE s[n][n]

        FOR i ← 0 TO n-1
            memo[i][i] ← 0

        FOR l ← 2 TO n
            FOR i ← 0 TO n-l
                j ← i + l - 1
                memo[i][j] ← ∞

                FOR k ← i TO j-1
                    q ← memo[i][k] + memo[k+1][j] + p[i]*p[k+1]*p[j+1]

                    IF q < memo[i][j]
                        memo[i][j] ← q
                        s[i][j] ← k
                    END IF
                END FOR
            END FOR
        END FOR

        RETURN memo[0][n-1]

### Variables Used
- `p[]` — Array of matrix dimensions
- `memo[][]` — Stores minimum multiplication cost
- `s[][]` — Stores optimal split positions
- `i, j, k` — Loop counters
- `q` — Temporary cost

### Algorithm Explanation
The algorithm uses Dynamic Programming to find the optimal way to parenthesize matrix multiplication.  
It computes minimum cost for smaller chains and builds up to larger chains.  
The cost depends on the number of scalar multiplications required.

### Time Complexity
`O(n³)`

### Space Complexity
`O(n²)`

---

# LAB 9

---

## Program 1: Longest Common Subsequence (LongestCommonSubsequence.java)

### Aim
To find the length of the Longest Common Subsequence (LCS) between two strings using Dynamic Programming.

### Pseudocode

    ALGO LCS(text1, text2)
        n ← length(text1)
        m ← length(text2)
        CREATE memo[n+1][m+1]

        FOR i ← 1 TO n
            FOR j ← 1 TO m
                IF text1[i-1] == text2[j-1]
                    memo[i][j] ← 1 + memo[i-1][j-1]
                ELSE
                    memo[i][j] ← MAX(memo[i-1][j], memo[i][j-1])
                END IF
            END FOR
        END FOR

        RETURN memo[n][m]

### Variables Used
- `text1, text2` — Input strings
- `memo[][]` — DP table storing LCS lengths
- `i, j` — Loop counters

### Algorithm Explanation
The algorithm builds a DP table where each cell represents the LCS of prefixes of two strings.  
If characters match, it extends the subsequence. Otherwise, it takes the maximum of two possibilities.  
The final value gives the length of the LCS, and the sequence can be reconstructed by backtracking.

### Time Complexity
`O(n × m)`

### Space Complexity
`O(n × m)`

---

## Program 2: N-Queens Problem (NQueens.java)

### Aim
To place N queens on an N×N chessboard such that no two queens attack each other using Backtracking.

### Pseudocode

    ALGO NQueens(n)
        pos[] ← array of size n
        CALL place(0)

    FUNCTION place(row)
        IF row == n
            RETURN true
        FOR col ← 0 TO n-1
            IF safe(row, col)
                pos[row] ← col
                IF place(row + 1)
                    RETURN true
        RETURN false

### Variables Used
- `n` — Size of chessboard
- `pos[]` — Stores column position of each queen
- `row, col` — Loop counters

### Algorithm Explanation
The algorithm places queens row by row.  
For each position, it checks column and diagonal conflicts.  
If safe, it recursively places the next queen.  
Backtracking occurs when no valid position is found.

### Time Complexity
`O(N!)`

### Space Complexity
`O(N)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/ecd07023-8773-4005-9061-0197322713c2" />


---

## Program 3: 0/1 Knapsack (O1KnapSack.java)

### Aim
To maximize profit using the 0/1 Knapsack problem with Dynamic Programming.

### Pseudocode

    ALGO Knapsack(items, capacity)
        CREATE memo[n+1][capacity+1]

        FOR i ← 1 TO n
            FOR w ← 1 TO capacity
                IF weight[i] ≤ w
                    memo[i][w] ← MAX(
                        memo[i-1][w],
                        memo[i-1][w-weight[i]] + profit[i]
                    )
                ELSE
                    memo[i][w] ← memo[i-1][w]
                END IF

        RETURN memo[n][capacity]

### Variables Used
- `profitWeight_matrix[][]` — Stores profit and weight
- `memo[][]` — DP table
- `capacity` — Maximum allowed weight

### Algorithm Explanation
The algorithm builds a DP table where each row represents items and each column represents weight capacity.  
For each item, we decide whether to include or exclude it.  
The optimal solution is stored in the last cell.

### Time Complexity
`O(n × W)`

### Space Complexity
`O(n × W)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/fc950d10-a3df-427e-b93a-ed2881ca4aeb" />


---

## Program 4: All-Pairs Shortest Path (PairShortestPath.java)

### Aim
To find shortest paths between all pairs of vertices using the Floyd-Warshall algorithm.

### Pseudocode

    ALGO FloydWarshall(graph)
        dist ← graph

        FOR k ← 0 TO n-1
            FOR i ← 0 TO n-1
                FOR j ← 0 TO n-1
                    dist[i][j] ← MIN(
                        dist[i][j],
                        dist[i][k] + dist[k][j]
                    )

        RETURN dist

### Variables Used
- `adjacency_matrix[][]` — Graph representation
- `current_distance[][]` — Distance matrix
- `i, j, k` — Loop counters

### Algorithm Explanation
The algorithm updates shortest paths by considering each vertex as an intermediate point.  
It checks whether passing through an intermediate vertex improves the path.  
After all iterations, shortest paths between all pairs are obtained.

### Time Complexity
`O(n³)`

### Space Complexity
`O(n²)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/15a9e7c9-32e8-4e3e-9b89-bbfbca326321" />


---

## Program 5: Traveling Salesperson Problem (TravelingSalesperson.java)

### Aim
To find the minimum cost Hamiltonian cycle using Dynamic Programming (Bitmasking).

### Pseudocode

    ALGO TSP(graph)
        DEFINE memo[mask][i]

        FUNCTION solve(mask, pos)
            IF mask == all_visited
                RETURN graph[pos][0]

            FOR each city not visited
                ans ← MIN(
                    graph[pos][city] + solve(mask | (1<<city), city)
                )

            RETURN ans

### Variables Used
- `adjacency_matrix[][]` — Distance matrix
- `mask` — Bitmask representing visited cities
- `memo[][]` — DP table
- `vertex` — Current city

### Algorithm Explanation
The algorithm uses bitmasking to represent visited cities.  
It recursively explores all possible paths while storing intermediate results.  
Dynamic programming avoids recomputation, making it efficient compared to brute force.

### Time Complexity
`O(n² × 2ⁿ)`

### Space Complexity
`O(n × 2ⁿ)`

---

### Recorded Graph
<img width="789" height="490" alt="image" src="https://github.com/user-attachments/assets/8581fdbe-7a3f-4d0b-a059-016259d6734b" />


---

### Recorded Graph


---

# LAB 10

---

## Program 1: Graph Coloring (GraphColoring.java)

### Aim
To assign colors to vertices of a graph such that no two adjacent vertices have the same color using Backtracking.

### Pseudocode

    ALGO MColoring(k)
        DO
            NextValue(k)
            IF x[k] == 0
                RETURN
            IF k == n - 1
                RETURN
            ELSE
                MColoring(k + 1)
        WHILE true

    ALGO NextValue(k)
        WHILE true
            x[k] ← (x[k] + 1) mod (m + 1)
            IF x[k] == 0
                RETURN
            FOR j ← 0 TO n-1
                IF graph[k][j] == 1 AND x[k] == x[j]
                    BREAK
            IF j == n
                RETURN

### Variables Used
- `graph[][]` — Adjacency matrix of graph
- `x[]` — Color assignment array
- `n` — Number of vertices
- `m` — Number of colors
- `k` — Current vertex index

### Algorithm Explanation
The algorithm assigns colors to vertices one by one.  
For each vertex, it tries all possible colors and checks if the assignment is safe.  
If a conflict occurs with adjacent vertices, the next color is tried.  
Backtracking is used when no valid color is possible.

### Time Complexity
`O(mⁿ)`

### Space Complexity
`O(n)`

---

### Recorded Graph

---

## Program 2: Hamiltonian Cycle (HamiltonianCycle.java)

### Aim
To determine whether a Hamiltonian Cycle exists in a graph using Backtracking.

### Pseudocode

    ALGO Hamiltonian(k)
        DO
            NextValue(k)
            IF x[k] == -1
                RETURN
            IF k == n - 1
                IF graph[x[k]][x[0]] == 1
                    RETURN
            ELSE
                Hamiltonian(k + 1)
        WHILE true

    ALGO NextValue(k)
        WHILE true
            x[k] ← (x[k] + 1) mod n
            IF x[k] == 0
                x[k] ← -1
                RETURN
            IF graph[x[k-1]][x[k]] == 1
                FOR j ← 0 TO k-1
                    IF x[j] == x[k]
                        BREAK
                IF j == k
                    RETURN

### Variables Used
- `graph[][]` — Adjacency matrix
- `x[]` — Stores path of vertices
- `n` — Number of vertices
- `k` — Current position in path

### Algorithm Explanation
The algorithm tries to build a cycle by adding one vertex at a time.  
Each vertex must be adjacent to the previous vertex and must not already be included.  
When all vertices are included, it checks if the last vertex connects back to the first.  
If yes, a Hamiltonian Cycle exists.

### Time Complexity
`O(n!)`

### Space Complexity
`O(n)`

---

### Recorded Graph

---

## Program 3: Subset Sum (SubsetSum.java)

### Aim
To determine whether there exists a subset of a given set whose sum equals a target value using Backtracking.

### Pseudocode

    ALGO SubsetSum(arr, target)
        RETURN Backtrack(0, 0)

    FUNCTION Backtrack(index, currentSum)
        IF currentSum == target
            RETURN true
        IF index ≥ n OR currentSum > target
            RETURN false

        IF Backtrack(index + 1, currentSum + arr[index])
            RETURN true

        IF Backtrack(index + 1, currentSum)
            RETURN true

        RETURN false

### Variables Used
- `arr[]` — Input array
- `target` — Desired sum
- `index` — Current position in array
- `currentSum` — Running sum

### Algorithm Explanation
The algorithm explores all possible subsets using recursion.  
At each step, it decides whether to include or exclude the current element.  
If the sum equals the target, it returns true.  
If all possibilities are exhausted, it returns false.

### Time Complexity
`O(2ⁿ)`

### Space Complexity
`O(n)`

---

### Recorded Graph

---
