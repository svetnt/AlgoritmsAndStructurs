import java.util.Scanner;

/* Задан массив a из n целых чисел. Подотрезком будем называть последовательность из
 одного и более подряд идущих элементов массива.
  Подотрезок будем называть k-хорошим, если в нём не более k различных чисел.
  Найдите k-хороший подотрезок наибольшей длины.
 */
public class PoiskPodotrezka {
    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        int[] arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int result = 0;
        int resultLeft = 0;
        int resultRight = 0;
        int countElem = 0;
        int[] usedElem = new int[1000001];
        while (left != n){
            if (left != 0) {
                usedElem[arr[left - 1]]--;
                if (usedElem[arr[left - 1]] == 0) {
                    countElem--;
                }
            }
                    while (right != n && (countElem < k || (countElem == k && usedElem[arr[right]] != 0))){
                        if (usedElem[arr[right]] == 0){
                            countElem++;
                        }
                        usedElem[arr[right]]++;
                        right++;
                        if (result < right - left){
                            result = right - left;
                            resultLeft = left;
                            resultRight = right - 1;
                        }
                    }
            left++;
        }
        System.out.println((++resultLeft) + " " + (++resultRight));
    }
}
