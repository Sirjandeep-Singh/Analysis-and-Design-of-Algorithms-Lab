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
<img width="1200" height="800" alt="INS SORT GRAPH" src="https://github.com/user-attachments/assets/adc8c749-03ed-4969-b5b9-717533e3eb49" />

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


