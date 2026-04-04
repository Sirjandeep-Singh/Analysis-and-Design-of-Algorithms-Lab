package LAB6;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;
import LAB5.QuickSort2D;

import java.security.SecureRandom;

public class ActivitySelection implements TwoDimAlgorithm {
    private final String name;
    private double[][] privArr;
    public ActivitySelection(String name){
        this.name = name;
    }

    public ActivitySelection(String name, int[][] adjMatrix){
        this.name = name;
        this.privArr = convert2DIntToDouble(adjMatrix);
    }

    public int[] solve(int[][] adjMatrix, int endTimeIdx){
        //sort the array (for testing the algo Only not timing)
//        privArr = convert2DIntToDouble(adjMatrix);
//        QuickSort2D.QuickSort_2D(privArr , endTimeIdx,0, adjMatrix.length - 1);
        //solving
        int totalActivities = 0;
        double prevEndTime = -Double.MAX_VALUE;
        for(int i = 0 ; i < privArr.length; i++){
            if(privArr[i][0] >= prevEndTime){
                totalActivities++;
                prevEndTime = privArr[i][1];
            }
        }
        return new int[]{totalActivities};
    }

    private double[][] convert2DIntToDouble(int[][] adjMatrix){
        double[][] temp = new double[adjMatrix.length][2];
        for(int i = 0; i < adjMatrix.length; i++){
            for(int j = 0; j < 2; j++){
                temp[i][j] = adjMatrix[i][j];
            }
        }
        return temp;
    }

    @Override
    public int[] algorithm(int[][] arr, int target){
        return solve(arr,1);
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        privArr = new double[arr.length][2];
        generateRandom(privArr, arr.length, arr[0].length);
        QuickSort2D.QuickSort_2D(privArr , 1,0, privArr.length - 1);
        return target % arr.length;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        privArr = new double[arr.length][2];
        generateRandom(privArr, arr.length, arr[0].length);
        QuickSort2D.QuickSort_2D(privArr , 1,0, privArr.length - 1);
        return target % arr.length;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        privArr = new double[arr.length][2];
        generateRandom(privArr, arr.length, arr[0].length);
        QuickSort2D.QuickSort_2D(privArr , 1,0, privArr.length - 1);
        return target % arr.length;
    }

    @Override
    public String getName(){
        return name;
    }

    public static double generateRandom(double[][] arr, int row, int col){
        SecureRandom random = new SecureRandom();
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(j == 0){
                    arr[i][j] = random.nextDouble(0, 1000000000);
                }
                else{

                    arr[i][j] = arr[i][j-1] + random.nextDouble(0, 1000000000);
                }
            }
        }

        return random.nextDouble(0, 1000000000);
    }

    public static void main(String[] args){
//        int[][] arr = {
//                {1, 3},
//                {2, 5},
//                {4, 6},
//                {6, 7},
//                {5, 8},
//                {8, 9}
//        };
//        int[]result = as.solve(arr ,1);
//        System.out.println(result[0]);

        ActivitySelection as = new ActivitySelection("ActivitySelection");
        boolean[] choices = {false, true, false};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 100; i <= 10000 ; i+= 100){
            sizes[idx][0] = i;
            sizes[idx][1] = 2;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(as, 1000, "Lab-Programs/src/LAB6/Data/");
        framework.initiate(sizes, choices);
    }
}
