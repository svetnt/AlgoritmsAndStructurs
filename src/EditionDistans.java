import java.util.Scanner;

public class EditionDistans {

    private String first;
    private String second;
    int[][] dist;
    boolean[][] calc;

    public static void main(String[] args) {
        new EditionDistans().run();
    }

    private void run(){
        Scanner input = new Scanner(System.in);
        first = input.next();
        second = input.next();
        dist = new int[first.length()+1][second.length()+1];
        for (int n=0; n<=first.length(); n++){
            for (int m=0; m<=second.length(); m++){
                if (n==0){
                    dist[n][m] = m;
                } else {
                    if (m==0){
                        dist[n][m] = n;
                    } else {
                        int insert = dist[n-1][m]+1;
                        int delete = dist[n][m-1]+1;
                        int swap = dist[n-1][m-1]+(first.charAt(n-1)==second.charAt(m-1)? 0 : 1);
                        dist[n][m] = Math.min(insert, Math.min(delete,swap));
                    }
                }
            }
        }
        System.out.println(dist[first.length()][second.length()]);

        String fLine = "";
        String sLine = "";
        int n = first.length();
        int m = second.length();
        while (n>0 || m>0){
            if (n==0){
                fLine = "-"+fLine;
                sLine = second.charAt(m-1)+sLine;
                m--;
            } else {
                if (m == 0) {
                    sLine = "-" + sLine;
                    fLine = first.charAt(n-1)+fLine;
                    n--;
                } else {
                    int insert = dist[n-1][m]+1;
                    int delete = dist[n][m-1]+1;
                    int swap = dist[n-1][m-1]+(first.charAt(n-1)==second.charAt(m-1)? 0 : 1);
                    if (insert<delete && insert<swap){
                        fLine = "-"+fLine;
                        sLine = second.charAt(m-1)+sLine;
                        m--;
                    } else {
                        if (delete<swap){
                            sLine = "-" + sLine;
                            fLine = first.charAt(n-1)+fLine;
                            n--;
                        } else {
                            sLine = second.charAt(m-1) + sLine;
                            fLine = first.charAt(n-1)+fLine;
                            n--;
                            m--;
                        }
                    }

                }
            }
        }
        System.out.println(fLine);
        System.out.println(sLine);
       // calc = new boolean[first.length()+1][second.length()+1];
       // System.out.println(editionDistans(first.length(), second.length()));
    }

    private int editionDistans(int n, int m) {  // рекурсия
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (calc[n][m]){
            return dist[n][m];
        }
        int resultInsert = editionDistans(n-1,m)+1;
        int resultDelete = editionDistans(n,m-1)+1;
        int resultSwap;
        if (first.charAt(n-1)==second.charAt(m-1)) {
            resultSwap = editionDistans(n - 1, m - 1);
        } else {
            resultSwap = editionDistans(n-1, m-1)+1;
        }
        int result = Math.min((Math.min(resultDelete, resultInsert)), resultSwap);
        dist[n][m] = result;
        calc[n][m] = true;
        return result;
    }

}
