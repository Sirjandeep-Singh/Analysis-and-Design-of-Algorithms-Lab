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

### Algorithm Explanation
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

### Algorithm Explanation
Adjacent elements are compared and swapped if they are in the wrong order.  
After each pass, the largest element moves to the end of the array.  
This continues until the array becomes sorted.

### Time Complexity
Best Case: O(n²)  
Average Case: O(n²)  
Worst Case: O(n²)

### Space Complexity
O(1)

### Observations
| n (Input Size) | Best Case Time (µs) | Average Case Time (µs) | Worst Case Time (µs) |
|---------------|--------------------|------------------------|---------------------|
| 100           | 3.000              | 10.010                 | 6.999               |
| 500           | 45.500             | 126.506                | 64.008              |
| 1000          | 151.031            | 368.580                | 222.537             |
| 2000          | 556.294            | 1189.827               | 895.322             |
| 5000          | 3617.659           | 6499.183               | 5615.436            |
| 10000         | 13980.492          | 25109.154              | 22234.117           |
| 15000         | 31302.309          | 66761.630              | 49055.820           |

### Recorded Graph
<img width="1200" height="800" alt="BB Sort Graph" src="https://github.com/user-attachments/assets/7b5c6aae-c2f4-4e83-b654-89dde4f92939" />

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
  
### Algorithm Explanation
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

### Algorithm Explanation
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

### Algorithm Explanation
Each element is checked sequentially.  
The search stops when the element is found or array traversal ends.

### Time Complexity
Best Case: O(1)  
Worst Case: O(n)

### Space Complexity
O(1)

### Observations
| n (Input Size) | Best Case Time (µs) | Average Case Time (µs) | Worst Case Time (µs) |
|---------------|--------------------|------------------------|---------------------|
| 100           | 0.093              | 0.257                  | 11.484              |
| 500           | 0.045              | 0.487                  | 57.447              |
| 1000          | 0.051              | 0.999                  | 196.425             |
| 2000          | 0.045              | 1.946                  | 719.601             |
| 5000          | 0.046              | 4.739                  | 4195.327            |
| 10000         | 0.045              | 9.762                  | 16508.514           |
| 15000         | 0.047              | 14.971                 | 36964.035           |


### Recorded Graph
<img width="1200" height="800" alt="LinearSearch" src="https://github.com/user-attachments/assets/280373f3-cd73-40ee-88f4-800c898ca9af" />


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

### Algorithm Explanation
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

### Algorithm Explanation
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

### Algorithm Explanation
The smallest element is selected and placed at the correct position.  
This process continues until the array becomes sorted.

### Time Complexity
O(n²)

### Space Complexity
O(1)

### Observations
| n (Input Size) | Best Case Time (µs) | Average Case Time (µs) | Worst Case Time (µs) |
|---------------|--------------------|------------------------|---------------------|
| 100           | 5.000              | 8.000                  | 11.005              |
| 500           | 191.109            | 187.026                | 187.533             |
| 1000          | 727.119            | 733.611                | 741.856             |
| 2000          | 3163.123           | 3126.884               | 3039.476            |
| 5000          | 20228.129          | 20229.693              | 20328.371           |
| 10000         | 78455.976          | 78262.249              | 79097.123           |
| 15000         | 183968.866         | 185613.463             | 178893.970          |

### Recorded Graph
<img width="1200" height="800" alt="SS SORT" src="https://github.com/user-attachments/assets/9c611012-90aa-4c7e-9b3e-8bc9f48ea608" />

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

### Algorithm Explanation
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

### Algorithm Explanation
The problem is divided recursively into smaller subproblems.  
Disks are moved step by step until all reach the destination rod.



### Time Complexity
O(2ⁿ)

### Space Complexity
O(n)

---
# LAB 2

---

## Program 1: Insertion Sort

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

### Algorithm Explanation
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

### Observation Table (Time in Nanoseconds)

| n (Input Size) | Best Case Time (ns) | Average Case Time (ns) | Worst Case Time (ns) |
|---------------|--------------------|------------------------|---------------------|
| 100           | 805                | 1756                   | 8776                |
| 200           | 255                | 3634                   | 4367                |
| 500           | 410                | 16800                  | 24884               |
| 1000          | 736                | 59757                  | 91012               |
| 2000          | 1467               | 228526                 | 346857              |
| 5000          | 3417               | 1383104                | 2095113             |
| 10000         | 6778               | 5538482                | 8497658             |
| 20000         | 13476              | 22021393               | 36513503            |
| 50000         | 34132              | 139579324              | 237804771           |
| 100000        | 69091              | 556136188              | 950106590           |

---

### Recorded Graph
<img width="1200" height="800" alt="INS SORT GRAP" src="https://github.com/user-attachments/assets/adc8c749-03ed-4969-b5b9-717533e3eb49" />

---

## Program 2: Binary Search

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

### Algorithm Explanation
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

### Observation Table (Time in Nanoseconds)

| n (Input Size) | Best Case Time (ns) | Average Case Time (ns) | Worst Case Time (ns) |
|---------------|--------------------|------------------------|---------------------|
| 100           | 344                | 189                    | 159                 |
| 200           | 99                 | 141                    | 82                  |
| 500           | 75                 | 97                     | 65                  |
| 1000          | 72                 | 104                    | 77                  |
| 2000          | 103                | 135                    | 109                 |
| 5000          | 126                | 158                    | 132                 |
| 10000         | 147                | 183                    | 142                 |
| 20000         | 191                | 220                    | 175                 |
| 50000         | 390                | 403                    | 372                 |
| 100000        | 583                | 592                    | 509                 |

---

### Recorded Graph
<img width="1200" height="800" alt="BIN SEARCH GRAPH" src="https://github.com/user-attachments/assets/72c75818-b083-4b29-a52f-4dd2322f638d" />



