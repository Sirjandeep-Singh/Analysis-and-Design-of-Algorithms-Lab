package LAB10;

import LAB3.Algorithm;
import LAB3.TimingAlgorithms;

import java.security.SecureRandom;

public class SubsetSum implements Algorithm {

    private String name;

    public SubsetSum(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int target){
        boolean res = solve(arr, target);
        return res ? 1 : 0;
    }

    private boolean solve(int[] arr, int target){
        return backtrack(arr, 0, 0, target);
    }

    private boolean backtrack(int[] arr, int index, int currentSum, int target){

        if(currentSum == target){
            return true;
        }

        if(index >= arr.length || currentSum > target){
            return false;
        }

        //Include current element
        if(backtrack(arr, index + 1, currentSum + arr[index], target)){
            return true;
        }

        //Exclude current element
        if(backtrack(arr, index + 1, currentSum, target)){
            return true;
        }

        return false;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target){
        // easiest: first element equals target
        arr[0] = target;
        return target;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        generate(arr);
        return arr.length; // moderate target
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){
        generate(arr);
        return Integer.MAX_VALUE; // impossible target → full exploration
    }

    @Override
    public String getName(){
        return this.name;
    }

    private void generate(int[] arr){
        SecureRandom sr = new SecureRandom();
        for(int i = 0; i < arr.length; i++){
            arr[i] = sr.nextInt(50) + 1; // small positives (important for pruning)
        }
    }

    public static void main(String[] args){

        SubsetSum ss = new SubsetSum("SubsetSum");

        int length = 100;
        boolean[] choices = {false, false, true};

        int[] sizes = new int[length];
        int idx = 0;

        for(int i = 5; i <= length * 5; i += 5){
            sizes[idx] = i;
            idx++;
        }

        TimingAlgorithms framework = new TimingAlgorithms(ss, 1000, "Lab-Programs/src/LAB10/Data/");

        framework.initiate(sizes, choices);
    }
}