// У вас есть примитивный калькулятор, который умеет выполнять всего три операции с текущим числом x:
// заменить x на 2x, 3x или x+1. По данному целому числу n определите минимальное число операций k,
// необходимое, чтобы получить n из 1. Выведите k и последовательность промежуточных чисел.

import java.util.Scanner;

public class Calc {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        new Calc().count(n);
    }

    private void count(int n) {
        int[] sum = new int[n+1];
        int[] prev = new int[n+1];
        for (int i=1; i<=n; i++){
            run(sum, prev, i,i*2, n);
            run(sum,prev,i, i*3,n);
            run(sum, prev, i, i+1, n);
        }
        System.out.println(sum[n]);

        int min = sum[n];
        int[] step = new int[min+1];
        for (int i=min; i>=0; i--){
            step[i] = n;
            n = prev[n];
        }
        for (int i=0; i<min+1; i++){
            System.out.print(step[i]+" ");
        }
    }

    private void run(int[] sum, int[] prev, int i, int k, int n){
        if (k>n){
            return;
        }
        if (sum[k]==0 || sum[k]>sum[i]+1){
            sum[k] = sum[i]+1;
            prev[k] = i;
        }
    }
}
