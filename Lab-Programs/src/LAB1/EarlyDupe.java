package LAB1;

public class EarlyDupe {
    private static int earliestDuplicate(int[] arr){
        int size = arr.length;
        int uppermid = (size + 1)/2;
        for(int i = uppermid - 1 ; i >= 0; i--){
            for(int j = i - 1 ; j >= 0 ; j--){
                if(arr[i] == arr[j]) uppermid = i;
            }
        }
        return uppermid;
    }

    public static void main(String[] args){

        int[] arr = {1, 2, 5, 1, 4, 4, 3, 2, 3, 5};
        System.out.println(earliestDuplicate(arr));
    }
}
