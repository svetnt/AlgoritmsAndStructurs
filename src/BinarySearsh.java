import java.util.Scanner;

public class BinarySearsh {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int k = input.nextInt();
        int[] key = new int[k];
        for (int i = 0; i < k; i++) {
            key[i] = input.nextInt();
        }
        for (int i = 0; i < k; i++) {
            System.out.print(run(array, key[i]) + " ");
        }
    }

    static int run(int[] array, int key) {
        int left = 0, richt = array.length - 1;
        while (left <= richt) {
            int index = (left + richt) >> 1;
            if (array[index] == key) {
                return index + 1;
            } else {
                if (array[index] < key) {
                    left = index + 1;
                } else {
                    richt = index - 1;
                }
            }
        }
        return -1;
    }

}
