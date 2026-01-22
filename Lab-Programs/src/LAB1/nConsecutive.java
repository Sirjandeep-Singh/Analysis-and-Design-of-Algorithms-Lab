package LAB1;

public class nConsecutive {

    private static int findMissing(int lowerLimit, int upperLimit, int[] consec){
        int ans = 0;
        for(int i : consec){
            ans ^= i;
        }

        for(int i = lowerLimit ; i <= upperLimit ; i++){
            ans ^= i;
        }
        return ans;
    }

    public static void main(String[] args){
        int[] consec = {1,2,3,4,5,6,7,9};
        System.out.println(findMissing(1, 9, consec));
    }
}
