package LAB10;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

public class GraphColoring implements TwoDimAlgorithm {

    private String name;
    private int[] x; // color array
    private int n, m;
    private int[][] graph;

    public GraphColoring(String name){
        this.name = name;
    }

    @Override
    public int[] algorithm(int[][] adjacency_matrix, int m){
        this.graph = adjacency_matrix;
        this.n = graph.length;
        this.m = m;
        x = new int[n];

        mColoring(0);

        return x;
    }

    private boolean mColoring(int k){
        do {
            nextValue(k);

            if(x[k] == 0) return false; // no color possible

            if(k == n - 1){
                return true; // solution found (you can print here)
            } else {
                if(mColoring(k + 1)) return true;
            }

        } while(true);
    }

    private void nextValue(int k){
        while(true){
            x[k] = (x[k] + 1) % (m + 1);

            if(x[k] == 0) return;

            int j;
            for(j = 0; j < n; j++){
                if(graph[k][j] == 1 && x[k] == x[j]){
                    break;
                }
            }

            if(j == n) return; // safe color found
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
        generateGraph(arr, 0.2);
        return 3;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        generateGraph(arr, 0.5);
        return arr.length / 2;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        generateGraph(arr, 0.9);
        return arr.length;
    }

    @Override
    public String getName(){
        return name;
    }

    public static void main(String[] args){
        GraphColoring gc = new GraphColoring("GraphColoring");

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
                new Timing2DAlgorithms(gc, 1000, "Lab-Programs/src/LAB10/Data/");

        framework.initiate(sizes, choices);
    }
}