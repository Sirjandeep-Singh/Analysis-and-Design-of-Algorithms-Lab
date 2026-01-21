public class BallTips {
    public static int calculateTips(double velocity, double loss, int tips){
        if(velocity < 1) return tips;
        return calculateTips(velocity * (1-loss), loss, tips + 1);
    }

    public static void main(String[] args){
        double groundResistance = 0.4;
        double airResistance = 0.01;
        double wearAndTearResistance = 0.015;
        double loss = groundResistance + airResistance + wearAndTearResistance;
        System.out.println(calculateTips(10, loss, 0));
    }
}
