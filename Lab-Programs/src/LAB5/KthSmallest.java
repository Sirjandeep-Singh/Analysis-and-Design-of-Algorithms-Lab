package LAB5;

import LAB3.Algorithm;
import LAB3.TimingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class KthSmallest implements Algorithm {
    private String name;

    public KthSmallest(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int target){
        solve(arr, target, 0, arr.length - 1);
        return 0;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target){
        Arrays.sort(arr);
        return 1;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){
        Arrays.sort(arr);
        return arr.length;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        return target % arr.length;
    }

    @Override
    public String getName(){
        return this.name;
    }

    private  int solve(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int pivotidx = partition(arr, start, end);
        if(pivotidx == target - 1) return arr[pivotidx];
        else if(pivotidx < target - 1) return solve(arr, target, pivotidx + 1, end);
        else return solve(arr, target, start, pivotidx - 1);
    }

    private  int partition(int[] arr, int start, int end){
        if(start == end) return start;
        int pivot = arr[start];
        int i = start;
        int j = end + 1;
        do{
            do{i++;} while(i <= end && arr[i] <= pivot);
            do{j--;}while (arr[j] > pivot);
            if(i < j) swap(arr, i , j);
        }while(i < j);

        swap(arr,start,j);
        return j;
    }

    private  void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        KthSmallest ks = new KthSmallest("KthSmallest");
//        int k = 5;
//        int[] arr = {2,3,5,1,53,1};
//        int j = -1;
//        if( k <= arr.length) j = ks.solve(arr, k, 0, arr.length - 1);
//        System.out.println(j);
        boolean[] choices = {true, true, true};
        int length = 100;
        int[] sizes = new int[length];
        int idx = 0;
        for(int i = 100 ; i <= 100 * length ; i += 100){
            sizes[idx] = i;
            idx++;
        }
        TimingAlgorithms framework = new TimingAlgorithms(ks,1000,"Lab-Programs/src/LAB5/Data/");
        framework.initiate(sizes,choices);
    }
}
