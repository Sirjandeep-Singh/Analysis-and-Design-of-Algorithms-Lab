# Algorithms Design and Analysis — Lab Programs

This repository contains Java implementations of fundamental algorithms with proper documentation including aim, pseudocode, variables used, logic, time complexity, and space complexity.

---

## Program 1: Ball Tips Problem (BallTips.java)

### Aim
To calculate the number of times a ball will bounce until its velocity drops below a minimum threshold using a recursive approach while considering resistance losses.

### Algorithm / Pseudocode
1. Input initial velocity and minimum velocity threshold  
2. If current velocity is less than threshold  
   - Return count  
3. Reduce velocity based on resistance factor  
4. Increment bounce count  
5. Recursively call function with updated velocity  
6. Return total count  

### Variables Used
- **velocity** — Current velocity of the ball  
- **threshold** — Minimum velocity limit  
- **resistance** — Reduction factor after each bounce  
- **count** — Stores number of bounces  

### Logic / Working
The program uses recursion to simulate ball bounces.  
After every bounce, the velocity is reduced based on resistance.  
If the velocity becomes smaller than the threshold, recursion stops.  
The total number of recursive calls gives the number of ball tips.

### Time Complexity
- **O(n)** — where n is the number of bounces.

### Space Complexity
- **O(n)** — due to recursive call stack.

---

## Program 2: Bubble Sort (BubbleSortAlgo.java)

### Aim
To sort an array of integers using the Bubble Sort algorithm.

### Algorithm / Pseudocode
1. Read array size and elements  
2. Repeat passes over the array  
3. Compare adjacent elements  
4. If left element is greater than right element  
   - Swap them  
5. Continue until array is sorted  

### Variables Used
- **arr[]** — Stores array elements  
- **n** — Size of array  
- **i, j** — Loop counters  
- **temp** — Temporary variable for swapping  

### Logic / Working
Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.  
After each pass, the largest element moves to the end of the array.  
This process continues until the array becomes sorted.

### Time Complexity
- Best Case: **O(n)**  
- Average Case: **O(n²)**  
- Worst Case: **O(n²)**  

### Space Complexity
- **O(1)** — in-place sorting.

---

## Program 3: Early Duplicate Detection (EarlyDupe.java)

### Aim
To detect duplicate elements in an array using early termination.

### Algorithm / Pseudocode
1. Read array elements  
2. Compare each element with remaining elements  
3. If duplicate found  
   - Print message  
   - Terminate execution  
4. If no duplicate found  
   - Print unique elements message  

### Variables Used
- **arr[]** — Input array  
- **i, j** — Loop counters  
- **flag** — Duplicate detection indicator  

### Logic / Working
The algorithm compares elements pairwise.  
When a duplicate is detected, execution stops immediately.  
This avoids unnecessary comparisons and improves efficiency.

### Time Complexity
- Best Case: **O(1)**  
- Worst Case: **O(n²)**  

### Space Complexity
- **O(1)**

---

## Program 4: Polynomial Evaluation Using Horner’s Method (horne.java)

### Aim
To evaluate a polynomial expression efficiently using Horner’s method.

### Algorithm / Pseudocode
1. Input polynomial coefficients  
2. Input value of x  
3. Initialize result with first coefficient  
4. For remaining coefficients  
   - result = result × x + coefficient  
5. Display result  

### Variables Used
- **coeff[]** — Polynomial coefficients  
- **x** — Input value  
- **result** — Computed polynomial value  
- **i** — Loop counter  

### Logic / Working
Horner’s method evaluates the polynomial in nested form.  
It reduces the number of multiplication operations and improves efficiency.

### Time Complexity
- **O(n)** — where n is the degree of the polynomial.

### Space Complexity
- **O(1)**

---

## Program 5: Linear Search (LinearSearch.java)

### Aim
To search for a given element in an array using the Linear Search technique.

### Algorithm / Pseudocode
1. Input array elements  
2. Input key element  
3. Traverse array sequentially  
4. If element found  
   - Print position  
   - Stop execution  
5. If not found  
   - Print not found message  

### Variables Used
- **arr[]** — Input array  
- **key** — Element to be searched  
- **i** — Loop counter  

### Logic / Working
Linear Search checks each element one by one.  
Search stops when the element is found or when the array ends.

### Time Complexity
- Best Case: **O(1)**  
- Worst Case: **O(n)**  

### Space Complexity
- **O(1)**

---

## Program 6: Missing Number in Consecutive Sequence (nConsecutive.java)

### Aim
To find the missing number from a sequence of consecutive integers without using arithmetic operations.

### Algorithm / Pseudocode
1. Initialize result variable  
2. Traverse array and update result using logical operations  
3. Return final result as missing number  

### Variables Used
- **arr[]** — Input array  
- **result** — Missing number storage  
- **i** — Loop counter  

### Logic / Working
The algorithm applies logical operations to eliminate existing numbers.  
The remaining value represents the missing number.

### Time Complexity
- **O(n)**

### Space Complexity
- **O(1)**

---

## Program 7: Power Calculation Using Recursion (power.java)

### Aim
To compute the power of a number using recursion.

### Algorithm / Pseudocode
1. Input base and exponent  
2. If exponent equals zero  
   - Return 1  
3. Multiply base with recursive call  
4. Return result  

### Variables Used
- **base** — Base number  
- **exponent** — Power value  
- **result** — Output result  

### Logic / Working
The function multiplies the base value recursively.  
Each recursive call reduces the exponent until the base case is reached.

### Time Complexity
- **O(n)** — where n is exponent value.

### Space Complexity
- **O(n)** — recursive stack usage.

---

## Program 8: Selection Sort (selectionSortAlgo.java)

### Aim
To sort an array using the Selection Sort algorithm.

### Algorithm / Pseudocode
1. Traverse array  
2. Find minimum element  
3. Swap with current position  
4. Repeat until sorted  

### Variables Used
- **arr[]** — Input array  
- **minIndex** — Index of minimum element  
- **i, j** — Loop counters  
- **temp** — Swap variable  

### Logic / Working
Selection Sort selects the smallest element and places it in the correct position.  
Sorting progresses gradually.

### Time Complexity
- Best Case: **O(n²)**  
- Average Case: **O(n²)**  
- Worst Case: **O(n²)**  

### Space Complexity
- **O(1)**

---

## Program 9: String Permutation (StringPerm.java)

### Aim
To generate all permutations of a given string using recursion.

### Algorithm / Pseudocode
1. Input string  
2. If string empty  
   - Print permutation  
3. Fix one character  
4. Recursively permute remaining string  

### Variables Used
- **str** — Input string  
- **prefix** — Fixed part  
- **i** — Loop counter  

### Logic / Working
Each recursive call fixes one character.  
Remaining characters are permuted recursively until all combinations are generated.

### Time Complexity
- **O(n!)**

### Space Complexity
- **O(n)**

---

## Program 10: Towers of Hanoi (TowersOfHanoi.java)

### Aim
To solve the Towers of Hanoi problem using recursion and display disk movements.

### Algorithm / Pseudocode
1. Input number of disks  
2. Move n-1 disks from source to auxiliary  
3. Move largest disk to destination  
4. Move n-1 disks from auxiliary to destination  

### Variables Used
- **n** — Number of disks  
- **source** — Source rod  
- **auxiliary** — Helper rod  
- **destination** — Target rod  

### Logic / Working
The problem is solved by dividing it into smaller recursive subproblems.  
Disks are moved according to rules until all reach the destination rod.

### Time Complexity
- **O(2ⁿ)**

### Space Complexity
- **O(n)** — recursion stack depth.
