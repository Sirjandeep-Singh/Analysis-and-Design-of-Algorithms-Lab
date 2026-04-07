package LAB7;

import LAB5.TwoDimAlgorithm;

import java.util.*;

public class MultiStageGraphTraversal implements TwoDimAlgorithm {
    private String name;
    private ArrayList<int[]> vertices;
    public MultiStageGraphTraversal(String name){
        this.name = name;
    }

    @Override
    public int[] algorithm(int[][] adjMatrix, int source){
        solve(adjMatrix, source);
        return null;
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

//    private int solve(int[][] adjMatrix, int source){
//        HashMap<Integer,Boolean> underProcessing = new HashMap<>();
//
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(source);
//        underProcessing.put(source, true);
//
//        //offer poll
//        int stages = 0;
//        while(!q.isEmpty()){
//            int qlen = q.size();
//            for(int i = 0 ; i < qlen ; i++){
//                int node = q.poll();
//                for(int j = 0; j < adjMatrix.length; j++){
//                    if(adjMatrix[node][j] > 0 && !underProcessing.getOrDefault(j, false)){
//                        q.offer(j);
//                        underProcessing.put(j, true);
//                    }
//                }
//            }
//        stages++;
//        }
//        return stages;
//    }

    private int solve(int[][] adjMatrix, int source){
        int stages = 0;
        stages = traverse(adjMatrix, source, stages);
        return stages;
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
        int[][] adjMatrix = {{0,1,1,0,0,0,0,0,0},
                {0,0,0,1,0,1,0,0,0},
                {0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,1,1,0},
                {0,0,0,0,0,0,1,1,0},
                {0,0,0,0,0,0,1,1,0},
                {0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0}
        };


//        int[][] adjMatrix = {
//                {0,1,1,0},{0,0,0,1},{0,0,0,1},{0,0,0,0}
//        };

        MultiStageGraphTraversal msg = new MultiStageGraphTraversal("Hello");
        System.out.println(msg.solve(adjMatrix,0));
    }


}
