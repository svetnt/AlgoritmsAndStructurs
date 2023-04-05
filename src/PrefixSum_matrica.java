import java.util.Arrays;
import java.util.Scanner;
/* найти сумму элементов матрицы, ограниченной прямоугольником с координатами n1m1, n2m2

 */
public class PrefixSum_matrica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3, m = 3;
        int n1 = 2, m1 = 2, n2 = 3, m2 = 3;

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] pref = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i][j] = arr[i][j];
                if (i > 0) {
                    pref[i][j] += pref[i - 1][j];
                }
                if (j > 0) {
                    pref[i][j] += pref[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    pref[i][j] -= pref[i - 1][j - 1];
                }
            }
        }

        int sum = pref[n2 - 1][m2 - 1];
        if (n1 - 1 > 0){
            sum -= pref[n1 - 2][m2 - 1];
        }
        if (m1 - 1 > 0) {
            sum -= pref[n2 - 1][m1 - 2];
        }
        if (n1 - 1 > 0 && m1 - 1 > 0){
            sum += pref[n1 - 2][m1 - 2];
        }


        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(pref));
        System.out.println(sum);
    }
}
