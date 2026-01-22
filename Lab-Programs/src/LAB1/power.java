package LAB1;

public class power {
    public static int calculatePowerFast(int a, int b){
        if(b == 1) return a;
        int tempStore = calculatePowerFast(a, b/2);
        if(b % 2 == 0){
            return tempStore * tempStore;
        }

        return tempStore * tempStore * a;
    }

    public static int calculatePowerSlow(int a, int b){
        if(b == 1) return a;
        return a * calculatePowerSlow(a, b - 1);
    }

    public static void main(String[] args){
        System.out.println( calculatePowerFast(2,4));
        System.out.println( calculatePowerSlow(3,9));
    }
}
