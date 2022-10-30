import java.util.Arrays;

/* Найти в массиве целых чисел наибольшую последовательнократную подпоследовательность
  (Последовательность наибольшей длины, в которой каждый элемент делится на предыдущий ) */
public class LIS {

    public static void main(String[] args) {
        int[] arr = {2, 5, 11, 8, 7, 3, 16, 25, 30, 4, 32, 9};
        System.out.println(Arrays.toString(new LIS().maxLength(arr)));
    }

    private int[] maxLength(int[] arr) {
        int[] lengthes = new int[arr.length];
        int[] prev = new int[arr.length];
        Arrays.fill(lengthes, 1);
        Arrays.fill(prev, -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && lengthes[j] + 1 > lengthes[i]) {
                    lengthes[i]++;
                    prev[i] = j;
                }
            }
        }

        int maxLength = 1;
        int maxIndex = -1;
        for (int i = 0; i < lengthes.length; i++) {
            if (lengthes[i] > maxLength) {
                maxLength = lengthes[i];
                maxIndex = i;
            }
        }

       int[] result = new int[maxLength];
        for (int i = maxLength-1; i>=0; i--){
            result[i] = arr[maxIndex];
            maxIndex = prev[maxIndex];
        }

        return result;
    }
}
