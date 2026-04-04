package LAB6;

import LAB5.QuickSort2D;
import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

import java.security.SecureRandom;
import java.util.PriorityQueue;

public class Kruskal implements TwoDimAlgorithm {
    private final String name;
    private double[][] edgeList;
    public Kruskal(String name){
        this.name = name;
    }

    public int[] solve(int[][] adjMatrix, int sortIdx){
        //flatten AdjMatrix to EdgeList(Only for testing algorithm not timing, for timing the algo create the edge list in setup, so we do not count then O(n^2) here.)
//        flatten2DMatrix(adjMatrix);
        //Sort the List
        int size = edgeList.length;
        QuickSort2D.QuickSort_2D(edgeList, sortIdx, 0, edgeList.length - 1);
        //Using DSU SOLVE
        DSU forests = new DSU(adjMatrix.length);
        //counting edges for early stopping
        int edgesUsed = 0;
        int totalWeight = 0;
        for(int i = 0 ; i < size && edgesUsed < adjMatrix.length - 1 ; i++){
            int vertex1 = (int)edgeList[i][1];
            int vertex2 = (int)edgeList[i][2];
            int pv1 = forests.find(vertex1);
            int pv2 = forests.find(vertex2);
            if(pv1 != pv2){
                totalWeight += (int)edgeList[i][0];
                forests.union(vertex1,vertex2);
                edgesUsed++;
            }
        }
        return new int[]{totalWeight};
    }

    private void flatten2DMatrix(int[][] adjMatrix){
        int idx = 0;
        int n = adjMatrix.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(adjMatrix[i][j] != 0){
                    count++;
                }
            }
        }

        edgeList = new double[count][3];

        for(int i = 0; i < n; i++){
            for(int j = i + 1 ; j < n; j++){
                if(adjMatrix[i][j] != 0){
                    edgeList[idx] = new double[]{adjMatrix[i][j], i, j};
                    idx++;
                }
            }
        }
    }


    @Override
    public int[] algorithm(int[][] arr, int target){
        solve(arr,0);
        return solve(arr,0);
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        generateRandomGraph(arr, arr.length);
        flatten2DMatrix(arr);
        return target % arr.length;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        generateRandomGraph(arr, arr.length);
        flatten2DMatrix(arr);
        return target % arr.length;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        generateRandomGraph(arr, arr.length);
        flatten2DMatrix(arr);
        return target % arr.length;
    }

    @Override
    public String getName(){
        return name;
    }

    public static void generateRandomGraph(int[][] arr, int rows){
        SecureRandom random = new SecureRandom();
        int INF = Integer.MAX_VALUE / 2;
        double density = 0.5;
        // initialize
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < rows; j++){
                arr[i][j] = 0;
            }
        }

        // fill edges
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < rows; j++){

                // decide if edge exists
                if(random.nextDouble(0,1) < density && i != j){
                    int weight = random.nextInt(1, 100); // weights 1–100
                    arr[i][j] = weight;
                    arr[j][i] = weight;
                }
            }
        }

        // ensure reachability from source (0)
        for(int i = 0; i < rows - 1; i++){
            int weight = random.nextInt(1, 100);
            arr[i][i + 1] = weight;
            arr[i + 1][i] = weight;
        }

    }

    public static void main(String[] args){
        Kruskal kl = new Kruskal("Kruskal");
//        int[][] adjMatrix = {
//                {0, 2, 0, 6, 0},
//                {2, 0, 3, 8, 5},
//                {0, 3, 0, 0, 7},
//                {6, 8, 0, 0, 9},
//                {0, 5, 7, 9, 0}
//        };
//        int[] result = kl.solve(adjMatrix,0);
//
//        System.out.println("MST Weighted as: " + result[0]);

        boolean[] choices = {false, true, false};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 5; idx < length ; i+= 5){
            sizes[idx][0] = i;
            sizes[idx][1] = i;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(kl, 1000, "Lab-Programs/src/LAB6/Data/");
        framework.initiate(sizes, choices);

    }
}
