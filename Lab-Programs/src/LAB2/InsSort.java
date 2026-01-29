package LAB2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class InsSort implements Algorithm {
    String name;
    public InsSort(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int t){
        int n = arr.length;
        for(int i = 1 ; i < n ; i++){
            int j = i - 1;
            int key = arr[i];
            while(j > 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return -1;
    }


    @Override
    public int bestCaseSetup(int[] arr, int target){
        Arrays.sort(arr);
        return -1;
    }


    @Override
    public int worstCaseSetup(int [] arr, int target){
        Arrays.sort(arr);
        int j = arr.length - 1;
        for(int i = 0 ; i < arr.length/2 ; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }

         return -1;
    }


    @Override
    public int averageCaseSetup(int[] arr, int target){
        return -1;
    }

    @Override
    public String getName(){
        return this.name;
    }

    public static void main(String[] args){
//        int[] cases = {100,200,500,1000,2000,5000,10000,15000};

        int[] cases = {100,200,500,1000,2000,5000,10000,100000};
        InsSort insObj = new InsSort("insertion_Sort");
        TimingAlgorithms time = new TimingAlgorithms(insObj,1000);
        time.initiate(cases);

//        int[] arr = {1, 3, 31, 54, 13, 542};
//        obj.algorithm(arr, 0);
//        for(int i : arr){
//            System.out.print(i + ", ");
//        }
    }


}

//public class InsSort{
//    String name;
//    public InsSort(){
//        name = "insertion_Sort";
//    }
//
//
//    public static int algorithm(int[] arr, int t){
//        int n = arr.length;
//        for(int i = 1 ; i < n ; i++){
//            int j = i - 1;
//            int key = arr[i];
//            while(j > 0 && key < arr[j]){
//                arr[j + 1] = arr[j];
//                j--;
//            }
//            arr[j + 1] = key;
//        }
//        return -1;
//    }
//
//
//
//    public static int bestCaseSetup(int[] arr){
//        Arrays.sort(arr);
//        return -1;
//    }
//
//
//    public static int worstCaseSetup(int [] arr){
//        Arrays.sort(arr);
//        int j = arr.length - 1;
//        for(int i = 0 ; i < arr.length/2 ; i++){
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//            j--;
//        }
//
//        return -1;
//    }
//
//
//    public static int averageCaseSetup(int[] arr){
//        return -1;
//    }
//
//    public static void main(String[] args){
////        int[] cases = {100,200,500,1000,2000,5000,10000,15000};
//
////        int[] cases = {100,200,500,1000,2000,5000,10000,100000};
////        //InsSort obj = new InsSort();
////        TimingAlgorithms time = new TimingAlgorithms();
////        time.initiate("insertion_Sort", cases);
//
////        int[] arr = {1, 3, 31, 54, 13, 542};
////        obj.algorithm(arr, 0);
////        for(int i : arr){
////            System.out.print(i + ", ");
////        }
//    }
//
//
//}
