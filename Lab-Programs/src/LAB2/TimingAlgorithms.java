package LAB2;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.PrintWriter;
import java.io.FileWriter;

public class TimingAlgorithms{

    int CASES;
    Algorithm algo;
    public TimingAlgorithms(Algorithm k, int CASES){
        this.CASES = CASES;
        algo = k;
    }

    public static int generateRandom(int[] arr, int n){
        SecureRandom random = new SecureRandom();
        for(int i = 0 ; i < n ; i++){
//            arr[i] = ThreadLocalRandom.current().nextInt(0, 100000000);
            arr[i] = random.nextInt(0, 1000000000);
        }
//        return ThreadLocalRandom.current().nextInt(0, 100000000);
        return random.nextInt(0, 1000000000);
    }

    public long bestCaseTime(int size){
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[] arr = new int[size];
            int target = generateRandom(arr, size);
            target = algo.bestCaseSetup(arr, target);
            long start = System.nanoTime();
            algo.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public long worstCaseTime(int size){
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[] arr = new int[size];
            int target = generateRandom(arr, size);
            target = algo.worstCaseSetup(arr, target);
            long start = System.nanoTime();
            algo.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public long averageCaseTime(int size){
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[] arr = new int[size];
            int target = generateRandom(arr, size);
            target = algo.averageCaseSetup(arr, target);
            long start = System.nanoTime();
            algo.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public void initiate(int[] cases){
        Path filePath = Paths.get("Lab-Programs/src/LAB2/Data/" + algo.getName() + ".csv");
        try(PrintWriter pr = new PrintWriter(new FileWriter(filePath.toFile()))){
            pr.println("n,BestCase,AverageCase,WorstCase");
            for(int size : cases){
                System.out.println("Working Best");
                long bestCaseTime = bestCaseTime(size);
                System.out.println("Working worst");
                long worstCaseTime = worstCaseTime(size);
                System.out.println("Working average");
                long averageCaseTime = averageCaseTime(size);
                System.out.println("Best Case Time For "+ algo.getName() + " For Size " + size + " is: " + bestCaseTime);
                System.out.println("Average Case Time For "+ algo.getName() + " For Size " + size + " is: " + averageCaseTime);
                System.out.println("Worst Case Time For "+ algo.getName() + " For Size " + size + " is: " + worstCaseTime);
                System.out.println();
                pr.println(size + "," + bestCaseTime + "," + averageCaseTime + "," + worstCaseTime);
                pr.flush();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
