public class TowersOfHanoi {
    public static void solveHanoi(String source, String dest, String spare, int n){
        if(n == 1){
            System.out.println("Moved the top disk of " + source + " to " + dest);
            return;
        }
        solveHanoi(source, spare, dest, n - 1 );
        solveHanoi(source, dest, spare, 1);
        solveHanoi(spare, dest, source, n - 1 );
    }

    public static void main(String[] args){
        solveHanoi("Source", "Destination", "spare", 3);
    }
}
