package LAB7;

import LAB5.TwoDimAlgorithm;

import java.util.*;

public class MSGShortestPath implements TwoDimAlgorithm {
    //This algorithm assumes that a vertex denoted by a higher number always
    // exists at a later stage compared to a vertex denoted with a smaller number
    private String name;
    private ArrayList<int[]> vertices;
    private int[] cost;
    private int[] d;
    private int[] p;
    public MSGShortestPath(String name){
        this.name = name;
    }

    @Override
    public int[] algorithm(int[][] adjMatrix, int source){
        source = 0;
        int len = adjMatrix.length;
        cost = new int[len];
        d = new int[len];
        //set the memoized array for dp
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[len - 1] = 0;
        int shortestPath = solveRecFwd(adjMatrix,0, len);
        int numOfStages = traverse(adjMatrix, source, 0);
        printPath(d, numOfStages);
        return new int[]{shortestPath};
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
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

    private int solveRecFwd(int[][] adjMatrix, int currentVertex, int len){
        if(cost[currentVertex] != Integer.MAX_VALUE) return cost[currentVertex];
        for(int i = currentVertex + 1 ; i < len ; i++){
            if(adjMatrix[currentVertex][i] != 0){
                int nextStageDist = solveRecFwd(adjMatrix, i, len);
                if(nextStageDist + adjMatrix[currentVertex][i] < cost[currentVertex]){
                    cost[currentVertex] = nextStageDist + adjMatrix[currentVertex][i];
                    d[currentVertex] = i;
                }
            }
        }
        return cost[currentVertex];
    }

    //For Backward approach we start with second last vertex unlike the forward approach
    //memo[len - 1] = 0 by default
    private int solveRecBwd(int[][] adjMatrix, int currentVertex, int len){
        for(int i = currentVertex + 1 ; i < len ; i++){
            if(adjMatrix[currentVertex][i] != 0){
                int currNxtStgDist = adjMatrix[currentVertex][i] + cost[i];
                if(currNxtStgDist < cost[currentVertex]){
                    cost[currentVertex] = currNxtStgDist;
                    d[currentVertex] = i;
                }
            }
        }
        if(currentVertex != 0 ) return solveRecBwd(adjMatrix,currentVertex - 1, len);
        return cost[0];
    }

    private void printPath(int[]stageChoice, int numOfStages){
        p = new int[numOfStages];
        p[0] = 0;
        p[numOfStages - 1] = stageChoice.length - 1;
        for(int i = 1 ; i < numOfStages - 1; i++){
            p[i] = d[p[i - 1]];
        }

        for(int pathVertex : p){
            System.out.print(pathVertex + " --> ");
        }
        System.out.println();
    }

    private int[][] input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            System.out.println("Enter Edges for vertex" + (i + 1));
            for(int j = 0 ; j < n ; j++){
                System.out.println("Enter Edge" + (i + 1) + " -->?" + (j + 1));
                int edge = sc.nextInt();

            }
        }

        return arr;
    }

    private int traverse(int[][] adjMatrix, int source, int stage){

        for(int i = 0 ; i < adjMatrix.length ; i++){
            if(adjMatrix[source][i] > 0){
                stage = traverse(adjMatrix, i, stage);
                break;
            }
        }
        return stage + 1;
    }

    public static void main(String[] args){
        int[][] adjMatrix = {
                { 0,  2,  1,  3,  0,  0,  0,  0},
                { 0,  0,  0,  0,  2,  3,  0,  0},
                { 0,  0,  0,  0,  6,  7,  0,  0},
                { 0,  0,  0,  0,  6,  8,  9,  0},
                { 0,  0,  0,  0,  0,  0,  0,  6},
                { 0,  0,  0,  0,  0,  0,  0,  4},
                { 0,  0,  0,  0,  0,  0,  0,  5},
                { 0,  0,  0,  0,  0,  0,  0,  0}
        };


//        int[][] adjMatrix = {
//                {0,1,1,0},{0,0,0,1},{0,0,0,1},{0,0,0,0}
//        };
        MSGShortestPath msgsp = new MSGShortestPath("MSGShortestPath");
        int[] temp = msgsp.algorithm(adjMatrix,0);
        System.out.println("Shortest Path is: " + temp[0]);

    }


}
