import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 13, 10};
        new QuickSort().sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

    private int partition(int[] arr, int left, int right){
        int temp = 0;
        int opor = arr[left];
        int j = left;
        for(int i = left+1; i<=right; i++){
            if (arr[i]<=opor){
                j++;
                temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        temp=arr[j];
        arr[j]=arr[left];
        arr[left]=temp;
        return j;
    }
}
