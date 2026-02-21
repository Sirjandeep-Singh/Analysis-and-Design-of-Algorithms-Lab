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
`O(n²) - Bubble Sort used, can be optimised to O(nlogn)` 

### Space Complexity
`O(1)`

---

### Recorded Graph
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/abf01b63-996e-4064-af7b-7015d0922214" />

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

