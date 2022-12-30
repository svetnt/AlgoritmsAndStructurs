package SportProgr;

import java.util.Scanner;

public class YBLetters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] name = sc.nextLine().split(" ");
        char[] color = sc.nextLine().toCharArray();

        int count = 0;
        int k = 0;

        for (int i = 0; i < name.length; i++) {

            int wordSize = name[i].length();

            for (int j = k+1; j < wordSize+k; j++) {
                if (color[j] == color[j - 1]) {
                   count++;
                   break;
                }
            }
            k += wordSize;
        }

        System.out.println(count);
    }
}
