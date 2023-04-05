package SportProgr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* Всего в конторе работает Н людей. Каждый определяется фамилией, состоящей из строчных букв
  латинского алфавита. Последние буквы фамилий на карточках стерлись, но бухгалтер помнит
  всех по префиксам. Для ускорения работы бухгалтера необходимо реализовать поиск К -го в
  лексикографичксом порядке человека среди всех с заданным префиксом.(вывести номер фамилии
  в исходном наборе)
  5 3
  ad
  a
  abc
  aboba
  b
  3 a                        4
  2 ab                       4
  1 b                        5
 */
public class Tin_osen_22_E {

    public static void main(String[] args) {
        int n = 5;
        int q = 3;
        String[] arr = new String[]{"ad", "a", "abc", "aboba", "b"};
        Map<String, Integer> map = new HashMap<>();
        int number = 1;
        for (String el : arr){
            map.put(el, number);
            number++;
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int k = 1;
        String search = "b";
        String result = binarySearch(arr, search, k);
        if(result.equals("-1")) {
            System.out.println("-1");
        } else {
            System.out.println(map.get(result));
        }

    }

    private static String binarySearch(String[] arr, String sear, int k) {
        int left = -1;
        int right = arr.length;
        while (left + 1 < right) {
            int middle = (right + left) >> 1;
            String current = arr[middle];
            if (sear.compareTo(current) > 0) {
                left = middle;
            } else {
                right = middle;
            }
        }
        if (right < arr.length && arr[right -1 + k].startsWith(sear)) {
            return arr[right -1 + k];
        } else {
            return "-1";
        }
    }

}
