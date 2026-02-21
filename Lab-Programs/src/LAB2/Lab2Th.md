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