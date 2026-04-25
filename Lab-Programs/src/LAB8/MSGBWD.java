package LAB8;

import LAB3.Algorithm;
import LAB5.TwoDimAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import LAB5.TwoDimAlgorithm;

import java.util.*;

public class MSGBWD implements TwoDimAlgorithm {

        //This algorithm assumes that a vertex denoted by a higher number always
        // exists at a later stage compared to a vertex denoted with a smaller number
        private String name;
        private ArrayList<int[]> vertices;
        private int[] cost;
        private int[] d;
        private int[] p;
        public MSGBWD(String name){
            this.name = name;
        }

        @Override
        public int[] algorithm(int[][] adjMatrix, int source){
            source = 0;
            int len = adjMatrix.length;
            cost = new int[len];
            d = new int[len];
            //set the memoized array for dp
            Arrays.fill(cost, Integer.MAX_VALUE);
            cost[0] = 0;
            int shortestPath = solveBwd(adjMatrix, len);
            int numOfStages = traverse(adjMatrix, source, 0);
            printPath(d, numOfStages);
            return new int[]{shortestPath};
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

        //For Backward approach we start with second last vertex unlike the forward approach
        //memo[0] = 0 by default
        private int solveBwd(int[][] adjMatrix, int len){

            for (int u = 1; u < len; u++) {

                for (int v = u - 1; v >= 0; v++) {
                    int distToStart = adjMatrix[v][u] + cost[v];
                    if (distToStart < cost[u]) {
                        cost[u] = distToStart;
                        d[u] = v;
                    }
                }
            }
            return cost[len - 1];
        }

        private void printPath(int[]stageChoice, int numOfStages){
            p = new int[numOfStages];
            p[0] = 0;
            p[numOfStages - 1] = stageChoice.length - 1;
            for(int i = 1 ; i < numOfStages - 1; i++){
                p[i] = d[p[i - 1]];
            }

            for(int pathVertex : p){
                System.out.print(pathVertex + " --> ");
            }
            System.out.println();
        }

        private int[][] input(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of vertices");
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                System.out.println("Enter Edges for vertex" + (i + 1));
                for(int j = 0 ; j < n ; j++){
                    System.out.println("Enter Edge" + (i + 1) + " -->?" + (j + 1));
                    int edge = sc.nextInt();

                }
            }

            return arr;
        }

        private int traverse(int[][] adjMatrix, int source, int stage){

            for(int i = 0 ; i < adjMatrix.length ; i++){
                if(adjMatrix[source][i] > 0){
                    stage = traverse(adjMatrix, i, stage);
                    break;
                }
            }
            return stage + 1;
        }

        public static void main(String[] args){
            int[][] adjMatrix = {
                    { 0,  2,  1,  3,  0,  0,  0,  0},
                    { 0,  0,  0,  0,  2,  3,  0,  0},
                    { 0,  0,  0,  0,  6,  7,  0,  0},
                    { 0,  0,  0,  0,  6,  8,  9,  0},
                    { 0,  0,  0,  0,  0,  0,  0,  6},
                    { 0,  0,  0,  0,  0,  0,  0,  4},
                    { 0,  0,  0,  0,  0,  0,  0,  5},
                    { 0,  0,  0,  0,  0,  0,  0,  0}
            };


            LAB8.MSGShortestPath msgsp = new LAB8.MSGShortestPath("MSGShortestPath");
            int[] temp = msgsp.algorithm(adjMatrix,0);
            System.out.println("Shortest Path is: " + temp[0]);

        }



}
