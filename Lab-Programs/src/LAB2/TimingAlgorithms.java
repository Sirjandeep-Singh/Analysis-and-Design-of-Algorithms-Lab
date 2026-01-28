package LAB2;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.FileWriter;

public class TimingAlgorithms{

    int CASES = 100;
    InsSort algo;
    public void TimingAlgorithms(){
//        CASES = 100;
        algo = new InsSort();
//        algo = k;
    }

    public static int generateRandom(int[] arr, int n){
        for(int i = 0 ; i < n ; i++){
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100000);
        }
        return ThreadLocalRandom.current().nextInt();
    }

    public long bestCaseTime(int size){
//            target = algo.bestCaseSetup
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[] arr = new int[size];
            int target = generateRandom(arr, size);
            InsSort.bestCaseSetup(arr);
//            target = BinSearch.bestCaseSetup(arr, target);
            long start = System.nanoTime();
            InsSort.algorithm(arr, target);
//            BinSearch.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public long worstCaseTime(int size){
//            target = algo.bestCaseSetup
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[] arr = new int[size];
            int target = generateRandom(arr, size);
            InsSort.worstCaseSetup(arr);
//            target = BinSearch.worstCaseSetup(arr, target);
            long start = System.nanoTime();
            InsSort.algorithm(arr, target);
//            BinSearch.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public long averageCaseTime(int size){
//            target = algo.bestCaseSetup
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[] arr = new int[size];
            int target = generateRandom(arr, size);
            InsSort.averageCaseSetup(arr);
//            target = BinSearch.averageCaseSetup(arr, target);
            long start = System.nanoTime();
            InsSort.algorithm(arr, target);
//            BinSearch.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public void initiate(String fileName, int[] cases){
        Path filePath = Paths.get("Lab-Programs/src/LAB2/Data/" + fileName + ".csv");
        try(PrintWriter pr = new PrintWriter(new FileWriter(filePath.toFile()))){
            pr.println("n,BestCase,AverageCase,WorstCase");
            for(int size : cases){
                System.out.println("Working Best");
                long bestCaseTime = bestCaseTime(size);
                System.out.println("Working worst");
                long worstCaseTime = worstCaseTime(size);
                System.out.println("Working average");
                long averageCaseTime = averageCaseTime(size);
                System.out.println("Best Case Time For "+ fileName + " For Size " + size + " is: " + bestCaseTime);
                System.out.println("Average Case Time For "+ fileName + " For Size " + size + " is: " + averageCaseTime);
                System.out.println("Worst Case Time For "+ fileName + " For Size " + size + " is: " + worstCaseTime);
                System.out.println();
                pr.println(size + "," + bestCaseTime + "," + averageCaseTime + "," + worstCaseTime);
                pr.flush();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
