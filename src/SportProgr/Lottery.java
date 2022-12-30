package SportProgr;

import java.util.Scanner;

public class Lottery {

    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();

        int polovina = n >> 1;

        if (n % 2 == 0) {
            System.out.println(polovina + " " + polovina);
        } else {
            double sqr = Math.sqrt(n);
            int firstNumber = 0, secondNumber = 0;
            for (int i = 3; i <= sqr; i = i + 2) {
                if (n%i==0){
                    firstNumber = n/i;
                    secondNumber = n-firstNumber;
                    System.out.println(firstNumber+" "+secondNumber);
                    return;
                }
            }
            firstNumber = 1;
            secondNumber = n-1;
            System.out.println(firstNumber+" "+secondNumber);
        }
    }
}
