package SportProgr;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Xor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextLong();
        }

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            long max = 0;
            for (Long elem : set) {
                long temp = arr[i] ^ elem;
                if (temp > max) {
                    max = temp;
                }
            }
            set.add(arr[i]);
            System.out.println(max);
        }
    }
}
