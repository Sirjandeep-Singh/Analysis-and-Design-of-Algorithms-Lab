
package LAB9;

import LAB3.Algorithm;

public class LongestCommonSubsequence implements Algorithm {
    private String seq1;
    private String seq2;
    private String name;
    private int[][] memo;
    private int[][] s;
    public LongestCommonSubsequence(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int source){
        return solve(seq1,seq2);
    }

    private int solve(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
        memo = new int[n + 1][m + 1];

        //calculate longest subsequence
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                }else{
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        System.out.println(getLCS(text1,text2));
        return memo[n][m];
    }

    public String getLCS(String text1, String text2){
        int i = text1.length();
        int j = text2.length();
        StringBuilder lcs = new StringBuilder();

        while(i > 0 && j > 0){
            if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            }
            else if(memo[i - 1][j] > memo[i][j - 1]){
                i--;
            }
            else{
                j--;
            }
        }

        return lcs.reverse().toString();
    }


    @Override
    public int bestCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return name;
    }

    public static void main(String[] args){
        int[] arr = {0};
        LongestCommonSubsequence lcs = new LongestCommonSubsequence("LCS");
        lcs.seq1 = "Controller";
//        lcs.seq2 = "Cucumber";
        lcs.seq2 = "control";
        System.out.println(lcs.algorithm(arr,0));
    }


}
