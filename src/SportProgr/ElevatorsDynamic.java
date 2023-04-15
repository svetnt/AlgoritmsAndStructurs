package SportProgr;

import java.util.*;

/* В офисе есть несколько лифтов. Каждый лифт едет только с этажа s до этажа f без
  остановок, причем все лифты едут только вверх. Ваня хочет прокатиться на возможно
  большем количестве лифтов, не переходя пешком по лестнице между этажами.
  Определите максимально возможную последовательность лифтов.
  Вводится число n - количество лифтов. В следующих n строках вводятся пары чисел -
  начальный и конечный этажи для каждого лифта.
  7
  2 6
  5 6
  2 5
  2 2
  6 8
  2 2
  0 2
  Выведите максимально возможное число лифтов
 */
public class ElevatorsDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 7;
        int[][] arr = new int[n][2];
        for (int j = 0; j < n; j ++){
            arr[j][1] = input.nextInt();
            arr[j][0] = input.nextInt();
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
        int result = 0;
        int[] din = new int[n + 2];
        Arrays.fill(din, 0);
        for (int i = 0; i < n + 2; i++){
            for (int[] el : list){
               if (el[0] == i) {
                   din[i] = Math.max(din[i],
                           din[el[1]] < din[i]? din[i] + 1 : din[el[1]] + 1);
                   if (result < din[i]) {
                       result = din[i];
                   }
               }
            }
        }
        
        System.out.println(result);

    }
}
