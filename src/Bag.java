import java.util.Scanner;

// задача на заполнение рюкзака. Максимально дорого наполнить. Тестовый пример: размер рюкзака 10,
// есть 4 вещи размером 6 стоимостью 30, 3 - 14, 4 - 16, 2 - 9

public class Bag {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int bagSize = input.nextInt();
        int[] itemPrices = new int[input.nextInt()];
        for (int i=0; i<itemPrices.length; i++) {
            itemPrices[i] = input.nextInt();
        }
        int[] itemSizes = new int[itemPrices.length];
        for (int i=0; i<itemSizes.length; i++) {
            itemSizes[i] = input.nextInt();
        }
        System.out.println(new Bag().searchBag(bagSize,itemPrices,itemSizes));
    }

    private int searchBag(int bagSize, int[] itemPrices, int[] itemSizes){
        int n = itemPrices.length;
        int[][] dp = new int[bagSize+1][n+1];
        for (int i = 1; i<=n; i++){
            for (int size = 1; size<=bagSize; size++){
                if (itemSizes[i-1]<=size){
                    int prev = dp[size][i-1];
                    int curr = dp[size-itemSizes[i-1]][i-1]+itemPrices[i-1];
                    dp[size][i] = Math.max(prev,curr);
                } else {
                    dp[size][i] = dp[size][i-1];
                }
            }
        }
        return dp[bagSize][n];
    }
}
