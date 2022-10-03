import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1};
        int[] result = new InsertSort().insertS(arr);
        System.out.println(Arrays.toString(result));
    }

    private int[] insertS(int[] arr){
        int temp=0;
        for (int i=1; i< arr.length; i++){
            for (int j=i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
