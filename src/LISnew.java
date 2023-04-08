/* Найти в массиве целых чисел наибольшую возрастающую подпоследовательность
  Вывести её границы и длину */

import java.util.Arrays;

public class LISnew {
    public static void main(String[] args) {
        int[] arr = {2, 5, 11, 8, 9, 16, 25, 30, 4, 32};
        int maxLenght = 1;
        int left = 0;
        int right = 0;
        int[] lench = new int[arr.length];
        lench[0] = 1;
        for (int i = 1; i < arr.length; i++){
            lench[i] = 1;
            if (arr[i] > arr[i - 1]){
                lench[i] = lench[i - 1] + 1;

            } else {
                if (lench[i - 1] > maxLenght){
                    maxLenght = lench[i - 1];
                    right = i - 1;
                    left = i - maxLenght;
                }
            }
        }
        System.out.println(Arrays.toString(lench));
        System.out.println(left + " " + right + " " + maxLenght);
    }
}
