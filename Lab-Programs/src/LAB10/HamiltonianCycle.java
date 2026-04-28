package LAB10;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

public class HamiltonianCycle implements TwoDimAlgorithm {

    private String name;
    private int[] x;
    private int[][] graph;
    private int n;

    public HamiltonianCycle(String name){
        this.name = name;
    }

    @Override
    public int[] algorithm(int[][] adjacency_matrix, int source){
        this.graph = adjacency_matrix;
        this.n = graph.length;

        x = new int[n];
        x[0] = 0; // start vertex

        hamiltonian(1);

        return x;
    }

    private void hamiltonian(int k){
        do {
            nextValue(k);

            if(x[k] == -1) return;

            if(k == n - 1){
                if(graph[x[k]][x[0]] == 1){
                    return; // cycle found
                }
            } else {
                hamiltonian(k + 1);
            }

        } while(true);
    }

    private void nextValue(int k){
        while(true){
            x[k] = (x[k] + 1) % n;

            if(x[k] == 0){
                x[k] = -1;
                return;
            }

            if(graph[x[k - 1]][x[k]] == 1){
                int j;
                for(j = 0; j < k; j++){
                    if(x[j] == x[k]) break;
                }

                if(j == k) return;
            }
        }
    }

    private void generateGraph(int[][] graph, double density){
        int n = graph.length;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i == j) graph[i][j] = 0;
                else{
                    if(Math.random() < density){
                        graph[i][j] = graph[j][i] = 1;
                    } else {
                        graph[i][j] = graph[j][i] = 0;
                    }
                }
            }
        }
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        generateGraph(arr, 0.9);
        return 0;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        generateGraph(arr, 0.5);
        return 0;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        generateGraph(arr, 0.2);
        return 0;
    }

    @Override
    public String getName(){
        return name;
    }

    public static void main(String[] args){
        HamiltonianCycle hc = new HamiltonianCycle("HamiltonianCycle");

        boolean[] choices = {false, true, false};
        int length = 100;

        int[][] sizes = new int[length][2];
        int idx = 0;

        for(int i = 4; idx < length; i++){
            sizes[idx][0] = i;
            sizes[idx][1] = i;
            idx++;
        }

        Timing2DAlgorithms framework =
                new Timing2DAlgorithms(hc, 1000, "Lab-Programs/src/LAB10/Data/");

        framework.initiate(sizes, choices);
    }
}