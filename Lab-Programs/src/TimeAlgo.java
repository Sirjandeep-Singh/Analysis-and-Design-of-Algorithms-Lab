import java.util.concurrent.ThreadLocalRandom;
import java.time.Instant;
public class TimeAlgo {
    private static int CASES;

    public static int generateRandom(int[] arr, int n){
        for(int i = 0 ; i < n ; i++){
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100000);
        }
        return ThreadLocalRandom.current().nextInt();
    }

    public static long worstCaseAlgoTimeArr(int n){
        CASES = 1000;
        int[] arr = new int[n];
        long totalTimeTaken = 0;
        for(int i = 0; i < CASES; i++){
            int target = generateRandom(arr, n);
            //2
            selectionSortAlgo.oppositeselectionSort(arr, n);
            //3
            //BubbleSortAlgo.bubbleSortOpposite(arr, n);
            Instant st = Instant.now();
            //1
            //LinearSearch.linearSearch(arr, -1, 0, n);
            //2
            selectionSortAlgo.selectionSort(arr, n);
            //3
            //BubbleSortAlgo.bubbleSort(arr, n);
            Instant end = Instant.now();
            long duration = java.time.Duration.between(st,end).toNanos();
            totalTimeTaken += duration;
        }
        return totalTimeTaken/1000 ;
    }

    public static long bestCaseAlgoTimeArr(int n){
        CASES = 1000;
        int[] arr = new int[n];
        long totalTimeTaken = 0;
        for(int i = 0; i < CASES; i++){
            int target = generateRandom(arr, n);
            //2
            selectionSortAlgo.selectionSort(arr, n);
            //3
            //BubbleSortAlgo.bubbleSort(arr, n);
            Instant st = Instant.now();
            //1
            //LinearSearch.linearSearch(arr, arr[0], 0, n);
            //2
            selectionSortAlgo.selectionSort(arr, n);
            //3
            //BubbleSortAlgo.bubbleSort(arr, n);
            Instant end = Instant.now();
            long duration = java.time.Duration.between(st,end).toNanos();
            totalTimeTaken += duration;
        }
        return totalTimeTaken/1000 ;
    }

    public static long averageCaseAlgoTimeArr(int n){
        CASES = 1000;
        int[] arr = new int[n];
        long totalTimeTaken = 0;
        for(int i = 0; i < CASES; i++){
            int target = generateRandom(arr, n);
            Instant st = Instant.now();
            //1
            //LinearSearch.linearSearch(arr, target, 0, n);
            //2
            selectionSortAlgo.selectionSort(arr, n);
            //3
            //BubbleSortAlgo.bubbleSort(arr, n);
            Instant end = Instant.now();
            long duration = java.time.Duration.between(st,end).toNanos();
            totalTimeTaken += duration;
        }
        return totalTimeTaken/1000 ;
    }
}
