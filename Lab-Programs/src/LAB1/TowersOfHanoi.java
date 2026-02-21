package LAB1;

import LAB3.Algorithm;
import LAB3.TimingAlgorithms;

import java.util.Arrays;

public class TowersOfHanoi implements Algorithm {
    String name;
    public TowersOfHanoi(String name){
        this.name = name;
    }
    
    @Override
    public int algorithm(int[] arr, int target){
        solveHanoi( "Source" , "Destination", "Spare", arr.length);
        return 0;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return this.name;
    }



    public  void solveHanoi(String source, String dest, String spare, int n){
        if(n == 1){
            //commenting out print statement for better understanding of time used by the 
            // algorithm due to cleaner output
            //System.out.println("Moved the top disk of " + source + " to " + dest);
            return;
        }
        solveHanoi(source, spare, dest, n - 1 );
        solveHanoi(source, dest, spare, 1);
        solveHanoi(spare, dest, source, n - 1 );
    }

    public static void main(String[] args){
        //"Lab-Programs/src/LAB1/Data/"
        TowersOfHanoi th = new TowersOfHanoi("TowersOfHanoi");
        TimingAlgorithms framework = new TimingAlgorithms(th, 1000, "Lab-Programs/src/LAB1/Data/");
        int idx = 0;
        int length = 100;
        int[] sizes = new int[length];
        for(int i = 3 ; i <= (length * 1) + 2 ; i += 1){
            sizes[idx] = i;
            idx++;
        }

        boolean[] choices = {false, true, false};
        framework.initiate(sizes, choices);
    }
}
