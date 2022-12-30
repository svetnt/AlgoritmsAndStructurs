package SportProgr;

import java.util.Scanner;

public class Valutes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] course = new int[3];
        int[] acc = new int[3];
        for (int i = 0; i < 3; i++) {
            course[i] = sc.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            acc[i] = sc.nextInt();
        }

        System.out.println(count(course, acc));
    }

    public static int count(int[] course, int[] acc) {

        if (acc[0] < course[0] && acc[1] < course[1] && acc[0]!=0 && acc[1]!=0
                || acc[0] < course[0] && acc[2] < course[2] && acc[0]!=0 && acc[2]!=0
                || acc[1] < course[1] && acc[2] < course[2] && acc[1]!=0 && acc[2]!=0
                || acc[0] < course[0] && acc[1] < course[1] && acc[2] < course[2]) {
            return 1;
        }

        if (acc[0] < course[0] && acc[0]!=0) {
            acc[1] = acc[1] + acc[2] * course[1] / course[2];
            int firstBegin = acc[1];
            acc[2] = acc[2] % course[2];
            int threeBegin = acc[2];
            int result = 1;
            int i = 1;
            while (acc[1] - course[1] >= 0) {
                acc[1] = firstBegin - course[1] * i;
                acc[2] = threeBegin + course[2] * i;
                result++;
                i++;
            }
            return result;
        }

        if (acc[1] < course[1] && acc[1]!=0) {
            acc[0] = acc[0] + acc[2] * course[0] / course[2];
            int firstBegin = acc[0];
            acc[2] = acc[2] % course[2];
            int threeBegin = acc[2];
            int result = 1;
            int i = 1;
            while (acc[0] - course[0] >= 0) {
                acc[0] = firstBegin - course[0] * i;
                acc[2] = threeBegin + course[2] * i;
                result++;
                i++;
            }
            return result;
        }

        if (acc[2] < course[2] && acc[2]!=0) {
            acc[0] = acc[0] + acc[1] * course[0] / course[1];
            int firstBegin = acc[0];
            acc[1] = acc[1] % course[1];
            int threeBegin = acc[1];
            int result = 1;
            int i = 1;
            while (acc[0] - course[0] >= 0) {
                acc[0] = firstBegin - course[0] * i;
                acc[1] = threeBegin + course[1] * i;
                result++;
                i++;
            }
            return result;
        }

        acc[0] = acc[0] + acc[1] * course[0] / course[1] + acc[2] * course[0] / course[2];
        int firstBegin = acc[0];
        acc[1] = acc[1] % course[1];
        int secondBegin = acc[1];
        acc[2] = acc[2] % course[2];
        int threeBegin = acc[2];

        int result = 1;
        int i = 1;
        int j = 1;
        while (acc[0] - course[0] >= 0) {
            acc[0] = firstBegin - course[0] * i;
            acc[1] = secondBegin + course[1] * i;
            result++;
            i++;
            j = 1;
            while (acc[1] - course[1] >= 0) {
                acc[1] = acc[1] - course[1];
                acc[2] = threeBegin + course[2] * j;
                result++;
                j++;
            }
        }
        return result;
    }
}

