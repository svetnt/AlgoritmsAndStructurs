import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Если в массиве несколько одинаковых элементов, найти позицию последнего из них
public class BinarySearshNew {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new BinarySearshNew().run());
    }

    private int run() throws FileNotFoundException {

        Scanner input = new Scanner(new File("input.txt"));
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int key = input.nextInt();

        int left = -1, right = n;
        while(left+1<right) {
            int index = (left + right) >> 1;
            if (array[index] <= key) {
                left = index;
            } else {
                right = index;
            }
        }
        if(left>=0 && array[left]==key){
            return left+1;
        } else {
            return -1;
        }
    }

    public static class DvaUkazat_Bal {
    }
}
