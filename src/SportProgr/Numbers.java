package SportProgr;
// У Кости есть бумажка, на которой написано n чисел. Также у него есть возможность не больше, чем
// к раз взять любое число с бумажки, после чего закрасить одну из старых цифр, а на ее месте написать
// новую произвольную цифру. На какое максимальное значение Костя сможет увеличить сумму всех чисел?
// Формат входных данных
// В первой строке входного файла даны два целых числа n,k - количество чисел на бумажке и ограничение
// на число операций. Во второй строке записано n чисел a — числа на бумажке
// Формат выходных данных
// В выходной файл выведите одно число — максимальную разность между конечной и начальной суммой.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];
        List<Long> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            arr[i] = input.nextInt();

            int weigt = 1;
            while(n>0){

            }
        }


      /*  List<Long> values = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();

            int weight = 1;

            while (arr[i] > 0) {
                int digit = arr[i] % 10;
                long gain = (long) (9 - digit) * weight;
                values.add(gain);
                weight *= 10;
                arr[i] /= 10;
            }
        }

        scanner.close();

        long afterSum = values.stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .reduce(0L, Long::sum);

        System.out.println(afterSum);*/
    }
}
