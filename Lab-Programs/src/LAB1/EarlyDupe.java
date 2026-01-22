package LAB1;

public class EarlyDupe {
    private static int earliestDuplicate(int[] arr, int limit){
        int size = arr.length;
        int uppermid = (size + 1)/2;
        int[] hashFreq = new int[limit + 1];
        for(int i = 0 ; i < uppermid; i++){
            if(hashFreq[arr[i]] == 1){
                return i;
            }
            hashFreq[arr[i]]++;
        }
        return uppermid;
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 5, 1, 4, 4, 3, 2, 3, 5};
        System.out.println(earliestDuplicate(arr, 5));
    }
}
