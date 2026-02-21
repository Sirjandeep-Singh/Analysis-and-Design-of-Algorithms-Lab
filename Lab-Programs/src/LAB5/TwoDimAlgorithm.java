package LAB5;

public interface TwoDimAlgorithm {
    public int[] algorithm(int[][] arr, int target);
    public int bestCaseSetup(int[][] arr, int target);
    public int worstCaseSetup(int[][] arr, int target);
    public int averageCaseSetup(int[][] arr, int target);
    public String getName();
}
