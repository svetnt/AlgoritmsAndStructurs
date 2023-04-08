/* Требуется подсчитать количество последовательностей длины N, состоящих из 0 и 1,
 в которых никакие две единицы не стоят рядом.
 */
import java.util.Scanner;

public class Fibonachi01 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n == 1){
            System.out.println(2);
            return;
        }
        if (n == 2){
            System.out.println(3);
            return;
        }
        long f1 = 2;
        long f2 = 3;
        long result = 0;

        int iter = 3;
        while (iter <= n) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
            iter++;
        }

        System.out.println(result);
    }
}
