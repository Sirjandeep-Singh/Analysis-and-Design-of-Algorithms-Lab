package LAB8;

import LAB3.Algorithm;
import LAB3.TimingAlgorithms;
import LAB5.Timing2DAlgorithms;

import java.util.Scanner;

public class MatrixChainMultiplication implements Algorithm {
    private String name;
    private int[][] memo;
    private int[][] s;
    public MatrixChainMultiplication(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] dimMatrix, int source){
        int len = dimMatrix.length - 1;
        memo = new int[len][len];
        s = new int[len][len];

        for(int i = 0 ; i < len; i++){
            memo[i][i] = 0;
        }

        for(int l = 2; l <= len; l++){
            for(int i = 0; i < len - l + 1 ; i++){
                int j = i + l - 1;
                memo[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k < j; k++){
                    int q = memo[i][k] + memo[k+1][j] + (dimMatrix[i] * dimMatrix[k+1] * dimMatrix[j + 1]);
                    if(q < memo[i][j]){
                        memo[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return memo[0][len - 1];
    }


    @Override
    public int bestCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return name;
    }

    private int[] input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of dimension");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
                System.out.println("Enter dimension" + (i + 1));
                int dim = sc.nextInt();
                arr[i] = dim;
            }
        return arr;
    }


    public static void main(String[] args){
//        int[] dimMatrix = {5,4,6,2,7};
//        int[] dimMatrix = {2,1,3,4};
//        int[] dimMatrix = {1,2,3,4,3};
//        int[] dimMatrix = {1,2};
        int length = 100;
        int[] sizes = new int[length];
        int idx = 0;
        for(int i = 5 ; idx < length ; i += 5){
            sizes[idx] = i;
            idx++;
        }

        boolean[] choices = {false, true, false};
        MatrixChainMultiplication mcm = new MatrixChainMultiplication("MatrixChainMultiplication");
        TimingAlgorithms framework = new TimingAlgorithms(mcm,1000,"Lab-Programs/src/LAB8/Data/");
        framework.initiate(sizes, choices);
//        System.out.println(mcm.algorithm(dimMatrix,0));
    }

}
