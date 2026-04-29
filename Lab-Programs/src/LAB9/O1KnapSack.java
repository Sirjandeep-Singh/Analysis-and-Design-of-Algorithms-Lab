//MERGE PURGE IS TO DO

package LAB9;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class O1KnapSack implements TwoDimAlgorithm {

    static class Pair {
        int weight;
        int profit;

        Pair(int w, int p) {
            this.weight = w;
            this.profit = p;
        }
    }

    private String name;
    private int[][] memo;
    public O1KnapSack(String name){
        this.name = name;
    }


    //1 --> weight 0--> profit
    public int[] algorithm(int[][] profitWeight_matrix, int maxWeight){
        memo = new int[profitWeight_matrix.length + 1][maxWeight + 1];

        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], 0);
        }

        solve(profitWeight_matrix, maxWeight);
        return select(memo, profitWeight_matrix);
    }

    private int[][] solve(int[][] profitWeight_matrix, int maxWeight){
        int items = profitWeight_matrix.length;
        for(int i = 1 ; i <= items; i++){
            int currentItem = i - 1;
            for(int j = 1; j <= maxWeight; j++){
                int prevj = j - profitWeight_matrix[currentItem][1];
                if(prevj >= 0){
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][prevj] + profitWeight_matrix[currentItem][0]);
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo;
    }

    private int[] select(int[][] memo, int[][] profitWeight_matrix){
        int[] result = new int[profitWeight_matrix.length];
        Arrays.fill(result,0);
        int j = memo[0].length - 1;
        for(int i = memo.length - 1; i > 0 ; i--){
            if(j <= 0) break;
            int currentItemIdx = i - 1;
            if(memo[i][j] == memo[i - 1][j]){
                result[currentItemIdx] = 0;
            }else{
                j -= profitWeight_matrix[currentItemIdx][1];
                result[currentItemIdx] = 1;
            }
        }
        return result;
    }

    private int mergePurgeSolve(int[][] profitWeight_matrix, int maxWeight) {
        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(0, 0)); // initial solution

        for (int i = 0; i < profitWeight_matrix.length; i++) {
            int weight = profitWeight_matrix[i][1];
            int profit = profitWeight_matrix[i][0];

            ArrayList<Pair> newList = new ArrayList<>();

            // include current item
            for (Pair p : list) {
                int newWeight = p.weight + weight;
                int newProfit = p.profit + profit;

                if (newWeight <= maxWeight) {
                    newList.add(new Pair(newWeight, newProfit));
                }
            }

            // merge
            list.addAll(newList);

            // sort by weight
            list.sort((a, b) -> a.weight - b.weight);

            // purge dominated pairs
            ArrayList<Pair> filtered = new ArrayList<>();
            int maxProfitSoFar = -1;

            for (Pair p : list) {
                if (p.profit > maxProfitSoFar) {
                    filtered.add(p);
                    maxProfitSoFar = p.profit;
                }
            }

            list = filtered;
        }

        // get best profit
        int maxProfit = 0;
        for (Pair p : list) {
            maxProfit = Math.max(maxProfit, p.profit);
        }

        return maxProfit;
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return name;
    }

    public static void main(String[] args){
//        int items = 3;
//        int MAX_WEIGHT = 5;
//        int[][] arr = {{1, 1}, {7, 2}, {11, 3}};
//        O1KnapSack ioks = new O1KnapSack("IO");
//        int[] res;
//        int maxProfit = 0;
//        res =  ioks.algorithm(arr,MAX_WEIGHT);
//        for(int i = 0 ; i < items; i++){
//            System.out.print((res[i]) + " ,");
//            maxProfit += res[i] == 1? arr[i][0] : 0;
//        }
//        System.out.println();
//        System.out.println("Max Profit: " + maxProfit);

        O1KnapSack ioks = new O1KnapSack("O_1KnapSack");

        boolean[] choices = {false, true, false};
        int length = 1000;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 100; idx < length ; i+= 100){
            sizes[idx][0] = i;
            sizes[idx][1] = 2;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(ioks, 100, "Lab-Programs/src/LAB9/Data/");
        framework.initiate(sizes, choices);

    }
}
