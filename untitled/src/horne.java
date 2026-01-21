public class horne {
    public static int solveHorne(int[] arr, int idx, int m, int x){
        if(idx == m + 1) return 0;
        return arr[idx] + x * solveHorne(arr, idx + 1, m, x);
    }

    public static void main(String[] args){
        int n = 10;
        int[] arr = new int [n];
        TimeAlgo.generateRandom(arr, n);
        System.out.println(solveHorne(arr, 0, n - 1, 2));
    }
}
