//Only algorithm Actually done in LAB 9

package LAB9;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

import java.util.Arrays;

public class TravelingSalesperson implements TwoDimAlgorithm {
    private String name;
    private int[][] memo;
    public int INF = Integer.MAX_VALUE;
    public TravelingSalesperson(String name){
        this.name = name;
    }

    public int[] algorithm(int[][] adjacency_matrix, int source){
        int n = adjacency_matrix.length;
        double space = (1 << n);
        int[] temp = new int[(int)space];
        memo = new int[(int)space][n];
        Arrays.fill(temp,Integer.MAX_VALUE);
        for(int i = 0; i < (1 << n); i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return new int[]{solve(adjacency_matrix)};
    }

    //using top down dp
    private int solve(int[][] adjacency_matrix){
        int n = adjacency_matrix.length;
        int completedvisit = (1 << n) - 1;
        int mask = 1;
        return travelRec(adjacency_matrix, 0, n, completedvisit, mask);
    }

    private int travelRec(int[][] adjcency_matrix, int vertex, int len, int completedVisit, int mask){
        //if we have visited all nodes
        if(completedVisit == mask){
            return adjcency_matrix[vertex][0];
        }
        //we will select a non-visited node and travel to that node and so-on subsequently until no nodes are left to visit
        //for dp memo we will create all subset combinations and represent them by a mask
        if(memo[mask][vertex] != INF) return memo[mask][vertex];
        //calculate memo[vertex]
        for(int i = 0 ; i < len; i++){
            if((mask & (1 << i)) == 0){
                int newAns = adjcency_matrix[vertex][i] + travelRec(adjcency_matrix, i, len, completedVisit, (mask | (1 << i)) );
                memo[mask][vertex] = Math.min(memo[mask][vertex], newAns);
            }
        }
        return memo[mask][vertex];
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            arr[i][i] = 0;
        }
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
        int[][] arr = {
                {0, 22, 26, 30},
                {30, 0, 45, 35},
                {25, 45, 0, 60},
                {30, 35, 40, 0}
        };
        TravelingSalesperson tsp = new TravelingSalesperson("TSP");
        boolean[] choices = {false, true, false};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 3; idx < length ; i+= 1){
            sizes[idx][0] = i;
            sizes[idx][1] = i;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(tsp, 100, "Lab-Programs/src/LAB9/Data/");
        framework.initiate(sizes, choices);

//        int[] res = tsp.algorithm(arr,0);
//        System.out.println(res[0]);
    }

}
