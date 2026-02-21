package LAB4;

import java.util.Arrays;

public class BinSearchforUneven {
    private static int algorithm(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int pivot = start + (end-start)/3;
            if(arr[pivot] == target) return pivot;
            if(target < arr[pivot]){
                end = pivot - 1;
            }
            else{
                start = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] arr = {1,3,5,1,3,2};
        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(algorithm(arr,5));
    }
}
