import java.util.Arrays;
import java.util.Scanner;

/* Кузнечик прыгает по столбикам, расположенным на одной линии на равных расстояниях
 друг от друга. Столбики имеют порядковые номера от 1 до N . Вначале Кузнечик сидит на
 столбике с номером 1. Он может прыгнуть вперед на расстояние от 1 до K столбиков, считая
  от текущего.
 На каждом столбике Кузнечик может получить или потерять несколько золотых монет (для
 каждого столбика это число известно). Определите, как нужно прыгать Кузнечику, чтобы
  собрать наибольшее количество золотых монет. Учитывайте, что Кузнечик не может прыгать назад.
 В первой строке вводятся два натуральных числа: N и K ( 2 ≤ N , K ≤ 10000 ), разделённые
 пробелом. Во второй строке записаны через пробел N - 2 целых числа – количество монет,
 которое Кузнечик получает на каждом столбике, от 2-го до N - 1 -го. Если это число отрицательное,
 Кузнечик теряет монеты
 В первой строке программа должна вывести наибольшее количество монет, которое может собрать
 Кузнечик. Во второй строке выводится число прыжков Кузнечика, а в третьей строке – номера
 всех столбиков, на которых побывал Кузнечик (через пробел в порядке возрастания).
 */
public class Kuznechik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n + 1];
        arr[1] = 0;
        arr[n] = 0;
        for (int i = 2; i < n; i ++){
            arr[i] = input.nextInt();
        }

        int[] din = new int[n + 1];
        din[1] = 0;
        int num_maxCount = 0;
        int[]memory = new int[n + 1];
        for (int i = 1; i <= n; i++){
            num_maxCount = i - 1;
            for (int j = Math.max(1, i - k); j <= i - 1; j++){
                if (din[j] > din[num_maxCount]){
                    num_maxCount = j;
                }
                din[i] = din[num_maxCount] + arr[i];
                memory[i] = num_maxCount;
            }
        }

        String result = String.valueOf(n);
        int i = n;
        while (i >= 1){
            result = memory[i] + " " + result;
            i = memory[i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(din));
        System.out.println(Arrays.toString(memory));
        System.out.println(din[n]);
        System.out.println(result);
    }
}
