import java.util.Arrays;

public class Proba {
    public static void main(String[] args) {
        int n = 12;

        int[] din = new int[n + 1];
        Arrays.fill(din, 0);
        din[1] = 1;
        din[2] = 1;
        din[3] = 1;
        for (int i = 4; i <= n; i++) {
            din[i] = din[i -1] + 1;
            if (i%2 == 0) {
                din[i] = Math.min(din[i], din[i / 2] + 1);
            }
            if (i%3 == 0) {
                din[i] = Math.min(din[i], din[i / 3] + 1);
            }
        }

        String result = String.valueOf(n);
        int i = n;
        while (i > 1) {
            if (din[i] == din[i - 1] + 1) {
                i--;
                result = i + " " + result;
                continue;
            }
            if (i%3 == 0 && din[i] == din[i / 3] + 1) {
                i = i / 3;
                result = i + " " + result;

                continue;
            }
            i = i / 2;
            result = i + " " + result;
        }

        System.out.println(Arrays.toString(din));
        System.out.println(result);
    }
}
