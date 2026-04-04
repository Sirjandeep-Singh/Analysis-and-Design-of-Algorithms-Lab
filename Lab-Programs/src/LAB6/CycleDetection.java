package LAB6;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

import java.security.SecureRandom;

public class CycleDetection implements TwoDimAlgorithm {
    private final String name;

    public CycleDetection(String name){
        this.name = name;
    }

    public int[] solve(int[][] adjMatrix, int source){
        int n = adjMatrix.length;
        DSU forests = new DSU(n);
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n; j++){
                if(adjMatrix[i][j] == 0) continue;
                int px = forests.find(i);
                int py = forests.find(j);
                if(px == py){
                    return new int[]{1,i,j};
                }
                forests.union(i,j);
            }
        }
       return new int[]{0,-1,-1};
    }



    @Override
    public int[] algorithm(int[][] arr, int target){
        return solve(arr,target);
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        generateRandom(arr, arr.length, arr[0].length);
        createLoop(arr);
        return target % arr.length;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        generateRandom(arr, arr.length, arr[0].length);
        return target % arr.length;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        setToZero(arr);
        generateAcyclic(arr, arr.length, arr[0].length);
        return target % arr.length;
    }

    @Override
    public String getName(){
        return name;
    }

    private void createLoop(int[][] arr){
        arr[0][1] = 1;
        arr[1][0] = 1;
        arr[1][2] = 1;
        arr[2][1] = 1;
        arr[2][0] = 1;
        arr[0][2] = 1;
    }

    private void setToZero(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j < arr.length; j++){
                arr[i][j] = 0;
            }
        }
    }

    private void generateAcyclic(int[][] arr, int row, int col){
        for(int i = 0 ; i < row - 1 ; i++){
            arr[i][i + 1] = 1;
            arr[i + 1][i] = 1;
        }
    }

    private static int generateRandom(int[][] arr, int row, int col){
        SecureRandom random = new SecureRandom();
        for(int i = 0 ; i < row ; i++){
            for(int j = i + 1 ; j < col ; j++){
                arr[i][j] = random.nextInt(0, 1000000000) % 2;
                arr[j][i] = arr[i][j];
            }
        }

        return random.nextInt(0, 1000000000);
    }


    public static void main(String[] args){
        CycleDetection cd = new CycleDetection("CycleDetection");
//        int[][] adj = {
//                {0, 1, 0, 0},
//                {1, 0, 1, 0},
//                {0, 1, 0, 1},
//                {0, 0, 1, 0}
//        };

//        int[][] adj = {
//                {0, 1, 1, 0},
//                {1, 0, 1, 0},
//                {1, 1, 0, 0},
//                {0, 0, 0, 0}
//        };
//
//        int[] result = cd.solve(adj,0);
//        System.out.println("Result: " + result[0] + " \nPossible Cycle is: " + result[1] + " & " + result[2]);

        boolean[] choices = {true, false, true};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 5; i <= 500 ; i+= 5){
            sizes[idx][0] = i;
            sizes[idx][1] = i;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(cd, 1000, "Lab-Programs/src/LAB6/Data/");
        framework.initiate(sizes, choices);

    }
}
