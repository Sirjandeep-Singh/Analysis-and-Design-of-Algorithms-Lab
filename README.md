# Algorithms Design and Analysis — Lab Programs

This repository contains Java implementations of fundamental algorithms with documentation including aim, pseudocode, variables used, logic, time complexity, and space complexity.

---

## Program 1: Ball Tips Problem (BallTips.java)

### Aim
To calculate the number of times a ball will bounce until its velocity drops below a minimum threshold using recursion.

### Pseudocode

ALGO CountBounces  
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

### Logic / Working
The algorithm recursively reduces velocity after each bounce.  
When velocity becomes less than the threshold, recursion stops.  
Each recursive call contributes one bounce to the final count.

### Time Complexity
O(n)

### Space Complexity
O(n)

---

## Program 2: Bubble Sort (BubbleSortAlgo.java)

### Aim
To sort an array of integers using the Bubble Sort technique.

### Pseudocode

ALGO BubbleSort  
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

### Logic / Working
Adjacent elements are compared and swapped if they are in the wrong order.  
After each pass, the largest element moves to the end of the array.  
This continues until the array becomes sorted.

### Time Complexity
Best Case: O(n)  
Average Case: O(n²)  
Worst Case: O(n²)

### Space Complexity
O(1)

---

## Program 3: Early Duplicate Detection (EarlyDupe.java)

### Aim
To detect duplicate elements in an array using early termination.

### Pseudocode

ALGO FindDuplicate  
FOR i ← 0 TO n - 1  
    FOR j ← i + 1 TO n - 1  
        IF arr[i] == arr[j]  
            PRINT "Duplicate Found"  
            EXIT  
        END IF  
    END FOR  
END FOR  

PRINT "No Duplicate Found"  

### Variables Used
- arr[] — Input array  
- i, j — Loop counters  

### Logic / Working
Each element is compared with remaining elements.  
Once a duplicate is found, execution stops immediately.  
This avoids unnecessary comparisons.

### Time Complexity
Best Case: O(1)  
Worst Case: O(n²)

### Space Complexity
O(1)

---

## Program 4: Polynomial Evaluation Using Horner’s Method (horne.java)

### Aim
To evaluate a polynomial expression efficiently using Horner’s method.

### Pseudocode

ALGO HornerEvaluation  
result ← coeff[0]  

FOR i ← 1 TO n  
    result ← (result × x) + coeff[i]  
END FOR  

PRINT result  

### Variables Used
- coeff[] — Polynomial coefficients  
- x — Input value  
- result — Computed value  

### Logic / Working
Polynomial evaluation is performed in nested form.  
This reduces multiplication operations and improves efficiency.

### Time Complexity
O(n)

### Space Complexity
O(1)

---

## Program 5: Linear Search (LinearSearch.java)

### Aim
To search for a given element in an array using Linear Search.

### Pseudocode

ALGO LinearSearch  
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

### Logic / Working
Each element is checked sequentially.  
The search stops when the element is found or array traversal ends.

### Time Complexity
Best Case: O(1)  
Worst Case: O(n)

### Space Complexity
O(1)

---

## Program 6: Missing Number in Consecutive Sequence (nConsecutive.java)

### Aim
To find the missing number from a sequence of consecutive integers without using arithmetic operations.

### Pseudocode

ALGO FindMissing  
result ← 0  

FOR each element IN array  
    result ← result XOR element  
END FOR  

PRINT result  

### Variables Used
- arr[] — Input array  
- result — Missing number  

### Logic / Working
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

ALGO Power  
IF exponent == 0  
    RETURN 1  
END IF  

RETURN base × Power(base, exponent - 1)  

### Variables Used
- base — Base number  
- exponent — Power value  

### Logic / Working
The base is multiplied recursively.  
Each recursive call reduces the exponent until base condition is met.

### Time Complexity
O(n)

### Space Complexity
O(n)

---

## Program 8: Selection Sort (selectionSortAlgo.java)

### Aim
To sort an array using Selection Sort algorithm.

### Pseudocode

ALGO SelectionSort  
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

### Logic / Working
The smallest element is selected and placed at the correct position.  
This process continues until the array becomes sorted.

### Time Complexity
O(n²)

### Space Complexity
O(1)

---

## Program 9: String Permutation (StringPerm.java)

### Aim
To generate all permutations of a given string using recursion.

### Pseudocode

ALGO StringPermutation  
IF string is empty  
    PRINT prefix  
ELSE  
    FOR i ← 0 TO length(string) - 1  
        newString ← string without character at i  
        CALL StringPermutation(newString, prefix + string[i])  
    END FOR  
END IF  

### Variables Used
- str — Input string  
- prefix — Fixed portion  

### Logic / Working
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

ALGO TowersOfHanoi  
IF n == 1  
    PRINT move disk from source to destination  
    RETURN  
END IF  

CALL TowersOfHanoi(n - 1, source, destination, auxiliary)  
PRINT move disk from source to destination  
CALL TowersOfHanoi(n - 1, auxiliary, source, destination)  

### Variables Used
- n — Number of disks  
- source — Source rod  
- auxiliary — Helper rod  
- destination — Target rod  

### Logic / Working
The problem is divided recursively into smaller subproblems.  
Disks are moved step by step until all reach the destination rod.

### Time Complexity
O(2ⁿ)

### Space Complexity
O(n)
