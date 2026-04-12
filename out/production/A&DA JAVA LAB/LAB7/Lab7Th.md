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
`O(V)`

### Space Complexity
`O(V)`

---

## Program 2: Multi Stage Graph Shortest Path using Dynamic Programming (MSGShortestPath.java)

### Aim
To find the shortest path from source to destination in a multi-stage graph using dynamic programming.

### Pseudocode

    ALGO MultiStageShortestPath(adjMatrix, source)
        INITIALIZE cost[0...n-1] ← ∞
        INITIALIZE d[0...n-1]

        cost[n-1] ← 0

        RETURN SolveRecFwd(adjMatrix, source)

    ALGO SolveRecFwd(adjMatrix, currentVertex)
        IF cost[currentVertex] ≠ ∞
            RETURN cost[currentVertex]

        FOR i ← currentVertex + 1 TO n-1
            IF edge exists from currentVertex to i
                cost ← SolveRecFwd(adjMatrix, i) + adjMatrix[currentVertex][i]

                IF cost < cost[currentVertex]
                    cost[currentVertex] ← cost
                    d[currentVertex] ← i
                END IF
            END IF
        END FOR

        RETURN cost[currentVertex]

### Variables Used
- `adjMatrix[][]` — Graph representation
- `Cost[]` — Stores minimum cost from vertex to destination
- `d[]` — Stores next vertex in optimal path
- `source` — Starting vertex

### Algorithm Explanation
The algorithm uses a top-down dynamic programming approach with memoization.  
It starts from the source vertex and recursively explores all possible forward edges.  
For each vertex, it computes the minimum cost required to reach the destination by considering all valid outgoing edges.  
Previously computed results are stored in the `cost` array to avoid recomputation.  
The `d[]` array stores the next vertex in the optimal path, allowing path reconstruction.

### Time Complexity
`O(V*d)` - `d` being the maximum outdegree of a vertex

### Space Complexity
`O(V)`

---

## Notes
- The algorithm assumes that vertices with higher indices belong to later stages
- The graph must be a directed acyclic graph (DAG)
- Only forward edges (i < j) are considered  