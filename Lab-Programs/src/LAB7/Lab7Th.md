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