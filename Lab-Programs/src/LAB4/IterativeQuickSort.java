package LAB4;

import java.nio.file.Paths;
import java.util.*;

public class IterativeQuickSort implements LAB3.Algorithm {

    private String name;

    public IterativeQuickSort(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int target) {
        iterativeQuickSort(arr);
        return 0;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target) {
        return 0;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target) {
        Arrays.sort(arr);
        return 0;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target) {
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    //Iterative Quick Sort using a stack
    private void iterativeQuickSort(int[] arr){
        Deque<Integer> s = new ArrayDeque<>();
        int size = arr.length;
        s.push(size - 1);
        s.push(0);
        int end;
        int start;
        while(!s.isEmpty()){
            start = s.pop();
            end = s.pop();

            if(start >= end){
                continue;
            }

            int pv = partition(arr, start, end);

            if((pv - start) <= (end - pv) ){
                s.push(end);
                s.push(pv + 1);
                s.push(pv - 1);
                s.push(start);
            }else{
                s.push(pv - 1);
                s.push(start);
                s.push(end);
                s.push(pv + 1);
            }
        }
    }

    //Iterative Quick Sort using a queue
    private void iterativeQuickSortWithQueue(int[] arr){
        Queue<Integer> q = new LinkedList<>();
        int size = arr.length;
        q.offer(0);
        q.offer(size - 1);
        while(!q.isEmpty()){
            int start = q.poll();
            int end = q.poll();
            if(start >= end) continue;
            int pv = partition(arr, start, end);
            if((pv - start) <= end - pv ){
                prioritize(q, start, pv - 1, pv + 1, end);
            }else{
                prioritize(q, pv + 1, end, start, pv - 1);
            }
        }
    }

    private int partition(int[] arr, int start, int end){
        int i = start + 1;
        int j = end;
        int pivot = arr[start];
        while(i <= j){
            while(i <= end && arr[i] <= pivot) i++;
            while(arr[j] > pivot) j--;
            if( i < j){
                swap(arr, i , j);
            }
        }
        swap(arr, start, j);
        System.out.println("pivot:" + pivot + " index:" + j);
        return j;
    }

    private void swap(int[] arr, int idx1, int idx2){
        arr[idx1] += arr[idx2];
        arr[idx2] = arr[idx1] - arr[idx2];
        arr[idx1] -= arr[idx2];
    }

    private void prioritize(Queue<Integer> q, int start1, int end1, int start2, int end2){
        Queue<Integer> temp_q = new LinkedList<>();
        while(!q.isEmpty()) temp_q.offer(q.poll());
        q.offer(start1);
        q.offer(end1);
        q.offer(start2);
        q.offer(end2);
        while(!temp_q.isEmpty()) q.offer(temp_q.poll());
    }

    public static void main(String[] args){
        int[] arr = {2,3,5,1,6,6,-1};
        IterativeQuickSort itqs = new IterativeQuickSort("IterativeQuickSort");
        itqs.iterativeQuickSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

}

