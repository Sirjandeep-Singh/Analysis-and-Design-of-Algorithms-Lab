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
<img width="593" height="367" alt="image" src="https://github.com/user-attachments/assets/64d89023-0e59-4872-8ed3-00e615f37d48" />

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
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/b1b465ae-d557-45d0-a20d-1b78b05477cb" />

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
<img width="790" height="490" alt="image" src="https://github.com/user-attachments/assets/d1ded5b2-9edf-4c64-a47d-39c160d2b00c" />

---
