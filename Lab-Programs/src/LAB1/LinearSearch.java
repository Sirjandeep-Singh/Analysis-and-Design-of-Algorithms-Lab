package LAB1;

public class LinearSearch {

    public static boolean linearSearch(int[] arr, int target, int idx, int size){
        if(idx >= size) return false;
        if(arr[idx] == target) return true;
        return linearSearch(arr, target, idx + 1, size);
    }

    public static void main(String[] args){
        int[] scales = new int[1000];
        for(int i = 0 ; i < 1000 ; i++){
            scales[i] = i == 0 ? 100 : scales[i - 1 ] + 100;
        }
        TimeAlgo.controller(scales, "LinearSearch");
//        for(int n : cases){
//            System.out.println("Worst Case Time for " + n + " elements is: " + TimeAlgo.worstCaseAlgoTimeArr(n, "LinearSearch"));
//            System.out.println("Best Case Time for " + n + " elements is: " + TimeAlgo.bestCaseAlgoTimeArr(n, "LinearSearch"));
//            System.out.println("Average Case Time for " + n + " elements is: " + TimeAlgo.averageCaseAlgoTimeArr(n, "LinearSearch"));
//            System.out.println();
//        }
    }
}
