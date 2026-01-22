package LAB1;

public class BubbleSortAlgo {

    public static void bubbleSort(int[] arr, int size){
        for(int i = 0 ; i < size - 1; i++){
            for(int j = 0 ; j < size - 1 - i ; j++){
                if(arr[j + 1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortOpposite(int[] arr, int size){
        for(int i = 0 ; i < size - 1; i++){
            for(int j = 0 ; j < size - 1 - i ; j++){
                if(arr[j + 1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] scales = {100,500,1000,2000,5000,10000,15000};
        //Used to test the algorithm
//        int n = 10;
//        int[] arr = new int[n];
//        LAB1.TimeAlgo.generateRandom(arr, n);
//        bubbleSort(arr, n);
//        for(int x : arr){
//            System.out.print(x + " ");
//        }

        for(int n : scales){
            int[] arr = new int[n];
            System.out.println("Worst Case Time for " + n + " elements is: " + TimeAlgo.worstCaseAlgoTimeArr(n));
            System.out.println("Best Case Time for " + n + " elements is: " + TimeAlgo.bestCaseAlgoTimeArr(n));
            System.out.println("Average Case Time for " + n + " elements is: " + TimeAlgo.averageCaseAlgoTimeArr(n));
            System.out.println();

        }
    }
}
