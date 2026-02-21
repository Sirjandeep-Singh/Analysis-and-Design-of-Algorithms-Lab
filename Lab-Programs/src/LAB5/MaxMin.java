package LAB5;

import LAB3.Algorithm;
import LAB3.TimingAlgorithms;

import java.security.SecureRandom;
import java.util.Arrays;

public class MaxMin implements Algorithm {
    private String name;

    public MaxMin(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int target){
        solve(arr);
        return 0;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){ return 0; }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return this.name;
    }

    private  int[] solve(int[] arr){
        int[] res = new int[2];
        res = divideAndConquer(arr, 0, arr.length - 1);
        return res;
    }

    private  int[] divideAndConquer(int[] arr, int start, int end){
        if(start == end) return new int[]{arr[start], arr[start]};
        int mid = (start + end) / 2;
        int[] carry = new int[2];
        int[] left = divideAndConquer(arr, start, mid);
        int[] right = divideAndConquer(arr,mid + 1, end);
        carry[0] = Math.max(left[0], right[0]);
        carry[1] = Math.min(left[1], right[1]);
        return carry;
    }

    private  void generate(int[] arr){
        SecureRandom sr = new SecureRandom();
        for(int i = 0; i < arr.length; i++){
            arr[i] = sr.nextInt();
        }
    }

    public static void main(String[] args){
        MaxMin mm = new MaxMin("MaxMin");
//        int[] arr = new int[10];
//        mm.generate(arr);
//        for(int num : arr){
//            System.out.print(num + " ,");
//        }
//        System.out.println();
//        int[] res = mm.solve(arr);
//        for(int num : res){
//            System.out.println(num);
//        }

        int length = 100;
        boolean[] choices = {false, false, true};
        int idx = 0;
        int[] sizes = new int[length];
        for(int i = 100; i <= length*100 ; i += 100){
            sizes[idx] = i;
            idx++;
        }
        TimingAlgorithms framework = new TimingAlgorithms(mm,1000,"Lab-Programs/src/LAB5/Data/");
        framework.initiate(sizes, choices);
    }
}
