# LAB 6

---

## Program 1: Activity Selection (ActivitySelection.java)

### Aim
To select the maximum number of non-overlapping activities using a greedy approach.

### Pseudocode

    ALGO ActivitySelection(arr)
        SORT activities based on end time
        prevEndTime ← -∞
        totalActivities ← 0

        FOR each activity
            IF startTime ≥ prevEndTime
                totalActivities ← totalActivities + 1
                prevEndTime ← endTime
            END IF
        END FOR

        RETURN totalActivities

### Variables Used
- `arr[][]` — Array containing start and end times
- `prevEndTime` — Stores last selected activity end time
- `totalActivities` — Count of selected activities

### Algorithm Explanation
Activities are sorted based on end time.  
The earliest finishing activity is selected first.  
Next activity is selected only if it starts after or at the end of the last selected activity.  
This ensures maximum number of non-overlapping activities.

### Time Complexity
`O(n log n)`

### Space Complexity
`O(1)`

---

### Recorded Graph


---

## Program 2: Cycle Detection (CycleDetection.java)

### Aim
To detect a cycle in an undirected graph using Disjoint Set Union (DSU).

### Pseudocode

    ALGO CycleDetection(adjMatrix)
        CREATE DSU of size n

        FOR i ← 0 TO n-1
            FOR j ← i+1 TO n-1
                IF edge exists
                    px ← find(i)
                    py ← find(j)

                    IF px == py
                        RETURN cycle detected
                    END IF

                    UNION(i, j)
                END IF
            END FOR
        END FOR

        RETURN no cycle

### Variables Used
- `adjMatrix[][]` — Graph representation
- `DSU` — Disjoint set structure
- `px, py` — Parent representatives

### Algorithm Explanation
Each edge is checked using DSU.  
If two vertices belong to the same set, adding the edge forms a cycle.  
Otherwise, they are merged using union operation.

### Time Complexity
`O(E α(n))`

### Space Complexity
`O(n)`

---

### Recorded Graph


---

## Program 3: Dijkstra Algorithm (DijsktraAlgo.java)

### Aim
To find shortest paths from a source vertex to all other vertices using Dijkstra’s algorithm.

### Pseudocode

    ALGO Dijkstra(adjMatrix, source)
        INITIALIZE distance array with ∞
        distance[source] ← 0

        CREATE priority queue

        WHILE queue not empty
            u ← extract minimum

            FOR each neighbor v
                IF distance[u] + weight(u,v) < distance[v]
                    UPDATE distance[v]
                END IF
            END FOR
        END WHILE

        RETURN distance

### Variables Used
- `adjMatrix[][]` — Graph representation
- `distances[]` — Stores shortest distances
- `visited[]` — Tracks visited nodes
- `priorityQueue` — Custom priority queue

### Algorithm Explanation
The closest unvisited node is selected each time.  
Distances are updated using relaxation.  
Priority queue ensures efficient minimum selection.

### Time Complexity
`O((V + E) log V)`

### Space Complexity
`O(V)`

---

### Recorded Graph


---

## Program 4: Kruskal Algorithm (Kruskal.java)

### Aim
To find the Minimum Spanning Tree (MST) of a graph using Kruskal’s algorithm.

### Pseudocode

    ALGO Kruskal(adjMatrix)
        CONVERT adjacency matrix to edge list
        SORT edges by weight

        CREATE DSU
        totalWeight ← 0

        FOR each edge (u, v)
            IF find(u) ≠ find(v)
                ADD edge to MST
                UNION(u, v)
                totalWeight ← totalWeight + weight
            END IF
        END FOR

        RETURN totalWeight

### Variables Used
- `edgeList[][]` — List of edges
- `DSU` — Disjoint set structure
- `totalWeight` — MST weight
- `edgesUsed` — Count of edges included

### Algorithm Explanation
Edges are processed in increasing order of weight.  
An edge is added only if it does not form a cycle.  
DSU efficiently detects cycles.

### Time Complexity
`O(E log E)`

### Space Complexity
`O(E)`

---

### Recorded Graph


---

## Program 5: Prim’s Algorithm (Prims.java)

### Aim
To construct a Minimum Spanning Tree (MST) using Prim’s algorithm.

### Pseudocode

    ALGO Prims(adjMatrix, source)
        INITIALIZE weights[] ← ∞
        weights[source] ← 0

        CREATE priority queue

        WHILE MST not complete
            u ← extract minimum

            FOR each neighbor v
                IF weight(u,v) < weights[v]
                    UPDATE weights[v]
                    SET parent[v] ← u
                END IF
            END FOR
        END WHILE

        RETURN parent array

### Variables Used
- `adjMatrix[][]` — Graph representation
- `weights[]` — Minimum edge weights
- `near[]` — Parent array (MST)
- `connected[]` — Tracks included vertices

### Algorithm Explanation
The algorithm starts from a source vertex.  
At each step, it selects the minimum weight edge connecting MST to a new vertex.  
Priority queue ensures efficient selection.

### Time Complexity
`O((V + E) log V)`

### Space Complexity
`O(V)`

---

### Recorded Graph


---