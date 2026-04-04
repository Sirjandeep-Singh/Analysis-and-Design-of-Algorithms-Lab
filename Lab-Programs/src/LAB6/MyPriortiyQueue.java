package LAB6;

import java.util.HashMap;

public class MyPriortiyQueue {
    int[][] queue;
    public int capacity;
    public int size;
    HashMap<Integer, Integer> mp;
    MyPriortiyQueue(int capacity){
        queue = new int[capacity][2];
        this.capacity = capacity;
        size = -1;
        mp = new HashMap<>();
    }

    public void enqueue(int[] val){
        if(size == capacity - 1) this.queue = increaseCap();
        size++;
        queue[size] = val;
        mp.put(val[0],upHeap(size));
    }

    public int[] dequeue(){
        if(size == -1) throw new RuntimeException("Queue is Empty");
        int[] target = queue[0];
        mp.remove(target[0]);   // remove from map
        queue[0] = queue[size];
        size--;
        if(size >= 0){
            mp.put(queue[0][0], 0);
            downHeap(0);
        }
        return target;
    }

    public void changePriority(int newPriority, int idx){
        int qidx = mp.get(idx);
        queue[qidx][1] = newPriority;
        // fix heap
        if(qidx > 0 && queue[(qidx - 1)/2][1] > queue[qidx][1]){
            upHeap(qidx);
        } else {
            downHeap(qidx);
        }
    }

    private void swap(int i, int j){
        int[] temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
        // update hashmap
        mp.put(queue[i][0], i);
        mp.put(queue[j][0], j);
    }

    private int upHeap(int child){

        if(child == 0) return 0;

        int parent = (child - 1)/2;
        if(queue[parent][1] > queue[child][1]){
            swap(parent, child);
            return upHeap(parent);
        }
        return child;
    }

    private void downHeap(int parent){
        if(parent > (size - 1)/2) return;

        int leftChild = parent * 2 + 1;
        int rightChild = ((parent * 2 + 2) > size)? -1 : (parent * 2 + 2);

        int child = (rightChild != -1 && queue[rightChild][1] < queue[leftChild][1])? rightChild : leftChild;

        if(queue[child][1] < queue[parent][1]){
            swap(parent, child);
            downHeap(child);
        }
    }

    private int[][] increaseCap(){
        int[][] result = new int[capacity * 2][2];

        for(int i = 0; i <= size; i++){
            result[i] = queue[i];
        }

        this.capacity = capacity * 2;
        return result;
    }

    public void print(){
        for(int i = 0; i <= size; i++){
            System.out.print(queue[i][0] +  " : " + queue[i][1] + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        MyPriortiyQueue pq = new MyPriortiyQueue(5);
        pq.enqueue(new int[]{2,3});
        pq.enqueue(new int[]{1,4});
        pq.enqueue(new int[]{4,3});
        pq.enqueue(new int[]{1,5});
        pq.enqueue(new int[]{9,12});
        pq.print();
        pq.dequeue();
        pq.changePriority(15,4);
        pq.print();
        pq.dequeue();
        pq.print();
        pq.dequeue();
        pq.print();
        pq.dequeue();
        pq.print();
        pq.dequeue();
        pq.print();
    }

}
