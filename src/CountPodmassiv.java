import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* Дан массив из n положительных чисел. Необходимо найти количество подмассивов
   с суммой элементов не меньше k.
*/
public class CountPodmassiv {
    public static void main(String[] args) {
        int n = 8;
        int k = 5;
        int[] arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int right = 0;
        int sum = 0;
        int countResult = 0;

        for (int i = 0; i < n; i++){
            if (i > 0){
                sum -= arr[i - 1];
                System.out.println("ifS" + sum);
            }
            while (right < n && sum < k){
                sum += arr[right];
                right++;
                if (sum >= k){

                }
                System.out.println("whS" + sum);
                System.out.println("rig" + right);
            }
            if (sum >= k) {
                countResult += n - right + 1;
            }

            System.out.println("cR" + countResult);
        }
        System.out.println(countResult);
    }
}
