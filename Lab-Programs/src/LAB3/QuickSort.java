package LAB3;

import java.util.Arrays;

public class QuickSort implements Algorithm {
    String name;

    public QuickSort(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int target){
        quickSort(arr, 0, arr.length - 1);
        return 0;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){
        Arrays.sort(arr);
        return 0;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return this.name;
    }

    private void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int pivotIdx = partition(arr, start, end);
        quickSort(arr,start,pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, end);
    }

    private int partition(int[] arr, int start, int end){
        int i = start + 1;
        int j = end;
        while(i <= j){
            while(i <= end && arr[i] <= arr[start]) i++;
            while(arr[j] > arr[start]) j--;
            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, start, j);
        return j;
    }

    private void swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        QuickSort testing = new QuickSort("QuickSort");

        TimingAlgorithms frameWork = new TimingAlgorithms(testing, 1000);
        int[] n = new int[100];
        for(int i = 0 ; i < 100 ; i++){
            n[i] = i == 0? 100 : n[i-1] + 100;
        }
        frameWork.initiate(n);
    }

}
