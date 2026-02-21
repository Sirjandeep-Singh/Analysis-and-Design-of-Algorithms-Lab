package LAB5;

import LAB3.Algorithm;
import LAB3.TimingAlgorithms;

public class CombinationTriangles implements TwoDimAlgorithm{
    private String name;

    public CombinationTriangles(String name){
        this.name = name;
    }

    @Override
    public int[] algorithm(int[][] arr, int target){
        solve(arr);
        return null;
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return name;
    }

    private  void solve(int[][] points){
        int idx = 0;
        for(int i = 0 ; i < points.length - 2 ; i++){
            for(int j = i + 1; j < points.length - 1; j++){
                for(int k = j + 1; k < points.length; k++){
//                    System.out.print("Point forming the triangle are: ");
//                    printArr(points[i]);
//                    printArr(points[j]);
//                    printArr(points[k]);
//                    System.out.println();
                    idx++;
                }
            }
        }
        System.out.println(idx);
    }

    private  void printArr(int[] point){
        System.out.print("(");
        for(int coOrd : point){
            System.out.print(coOrd + ", ");
        }
        System.out.print("), ");
    }
    public static void main(String[] args){
        int size = 100;
        CombinationTriangles ct = new CombinationTriangles("CombinationTriangles");
        Timing2DAlgorithms framework = new Timing2DAlgorithms(ct, 1000, "Lab-Programs/src/LAB5/Data/");
        int[][] sizes = new int[size][2];
        int counter = 0;
        for(int i = 100; i <= size*100; i += 100 ){
            sizes[counter][0] = i;
            sizes[counter][1] = 2;
            counter++;
        }
        boolean[] choices = {false,false,true};
        framework.initiate(sizes, choices);

//        int[][] points = {{1,2}, {2,3}, {3,4}, {2,5}, {4,7}};
//        ct.solve(points);
    }
}
