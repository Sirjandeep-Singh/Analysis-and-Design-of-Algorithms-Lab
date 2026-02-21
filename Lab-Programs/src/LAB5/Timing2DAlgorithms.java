package LAB5;

import LAB5.TwoDimAlgorithm;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class Timing2DAlgorithms {
    String path;
    int CASES;
    TwoDimAlgorithm algo;
    public Timing2DAlgorithms(TwoDimAlgorithm k, int CASES){
        this.CASES = CASES;
        algo = k;
        path = "Lab-Programs/src/LAB5/Data/";
    }

    public Timing2DAlgorithms(TwoDimAlgorithm k, int CASES, String path){
        this.CASES = CASES;
        algo = k;
        this.path = path;
    }

    public static int generateRandom(int[][] arr, int row, int col){
        SecureRandom random = new SecureRandom();
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                arr[i][j] = random.nextInt(0, 1000000000);
            }
        }

        return random.nextInt(0, 1000000000);
    }

    public long bestCaseTime(int row, int col){
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[][] arr = new int[row][col];
            int target = generateRandom(arr, row, col);
            target = algo.bestCaseSetup(arr, target);
            long start = System.nanoTime();
            algo.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public long worstCaseTime(int row, int col){
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[][] arr = new int[row][col];
            int target = generateRandom(arr, row, col);
            target = algo.worstCaseSetup(arr, target);
            long start = System.nanoTime();
            algo.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public long averageCaseTime(int row, int col){
        long totaltime = 0;
        for(int i = 0 ; i < CASES; i++){
            int[][] arr = new int[row][col];
            int target = generateRandom(arr, row,col);
            target = algo.averageCaseSetup(arr, target);
            long start = System.nanoTime();
            algo.algorithm(arr, target);
            long end = System.nanoTime();
            long duration = end - start;
            totaltime += duration;
        }
        return totaltime/CASES;
    }

    public void initiate(int[][] sizes, boolean[] choices){
        Path filePath = Paths.get(path + algo.getName() + ".csv");
        try(PrintWriter pr = new PrintWriter(new FileWriter(filePath.toFile()))){
            pr.println("r,c,BC,AC,WC");
            for(int[] detail : sizes){
                long worstCaseTime = -1;
                long bestCaseTime = -1;
                long averageCaseTime = -1;
                int row = detail[0];
                int col = detail[1];
                if(choices[0]){
                    System.out.println("Working Best");
                    bestCaseTime = bestCaseTime(row, col);
                    System.out.println("Best Case Time For "+ algo.getName() + " For rows " + row +  ", cols " + col + " is: " + bestCaseTime);
                }
               if(choices[2]){
                   System.out.println("Working worst");
                   worstCaseTime = worstCaseTime(row, col);
                   System.out.println("Worst Case Time For "+ algo.getName() + " For rows " + row +  ", cols " + col + " is: " + worstCaseTime);
               }
                if(choices[1]){
                    System.out.println("Working average");
                    averageCaseTime = averageCaseTime(row, col);
                    System.out.println("Average Case Time For "+ algo.getName() + " For rows " + row +  ", cols " + col + " is: " + averageCaseTime);
                }
                System.out.println();
                pr.println(row + "," + col + ","  + bestCaseTime + "," + averageCaseTime + "," + worstCaseTime);
                pr.flush();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void printArr(int[][] arr){
        for(int[] row : arr){
            for(int item : row){
                System.out.print(item + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
