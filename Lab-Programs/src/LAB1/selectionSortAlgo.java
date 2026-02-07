package LAB1;

public class selectionSortAlgo {
    public static void selectionSort(int[] arr, int size){
        for(int i = 0 ; i < size - 1 ; i ++){
            int j = i;
            for(int k = i + 1 ; k < size ; k++){
                if(arr[k] < arr[j]){
                    j = k;
                }
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void oppositeselectionSort(int[] arr, int size){
        for(int i = 0 ; i < size - 1 ; i ++){
            int j = i;
            for(int k = i + 1 ; k < size ; k++){
                if(arr[k] > arr[j]){
                    j = k;
                }
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args){
//        int[] scales = {100,500,1000,2000,5000,10000,15000};
//        Used to test the algorithm
//        LAB1.TimeAlgo.generateRandom(arr, n);
//        selectionSort(arr, n);
//        for(int x : arr){
//            System.out.print(x + " ");
////
//        for(int n : scales){
//            int[] arr = new int[n];
//            System.out.println("Worst Case Time for " + n + " elements is: " + TimeAlgo.worstCaseAlgoTimeArr(n, "SelectionSort"));
//            System.out.println("Best Case Time for " + n + " elements is: " + TimeAlgo.bestCaseAlgoTimeArr(n, "SelectionSort"));
//            System.out.println("Average Case Time for " + n + " elements is: " + TimeAlgo.averageCaseAlgoTimeArr(n, "SelectionSort"));
//            System.out.println();
//
//        }

        int[] scales = new int[30];
        for(int i = 0 ; i < 30 ; i++){
            scales[i] = i == 0 ? 500 : scales[i - 1 ] + 500;
        }
        TimeAlgo.controller(scales, "SelectionSort");
    }
}
