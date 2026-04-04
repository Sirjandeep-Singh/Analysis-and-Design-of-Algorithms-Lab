package LAB6;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

import java.security.SecureRandom;


public class Prims implements TwoDimAlgorithm {
    private final String name;

    public Prims(String name){
        this.name = name;
    }

    public int[] solve(int[][] adjMatrix, int source){
        int n = adjMatrix.length;
        boolean[] connected = new boolean[n];
        int[] near = new int[n];
        int[] weights = new int[n];
        MyPriortiyQueue distances = new MyPriortiyQueue(n);
        for(int i = 0 ; i < n; i++){
            weights[i] = Integer.MAX_VALUE - 19999;

            if(i == source){
              distances.enqueue(new int[]{source,0});
          }else{
              distances.enqueue(new int[]{i,Integer.MAX_VALUE - 19999});
          }

        }
        weights[source] = 0;
        near[source] = source;
        for(int i = 0 ; i < n - 1; i++){
            int[] closestVertex = distances.dequeue();
            int vertex = closestVertex[0];
            if(connected[vertex]) continue;
            connected[vertex] = true;
            for(int j = 0 ; j < n ; j++){
                if(connected[j] || adjMatrix[vertex][j] >= Integer.MAX_VALUE/2) continue;
                if(adjMatrix[vertex][j] < weights[j]){
                    near[j] = vertex;
                    weights[j] = adjMatrix[vertex][j];
                    distances.changePriority(adjMatrix[vertex][j],j);
                }
            }
        }


        return near;

    }

    private int closestValid(int[] dist, boolean[] visited, int n){
        int idx = 0;
        for(int i = 0 ; i < n ; i++){
            if(visited[idx]) idx = i;
            if(visited[i]) continue;
            if(dist[idx] > dist[i]) idx = i;
        }
        return idx;
    }

    @Override
    public int[] algorithm(int[][] arr, int target){
        return solve(arr,target);
    }

    @Override
    public int bestCaseSetup(int[][] arr, int target){
        generateRandomGraph(arr, arr.length);
        return target % arr.length;
    }

    @Override
    public int averageCaseSetup(int[][] arr, int target){
        generateRandomGraph(arr, arr.length);
        return target % arr.length;
    }

    @Override
    public int worstCaseSetup(int[][] arr, int target){
        generateRandomGraph(arr, arr.length);
        return target % arr.length;
    }

    @Override
    public String getName(){
        return name;
    }

    public static void generateRandomGraph(int[][] arr, int rows){
        SecureRandom random = new SecureRandom();
        int INF = Integer.MAX_VALUE / 2;
        double density = 0.5;
        // initialize
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < rows; j++){
                    arr[i][j] = INF;
            }
        }

        // fill edges
        for(int i = 0; i < rows; i++){
            for(int j = i + 1; j < rows; j++){

                // decide if edge exists
                if(random.nextDouble(0,1) < density && i != j){
                    int weight = random.nextInt(1, 100); // weights 1–100
                    arr[i][j] = weight;
                    arr[j][i] = weight;
                }
            }
        }

        // ensure reachability from source (0)
        for(int i = 0; i < rows - 1; i++){
            int weight = random.nextInt(1, 100);
            arr[i][i + 1] = weight;
            arr[i + 1][i] = weight;
        }

    }

    public static void main(String[] args){
        Prims p = new Prims("Prims");
//        int[][] adj = {{0, 2, 1, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2},
//                {Integer.MAX_VALUE/2, 0, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 4, 3},
//                {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0, 8, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2},
//                {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0, 4, 5},
//                {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0, Integer.MAX_VALUE/2},
//                {Integer.MAX_VALUE/2, 5, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0}
//        };
//        int[] ancestor = p.solve(adj,0);
//        System.out.println("Source is: 1");
//        for(int i = 0; i < ancestor.length; i++){
//            System.out.println("ancestor for " + (i + 1) + " is: " + (ancestor[i] + 1));
//        }
        boolean[] choices = {false, true, false};
        int length = 100;
        int[][] sizes = new int[length][2];
        int idx = 0;
        for(int i = 5; idx < length ; i+= 5){
            sizes[idx][0] = i;
            sizes[idx][1] = i;
            idx++;
        }

        Timing2DAlgorithms framework = new Timing2DAlgorithms(p, 1000, "Lab-Programs/src/LAB6/Data/");
        framework.initiate(sizes, choices);
    }
}
