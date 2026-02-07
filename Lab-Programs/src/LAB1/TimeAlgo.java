package LAB1;

import java.util.concurrent.ThreadLocalRandom;
import java.time.Instant;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TimeAlgo {
    private static int CASES;

    public static int generateRandom(int[] arr, int n){
        for(int i = 0 ; i < n ; i++){
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100000);
        }
        return ThreadLocalRandom.current().nextInt();
    }

    public static void controller(int[] cases, String FileName){

        Path filePath = Paths.get("Lab-Programs/src/LAB1/Data/" + FileName + ".csv");
        try(PrintWriter pr = new PrintWriter(new FileWriter(filePath.toFile()))){
            pr.println("n,worst,best,average");
            for(int n : cases){
                long worst = worstCaseAlgoTimeArr(n);
                long best = bestCaseAlgoTimeArr(n);
                long average = averageCaseAlgoTimeArr(n);
                System.out.println("Worst Case Time for " + FileName + " algorithm, for " + n + " elements is: " + worst);
                System.out.println("Best Case Time for " + FileName + " algorithm, for " + n + " elements is: " + best);
                System.out.println("Average Case Time for " + FileName + " algorithm, for " + n + " elements is: " + average);
                System.out.println();
                pr.println(n + "," + worst + "," + best + "," + average);
                pr.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

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
//            LAB1.BubbleSortAlgo.bubbleSortOpposite(arr, n);
            long st = System.nanoTime();
            //1
//            LAB1.LinearSearch.linearSearch(arr, -1, 0, n);
            //2
            selectionSortAlgo.selectionSort(arr, n);
            //3
//            LAB1.BubbleSortAlgo.bubbleSort(arr, n);
            long end = System.nanoTime();
            long duration = end - st;
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
//            LAB1.BubbleSortAlgo.bubbleSort(arr, n);
            long st = System.nanoTime();
            //1
//            LAB1.LinearSearch.linearSearch(arr, arr[0], 0, n);
            //2
            selectionSortAlgo.selectionSort(arr, n);
            //3
//            LAB1.BubbleSortAlgo.bubbleSort(arr, n);
            long end = System.nanoTime();
            long duration = end - st;
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
            long st = System.nanoTime();
            //1
//            LAB1.LinearSearch.linearSearch(arr, target, 0, n);
            //2
            selectionSortAlgo.selectionSort(arr, n);
            //3
//            LAB1.BubbleSortAlgo.bubbleSort(arr, n);
            long end = System.nanoTime();
            long duration = end - st;
            totalTimeTaken += duration;
        }
        return totalTimeTaken/1000 ;
    }
}
