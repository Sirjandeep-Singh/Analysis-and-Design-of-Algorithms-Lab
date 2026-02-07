package LAB2;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BinSearch implements Algorithm{
    String name;

    public BinSearch(String name){
        this.name = name;
    }

    public static int algorithmit(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public int binSearch(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int mid = (end - start)/2 + start;
        if(arr[mid] == target) return mid;
        if(arr[mid] < target){
            return binSearch(arr, target, mid + 1, end);
        }else{
            return binSearch(arr, target, start, mid - 1);
        }
    }

    @Override
    public int algorithm(int[] arr, int target){
        return binSearch(arr, target, 0, arr.length - 1);
    }

    @Override
    public int averageCaseSetup(int[] arr, int target) {
        Arrays.sort(arr);
        return arr[target % arr.length];
    }

    @Override
    public int worstCaseSetup(int[] arr, int target) {
        Arrays.sort(arr);
        int k = ThreadLocalRandom.current().nextInt(0,2);
        return k == 1 ? -1 : arr[arr.length - 1] + 1;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target) {
        Arrays.sort(arr);
        int mid = arr.length/2;
        return arr[mid];
    }

    @Override
    public String getName(){
        return this.name;
    }


    public static void main(String[] args){
        int[] n = new int[500];
        for(int i = 0 ; i < 500 ; i++){
            n[i] = i == 0? 100 : n[i-1] + 100;
        }
//        System.out.println(cases[99]);

        BinSearch binObj = new BinSearch("binary_Search");
        TimingAlgorithms time = new TimingAlgorithms(binObj, 1000);
        time.initiate(n);

//        int[] arr = {1, 3, 31, 54, 13, 542};
//        System.out.println(binObj.algorithm(arr, 542));
    }

}
