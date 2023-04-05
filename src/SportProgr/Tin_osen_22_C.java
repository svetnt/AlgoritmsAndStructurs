package SportProgr;

public class Tin_osen_22_C {
    /* Есть данные за Н дней по подключению и отключению услуги. В первый день услуга только
    подключалась, во второй - только отключалась и тд. Найти максимально возможное количество прибыли,
    которое можно получить, поменяв местами данные не более чем за 2 дня. Стоимость услуги равна 1.
    Можно менять данные не более чем за 2 дня, в том числе не менять ничего.
    2       1 2       ответ 1
    3       2 2 2     ответ 2
     */

    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[]{2, 2, 2};

        int minPositiv = 0;
        int maxNegativ = 0;

        for (int i = 0; i < arr.length; i++){
            if(i%2 != 0) {
                if (minPositiv > arr[i - 1]) {
                    minPositiv = arr[i - 1];
                }
            } else {
                if (maxNegativ < arr[i]) {
                    maxNegativ = arr[i];
                }
            }
        }
        System.out.println(maxNegativ - minPositiv);
    }
}
