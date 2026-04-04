package LAB6;

import LAB5.Timing2DAlgorithms;
import LAB5.TwoDimAlgorithm;

import java.security.SecureRandom;

public class DijsktraAlgo implements TwoDimAlgorithm {
    private final String name;

    public DijsktraAlgo(String name){
        this.name = name;
    }

    public int[] solve(int[][] adjMatrix, int source){
        int n = adjMatrix.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        MyPriortiyQueue distance = new MyPriortiyQueue(n);
        for(int i = 0 ; i < n; i++){
            distances[i] = Integer.MAX_VALUE - 10000;
            //int temp = adjMatrix[source][i];
            //distances[i] = temp;
            if(i == source){
                distances[i] = 0;
                distance.enqueue(new int[]{source, 0});
                continue;
            }
            distance.enqueue(new int[]{i,Integer.MAX_VALUE/2});
        }

        for(int i = 0 ; i < n - 1 ; i++){
            //int closestVertex = closestValid(distances, visited, n);
            int[] closestVertex = distance.dequeue();
            int closestVertexIdx = closestVertex[0];
            distances[closestVertexIdx] = closestVertex[1];
            visited[closestVertexIdx] = true;
            for(int j = 0 ; j < n ; j++){
                if(visited[j] || adjMatrix[closestVertexIdx][j] >= Integer.MAX_VALUE/2) continue;
                if(adjMatrix[closestVertexIdx][j] + distances[closestVertexIdx] < distances[j]){
                    distance.changePriority(adjMatrix[closestVertexIdx][j] + distances[closestVertexIdx], j);
                    distances[j] = adjMatrix[closestVertexIdx][j] + distances[closestVertexIdx];
                }
            }
        }
        return distances;

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
            for(int j = 0; j < rows; j++){

                // decide if edge exists
                if(random.nextDouble(0,1) < density && i != j){
                    int weight = random.nextInt(1, 100); // weights 1–100
                    arr[i][j] = weight;
                }
            }
        }

        // ensure reachability from source (0)
        for(int i = 0; i < rows - 1; i++){
            int weight = random.nextInt(1, 100);
            arr[i][i+1] = weight;
        }

    }

    public static void main(String[] args){
        DijsktraAlgo dj = new DijsktraAlgo("DijsktrasAlgo");
//        int[][] adj = {{0, 2, 1, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2},
//                {Integer.MAX_VALUE/2, 0, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 4, 3},
//                {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0, 8, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2},
//                {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0, 4, 5},
//                {Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0, Integer.MAX_VALUE/2},
//                {Integer.MAX_VALUE/2, 5, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, Integer.MAX_VALUE/2, 0}
//                };
//        int[] distances = dj.solve(adj,0);
//        System.out.println("Source is: 1");
//        for(int i = 0 ; i < distances.length; i++){
//            System.out.println("Shortest distance for " + (i + 1) + " from source is: " + distances[i]);
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

        Timing2DAlgorithms framework = new Timing2DAlgorithms(dj, 1000, "Lab-Programs/src/LAB6/Data/");
        framework.initiate(sizes, choices);
    }


}
