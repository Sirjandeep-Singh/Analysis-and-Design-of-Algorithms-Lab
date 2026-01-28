package LAB2;
import java.util.Arrays;
//public class BinSearch implements Algorithm{
//
//    @Override
//    public int algorithm(int[] arr, int target){
//        int start = 0;
//        int end = arr.length;
//        while(start <= end){
//            int mid = (end - start)/2 + start;
//            if(arr[mid] == target) return mid;
//            else if(arr[mid] < target) start = mid + 1;
//            else end = mid - 1;
//        }
//        return -1;
//    }
//
//    @Override
//    public int averageCaseSetup(int[] arr) {
//        return 0;
//    }
//
//    @Override
//    public int worstCaseSetup(int[] arr) {
//        return 0;
//    }
//
//    @Override
//    public int bestCaseSetup(int[] arr) {
//        return 0;
//    }
//
//    public static void main(String[] args){
//        BinSearch obj = new BinSearch();
//        int[] arr = {1, 3, 31, 54, 13, 542};
//        System.out.println(obj.algorithm(arr, 542));
//    }
//}

import java.util.Arrays;

public class BinSearch {

    public static int algorithmit(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static int algorithm(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int mid = (end - start)/2 + start;
        if(arr[mid] == target) return mid;
        if(arr[mid] < target){
            return algorithm(arr, target, mid + 1, end);
        }else{
            return algorithm(arr, target, start, mid - 1);
        }
    }

    public static int averageCaseSetup(int[] arr, int target) {
        Arrays.sort(arr);
        return target;
    }

    public static int worstCaseSetup(int[] arr, int target) {
        Arrays.sort(arr);
        return -1;
    }

    public static int bestCaseSetup(int[] arr, int target) {
        Arrays.sort(arr);
        int mid = arr.length/2;
        return arr[mid];
    }

    public static void main(String[] args){
        int[] cases = {100,200,500,1000,2000,5000, 10000, 100000};

//        int[] cases = {100,200,500,1000,2000,5000,10000,100000};
//        BinSearch obj = new BinSearch();
//        int[] arr = {1, 3, 31, 54, 13, 542};
//        System.out.println(algorithm(arr, -1, 0, 5));
        TimingAlgorithms time = new TimingAlgorithms();
        time.initiate("binary_Search", cases);
    }
}
