// Даны число n - количество ступенек лестницы и целые числа от -1000 до 1000, которыми помечены ступеньки.
// Найдите максимальную сумму, которую можно получить, идя по лестнице снизу вверх (от нулевой до n-й ступеньки),
// каждый раз поднимаясь на одну или две

public class Stairs {

    public static void main(String[] args) {
        int n = 7;
        int[] inputArr = {1, 1, -2, -4, -6, 2, 2};
        int[] arr = new int[n+1];
        arr[0] = 0;
        for (int i=1; i<=n; i++){
            arr[i] = inputArr[i-1];
        }
        System.out.println(new Stairs().stairsSum(arr, n));
    }

    private int stairsSum(int[] inputArr, int n){   //рекурсия
        if (n==0) return inputArr[0];
        if (n==1) return inputArr[1];
        return Math.max(stairsSum(inputArr,(n-2)),stairsSum(inputArr,(n-1)))+inputArr[n];

    }

   /* private int stairsSum(int[] inputArr) {       //без рекурсии
        int n = inputArr.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        sum[1] = inputArr[0];
        for (int i=2; i<=n; i++){
            sum[i] = Math.max(sum[i-2],sum[i-1])+inputArr[i-1];
        }
           return sum[n];
    }*/
}
