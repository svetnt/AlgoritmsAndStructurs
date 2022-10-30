import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 2, 7};
        CountSort countSort = new CountSort();
        countSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int[] counts = new int[11];
        Arrays.fill(counts, 0);
        for (int el : arr) {
            counts[el]++;
        }
        int ind = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                arr[ind] = i;
                ind++;
            }
        }
    }
}
