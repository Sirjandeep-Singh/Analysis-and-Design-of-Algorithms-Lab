package LAB5;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KnapSack implements TwoDimAlgorithm {
    private int method;
    private String name;
    private double[][] arr;
    public KnapSack(String name, int method){
        this.method = method;
        this.name = name;
    }

    @Override
    public int[] algorithm(int[][] arr, int target){
        solve(this.arr,method,target);
        return null;
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        this.arr = new double[arr.length][3];
        generate(this.arr);
        return target;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        this.arr = new double[arr.length][3];
        generate(this.arr);
        return target;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        this.arr = new double[arr.length][3];
        generate(this.arr);
        return target;
    }

    @Override
    public String getName(){
        return name;
    }

    private  void generate(double[][] arr){
        SecureRandom sr = new SecureRandom();

        for(int i = 0; i < arr.length; i++){
            arr[i][0] = sr.nextInt(1,1000);
            arr[i][1] = sr.nextInt(0 , 1000);
            arr[i][2] = arr[i][1]/ arr[i][0];
        }
    }

    private  double solve(double[][] arr, int method, int maxWeight){
        double profit = 0;
        sort(arr, method);
        //Applying greedy for all 3 cases
        for(int i = 0; i < arr.length; i++){
            if(maxWeight == 0) break;
            int k = weightBought(arr[i], maxWeight);
            maxWeight -= k;
            profit += arr[i][2] * k;
        }

        return profit;
    }

    private  int weightBought(double[] arr, int currentSpace){
        if(arr[1] > currentSpace) return currentSpace;
        return (int)arr[1];
    }

    private  void sort(double[][] arr, int method){
           bubbleSort(arr, method);
    }

    private  void bubbleSort(double[][] arr, int method){
        if(method == 1){
            for(int i = 0 ; i < arr.length - 1; i++){
                for(int j = 0; j < arr.length - 1 - i ; j++){
                    if((arr[j][0] < arr[j + 1][0]) || (arr[j][0] == arr[j + 1][0] && arr[j][1] > arr[j + 1][1])){
                        swap(arr, j ,j + 1);
                    }
                }
            }
        }

        if(method == 2){
            for(int i = 0 ; i < arr.length - 1; i++){
                for(int j = 0; j < arr.length - 1 - i ; j++){
                    if((arr[j][1] > arr[j + 1][1]) || (arr[j][1] == arr[j + 1][1] && arr[j][0] < arr[j + 1][0])){
                        swap(arr, j ,j + 1);
                    }
                }
            }
        }

        if(method == 3){
            for(int i = 0 ; i < arr.length - 1; i++){
                for(int j = 0; j < arr.length - 1 - i ; j++){
                    if((arr[j][2] < arr[j + 1][2]) || (arr[j][2] == arr[j + 1][2] && arr[j][1] > arr[j + 1][1])){
                        swap(arr, j ,j + 1);
                    }
                }
            }
        }
    }



    private  void swap(double[][] arr, int i, int j){
        double[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private  double[][] copy(double[][] arr){
        double[][] res = new double[arr.length][3];
        for(int i = 0 ; i < res.length; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                res[i][j] = arr[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args){
        KnapSack ks = new KnapSack("KnapSack",3);

//        String[] cleanWords = {"Greedy while prioritizing weight: ",
//                "Greedy while prioritizing profit: ", "Greedy while prioritizing profit/weight ratio: "};
//        int cleanIdx = 0;
//        SecureRandom sr = new SecureRandom();
//        int maxWeight = sr.nextInt(1, 1000);
//        int[] methods = {1, 2 ,3};
//        double[][] arr = new double[10][3];
//        ks.generate(arr);
//        for(int method : methods){
//            double maxProfit = ks.solve(ks.copy(arr) , method, maxWeight);
//            System.out.println(cleanWords[cleanIdx] + maxProfit);
//            cleanIdx++;
//        }

        boolean[] choices = {false, false, true};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 100; i <= 10000 ; i+= 100){
            sizes[idx][0] = i;
            sizes[idx][1] = 3;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(ks, 1000, "Lab-Programs/src/LAB5/Data/");
        framework.initiate(sizes, choices);
    }
}
