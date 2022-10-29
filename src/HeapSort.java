import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 17, 31, 20, 9};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr){
        int n = arr.length;
        for(int i = n/2-1; i>=0; i--) {
            arrHeap(arr, n, i);
        }
        for (int i = n-1; i>=0; i--){
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;
            arrHeap(arr, i, 0);
        }
    }

    public void arrHeap(int[] arr, int n, int i){
        int max = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left]>arr[max]){
            max = left;
        }
        if(right<n && arr[right]>arr[max]){
            max = right;
        }
        if(max != i){
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;
            arrHeap(arr, n, max);
        }
    }
}
