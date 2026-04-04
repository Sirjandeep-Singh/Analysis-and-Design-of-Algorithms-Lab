package LAB6;

public class DSU {
    int[] parent;

    // constructor
    DSU(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // find (with path compression)
    int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // union
    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            parent[py] = px;
        }
    }
}