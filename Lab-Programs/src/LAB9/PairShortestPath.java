package LAB9;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

public class PairShortestPath implements TwoDimAlgorithm {
    private String name;
    private int[][] memo;
    private int[][] s;
    private int[][] result;
    public PairShortestPath(String name){
        this.name = name;
    }

    public int[] algorithm(int[][] adjacency_matrix, int source){
        result = solve(adjacency_matrix);
        return new int[]{0};
    }

    private int[][] solve(int[][] adjacency_matrix){
        int n = adjacency_matrix.length;
        int[][] current_distance = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                if(i == j){
                    current_distance[i][j] = 0;
                }
                else if(adjacency_matrix[i][j] == 0){
                    current_distance[i][j] = Integer.MAX_VALUE/200;
                }
                else{
                    current_distance[i][j] = adjacency_matrix[i][j];
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < n; k++){
                    current_distance[j][k] = Math.min(current_distance[j][k], (current_distance[j][i] + current_distance[i][k]));
                }
            }
        }

        return current_distance;
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        int n = arr.length;

        return 0;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return name;
    }

    public static void main(String[] args){
//        int[][] arr = {{0,0}};
//        PairShortestPath psp = new PairShortestPath("LCS");
//        psp.algorithm(arr,0);
//        System.out.println();

        PairShortestPath psp = new PairShortestPath("PairShortestPath");
        boolean[] choices = {false, true, false};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 5; idx < length ; i+= 5){
            sizes[idx][0] = i;
            sizes[idx][1] = i;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(psp, 1000, "Lab-Programs/src/LAB9/Data/");
        framework.initiate(sizes, choices);
    }


}
