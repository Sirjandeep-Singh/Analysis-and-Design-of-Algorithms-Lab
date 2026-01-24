###Algorithms Design and Analysis — Lab Programs

This repository contains Java implementations of fundamental algorithms along with detailed documentation including aim, pseudocode, variables used, logical working, and complexity analysis.

1. Ball Tips Problem (BallTips.java)
Aim

To calculate the number of times a ball will bounce until its velocity drops below a minimum threshold using a recursive approach while considering resistance losses.

Algorithm / Pseudocode

Input initial velocity and minimum velocity threshold

If current velocity is less than threshold
Return count

Reduce velocity based on resistance factor

Increment bounce count

Recursively call the function with updated velocity

Return total count

Variables Used
Variable	Description
velocity	Current velocity of the ball
threshold	Minimum velocity limit
resistance	Reduction factor applied after each bounce
count	Stores number of bounces
Logic / Working

The program uses recursion to simulate ball bounces.
After every bounce, the velocity is reduced based on resistance.
If the velocity becomes smaller than the minimum threshold, recursion stops.
The total number of recursive calls gives the number of ball tips.

Time Complexity

O(n) — where n is the number of bounces until the velocity drops below the threshold.

Space Complexity

O(n) — due to recursive call stack usage.

2. Bubble Sort (BubbleSortAlgo.java)
Aim

To sort an array of integers using the Bubble Sort algorithm and analyze its performance.

Algorithm / Pseudocode

Read array size and elements

Repeat passes from first index to last

Compare adjacent elements

If left element is greater than right element
Swap them

Continue until array is sorted

Variables Used
Variable	Description
arr[]	Stores input array elements
n	Size of the array
i, j	Loop counters
temp	Temporary variable used for swapping
Logic / Working

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.
After each pass, the largest element moves to the end of the array.
This continues until the entire array becomes sorted.

Time Complexity

Best Case: O(n)

Average Case: O(n²)

Worst Case: O(n²)

Space Complexity

O(1) — in-place sorting algorithm.

3. Early Duplicate Detection (EarlyDupe.java)
Aim

To detect the presence of duplicate elements in an array using an early termination approach.

Algorithm / Pseudocode

Read array elements

Compare each element with remaining elements

If duplicate is found
Print duplicate detected
Terminate execution

If no duplicates found
Print unique elements message

Variables Used
Variable	Description
arr[]	Input array
i, j	Loop counters
flag	Indicates duplicate detection
Logic / Working

The algorithm checks every element against the rest of the array.
When a duplicate is found, the program immediately stops further comparisons.
This early exit improves performance compared to full traversal.

Time Complexity

Best Case: O(1) (duplicate found early)

Worst Case: O(n²)

Space Complexity

O(1) — no extra memory used.

4. Polynomial Evaluation Using Horner’s Method (horne.java)
Aim

To evaluate a polynomial expression efficiently using Horner’s method.

Algorithm / Pseudocode

Input polynomial coefficients

Input value of x

Initialize result with first coefficient

For each remaining coefficient
result = result × x + coefficient

Display result

Variables Used
Variable	Description
coeff[]	Polynomial coefficients
x	Input value
result	Stores evaluated value
i	Loop counter
Logic / Working

Horner’s method reduces the number of multiplications required.
Instead of calculating powers separately, the polynomial is evaluated in nested form.
This improves computational efficiency.

Time Complexity

O(n) — where n is the degree of the polynomial.

Space Complexity

O(1) — constant extra space.

5. Linear Search (LinearSearch.java)
Aim

To search for a given element in an array using the Linear Search technique.

Algorithm / Pseudocode

Input array elements

Input key element to search

Traverse array from beginning

If current element equals key
Display position
Stop execution

If traversal completes
Display not found

Variables Used
Variable	Description
arr[]	Input array
key	Element to be searched
i	Loop counter
Logic / Working

Linear Search checks elements sequentially.
The search continues until the required element is found or the array ends.
It is simple but slower for large datasets.

Time Complexity

Best Case: O(1)

Worst Case: O(n)

Space Complexity

O(1)

6. Missing Number in Consecutive Sequence (nConsecutive.java)
Aim

To find the missing number from a sequence of consecutive integers without using arithmetic operations.

Algorithm / Pseudocode

Initialize result variable

Traverse given array and update result using bitwise operations

Return final value as missing number

Variables Used
Variable	Description
arr[]	Input array
result	Stores missing number
i	Loop counter
Logic / Working

The algorithm applies logical bitwise operations to cancel out existing numbers.
The remaining value represents the missing number in the sequence.

Time Complexity

O(n) — single traversal of array.

Space Complexity

O(1) — constant extra space.

7. Power Calculation Using Recursion (power.java)
Aim

To compute the power of a number using recursion.

Algorithm / Pseudocode

Input base and exponent

If exponent equals 0
Return 1

Multiply base with recursive call using exponent-1

Return result

Variables Used
Variable	Description
base	Base value
exponent	Power value
result	Computed output
Logic / Working

The function repeatedly multiplies the base value using recursion.
Each recursive call reduces the exponent until it reaches zero.

Time Complexity

O(n) — where n is the exponent value.

Space Complexity

O(n) — recursive call stack.

8. Selection Sort (selectionSortAlgo.java)
Aim

To sort an array of integers using the Selection Sort algorithm.

Algorithm / Pseudocode

Traverse array from first position

Find minimum element in remaining array

Swap minimum with current position

Repeat for remaining elements

Variables Used
Variable	Description
arr[]	Input array
minIndex	Index of minimum element
i, j	Loop counters
temp	Temporary swap variable
Logic / Working

Selection Sort repeatedly selects the smallest element and places it at the correct position.
The array becomes sorted gradually.

Time Complexity

Best Case: O(n²)

Average Case: O(n²)

Worst Case: O(n²)

Space Complexity

O(1) — in-place sorting.

9. String Permutations (StringPerm.java)
Aim

To generate all possible permutations of a given string using recursion.

Algorithm / Pseudocode

Input string

If string is empty
Print permutation

For each character
Fix character
Recursively permute remaining string

Variables Used
Variable	Description
str	Input string
prefix	Fixed permutation part
i	Loop counter
Logic / Working

The algorithm fixes characters one by one and recursively generates permutations of remaining characters.
This continues until all possible combinations are printed.

Time Complexity

O(n!) — factorial growth due to permutations.

Space Complexity

O(n) — recursion stack depth.

10. Towers of Hanoi (TowersOfHanoi.java)
Aim

To solve the Towers of Hanoi problem using a recursive algorithm and display disk movements.

Algorithm / Pseudocode

Input number of disks

Move n-1 disks from source to auxiliary

Move largest disk to destination

Move n-1 disks from auxiliary to destination

Repeat recursively

Variables Used
Variable	Description
n	Number of disks
source	Source rod
auxiliary	Helper rod
destination	Target rod
Logic / Working

The problem is divided recursively into smaller subproblems.
Each step moves disks while maintaining the rule constraints until the final solution is achieved.

Time Complexity

O(2ⁿ) — exponential recursive calls.

Space Complexity

O(n) — recursion stack depth.
