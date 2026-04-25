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

### Recorded Graph


---