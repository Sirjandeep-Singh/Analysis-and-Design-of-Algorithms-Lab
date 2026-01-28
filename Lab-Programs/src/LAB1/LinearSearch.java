package LAB1;

public class LinearSearch {

    public static boolean linearSearch(int[] arr, int target, int idx, int size){
        if(idx >= size) return false;
        if(arr[idx] == target) return true;
        return linearSearch(arr, target, idx + 1, size);
    }

    public static void main(String[] args){
        int[] cases = {100, 500, 1000, 2000, 5000, 10000, 15000,};

        TimeAlgo.controller(cases, "LinearSearch");
//        for(int n : cases){
//            System.out.println("Worst Case Time for " + n + " elements is: " + TimeAlgo.worstCaseAlgoTimeArr(n, "LinearSearch"));
//            System.out.println("Best Case Time for " + n + " elements is: " + TimeAlgo.bestCaseAlgoTimeArr(n, "LinearSearch"));
//            System.out.println("Average Case Time for " + n + " elements is: " + TimeAlgo.averageCaseAlgoTimeArr(n, "LinearSearch"));
//            System.out.println();
//        }
    }
}
