package LAB10;

import LAB3.Algorithm;
import LAB3.TimingAlgorithms;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> cs = new ArrayList<>();
        backtrack(arr, 0, 0, target, cs);
        return true;
    }

    public static void backtrack(int[] arr, int index, int currentSum, int target, List<Integer> currentSet) {

        if (currentSum == target) {
            System.out.println(currentSet);
            return; // don't return true, continue searching for more
        }

        if (index >= arr.length || currentSum > target) {
            return;
        }

        currentSet.add(arr[index]);
        backtrack(arr, index + 1, currentSum + arr[index], target, currentSet);

        currentSet.remove(currentSet.size() - 1);

        backtrack(arr, index + 1, currentSum, target, currentSet);
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

        int[] set = {5, 10, 12, 13, 15, 18};
        int target = 30;
        ss.algorithm(set, target);

//        int length = 100;
//        boolean[] choices = {false, false, true};
//
//        int[] sizes = new int[length];
//        int idx = 0;
//
//        for(int i = 5; i <= length * 5; i += 5){
//            sizes[idx] = i;
//            idx++;
//        }
//
//        TimingAlgorithms framework = new TimingAlgorithms(ss, 1000, "Lab-Programs/src/LAB10/Data/");
//
//        framework.initiate(sizes, choices);
    }
}