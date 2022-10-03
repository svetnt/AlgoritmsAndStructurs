import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 10, 1, 7};
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int lengt = arr.length;
        if (lengt < 2) {
            return;
        }
        int s = lengt / 2;
        int[] left = new int[s];
        int[] right = new int[lengt - s];

        for (int i = 0; i < s; i++) {
            left[i] = arr[i];
        }
        for (int i = s, j = 0; i < lengt; i++, j++) {
            right[j] = arr[i];
        }
        sort(left);
        sort(right);
        merge(arr,left,right);

    }

    private void merge(int[] arr, int[] left, int[] right) {
        int leftLength = left.length;
        int rigthLength = right.length;
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rigthLength) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        if (i == leftLength) {
            while (j < rigthLength) {
                arr[k] = right[j];
                k++;
                j++;
            }
        } else {
            while (i < leftLength) {
                arr[k] = left[i];
                k++;
                i++;
            }
        }
    }
}
