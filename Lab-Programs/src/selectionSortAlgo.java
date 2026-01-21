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
        int[] scales = {100,500,1000,2000,5000,10000,15000};
//        Used to test the algorithm
//        TimeAlgo.generateRandom(arr, n);
//        selectionSort(arr, n);
//        for(int x : arr){
//            System.out.print(x + " ");
//
        for(int n : scales){
            int[] arr = new int[n];
            System.out.println("Worst Case Time for " + n + " elements is: " + TimeAlgo.worstCaseAlgoTimeArr(n));
            System.out.println("Best Case Time for " + n + " elements is: " + TimeAlgo.bestCaseAlgoTimeArr(n));
            System.out.println("Average Case Time for " + n + " elements is: " + TimeAlgo.averageCaseAlgoTimeArr(n));
            System.out.println();

        }
    }
}
