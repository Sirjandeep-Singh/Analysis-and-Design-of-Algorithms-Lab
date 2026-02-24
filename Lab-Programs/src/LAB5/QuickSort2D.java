package LAB5;

public class QuickSort2D {
    public static void QuickSort_2D(double[][] arr, int i, int start, int end){
        if(start >= end) return;
        int pivotIdx = partition(arr,i, start, end);
        QuickSort_2D(arr, i, start, pivotIdx - 1);
        QuickSort_2D(arr, i, pivotIdx + 1, end);
    }

    private static int partition(double[][] arr, int idx ,int start, int end){
        if(start == end) return start;
        double pivot = arr[start][idx];
        int i = start;
        int j = end + 1;
        do{
            do{i++;} while(i <= end && arr[i][idx] <= pivot);
            do{j--;}while (arr[j][idx] > pivot);
            if(i < j) swap(arr, i , j);
        }while(i < j);

        swap(arr,start,j);
        return j;

    }

    public static void QuickSort_2D_Desc(double[][] arr, int i, int start, int end){
        if(start >= end) return;
        int pivotIdx = partitionDesc(arr,i, start, end);
        QuickSort_2D_Desc(arr, i, start, pivotIdx - 1);
        QuickSort_2D_Desc(arr, i, pivotIdx + 1, end);
    }

    private static int partitionDesc(double[][] arr, int idx ,int start, int end){
        if(start == end) return start;
        double pivot = arr[start][idx];
        int i = start;
        int j = end + 1;
        do{
            do{i++;} while(i <= end && arr[i][idx] >= pivot);
            do{j--;}while (arr[j][idx] < pivot);
            if(i < j) swap(arr, i , j);
        }while(i < j);

        swap(arr,start,j);
        return j;

    }

    private static void swap(double[][] arr, int idx1, int idx2){
        double[] temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }



}
