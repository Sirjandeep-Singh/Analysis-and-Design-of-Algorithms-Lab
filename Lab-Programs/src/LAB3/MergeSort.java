package LAB3;

public class MergeSort implements Algorithm {
    String name;

    public MergeSort(String name){
        this.name = name;
    }

    @Override
    public int algorithm(int[] arr, int target){
        mergeSort(arr, 0, arr.length - 1);
        return 0;
    }

    @Override
    public int bestCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int worstCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public int averageCaseSetup(int[] arr, int target){
        return 0;
    }

    @Override
    public String getName(){
        return this.name;
    }

    private void mergeSort(int[] arr, int start, int end){
        if(start >= end) return;
        int mid = (end - start)/2 + start;
        mergeSort(arr,start,mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start,int mid, int end){
        int l1 = mid - start + 1;
        int l2 = end - mid;
        int[] tempArr1 = new int[l1 + 1];
        int[] tempArr2 = new int[l2 + 1];

        for(int i = 0; i < l1; i++){
            tempArr1[i] = arr[start + i];
        }

        for(int i = 0 ; i < l2 ; i++){
            tempArr2[i] = arr[mid + 1 + i];
        }

        tempArr2[l2] = Integer.MAX_VALUE;
        tempArr1[l1] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for(int k = start ; k <= end; k++){
            if(tempArr1[i] < tempArr2[j]){
                arr[k] = tempArr1[i];
                i++;
            }else{
                arr[k] = tempArr2[j];
                j++;
            }
        }
    }

    private void swap(int[] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){

        MergeSort testing = new MergeSort("MergeSort");

        TimingAlgorithms frameWork = new TimingAlgorithms(testing, 1000);
        int[] n = new int[100];
        for(int i = 0 ; i < 100 ; i++){
            n[i] = i == 0? 100 : n[i-1] + 100;
        }
        frameWork.initiate(n);
    }
}
