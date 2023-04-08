import java.util.Arrays;
import java.util.Scanner;

/* Алиса и Боб стали победителями телевикторины, и теперь им предстоит выбрать себе призы. На выбор предлагается
 n призов, пронумерованных от 1 до n.
 Распределение призов происходит следующим образом. Организаторы телевикторины сообщают
 победителям целое положительное число k (1≤ k≤ n /3). Сначала Алиса выбирает себе любые k
  подряд идущих номеров призов. Потом Боб выбирает себе k подряд идущих номеров призов,
  при этом он не может выбирать номера, которые уже выбрала Алиса. После этого победители
  забирают выбранные ими призы.
  Алиса хорошо знает Боба, и для каждого приза выяснила его ценность для Боба, которая
  является целым положительным числом. Алиса обижена на Боба и хочет выбрать свои призы так,
  чтобы суммарная ценность призов, которые достанутся Бобу, была как можно меньше. При этом
  Алису не волнует, какие призы достанутся ей.
  Требуется написать программу, которая по информации о ценности призов и значению
  k определит, для какого минимального значения x Алиса сможет добиться того, чтобы Боб не
  смог выбрать призы с суммарной ценностью больше x */
public class PrizChastSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        long[] pref = new long[n];
        pref[0] = price[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + price[i];
        }

        long[] suff = new long[n];
        suff[n - 1] = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + price[i];
        }

        long[] prefMax = new long[n];
        prefMax[k - 1] = pref[k - 1];
        for (int i = k; i < n; i++){
            prefMax[i] = Math.max(prefMax[i - 1], pref[i] - pref[i - k]);
        }

        long[] sufMax = new long[n];
        sufMax[n - k] = suff[n - k];
        for (int i = n - k - 1; i >= 0; i--){
            sufMax[i] = Math.max(sufMax[i + 1], suff[i] - suff[i + k]);
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            result = Math.min(result,
                    Math.max(i > 0 ? prefMax[i - 1] : 0, i + k < n ? sufMax[i + k] : 0));

        }
        System.out.println(Arrays.toString(price));
        System.out.println(Arrays.toString(pref));
        System.out.println(Arrays.toString(suff));
        System.out.println(Arrays.toString(prefMax));
        System.out.println(Arrays.toString(sufMax));
        System.out.println(result);
    }
}
