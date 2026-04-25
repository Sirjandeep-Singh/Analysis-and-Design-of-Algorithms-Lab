package LAB9;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

public class NQueens implements TwoDimAlgorithm {

    private String name;
    private int[][] memo;
    private int[][] s;
    public NQueens(String name){
        this.name = name;
    }

    public int[] algorithm(int[][] adjacency_matrix, int source){
        int[] result;
        result = solve(adjacency_matrix.length);
        return result;
    }

    private int[] solve(int n){
        int[] pos = new int[n];
        place(0, pos, n);
        return pos;
    }

    private boolean place(int queenNum, int[] pos, int n){
        //base case
        if(queenNum == n) return true;
        //recursive case
        //find a position to place the current queen
        for(int i = 0; i < n; i++){
            boolean pass = false;

            //explore all options
            for(int j = 0 ; j < queenNum; j++){
                //check with previous queens
                int queenY = pos[j];
                if((Math.abs(queenNum - j) == Math.abs(i - queenY)) || (queenY == i)){
                    pass = true;
                    break;
                }
            }

            if(pass) continue;
            pos[queenNum] = i;
            if(place(queenNum + 1, pos, n)) return true;

        }

        return false;
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
//        int[][] arr = new int[4][1];
//        int[] res;
//        res =  nq.algorithm(arr,0);
//        for(int i = 0 ; i < 4; i++){
//            System.out.print((res[i] + 1) + " ,");
//        }

        NQueens nq = new NQueens("NQueens");
        boolean[] choices = {false, true, false};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 4; idx < length ; i+= 1){
            sizes[idx][0] = i;
            sizes[idx][1] = 1;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(nq, 100, "Lab-Programs/src/LAB9/Data/");
        framework.initiate(sizes, choices);
    }
}
