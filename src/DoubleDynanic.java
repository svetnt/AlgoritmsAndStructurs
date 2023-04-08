import java.util.Arrays;

/* В прямоугольной таблице NxM в начале игрок находится в левой верхней клетке.
  За один ход ему разрешается перемещаться в соседнюю клетку либо вправо, либо вниз
  (влево и вверх перемещаться запрещено). Посчитайте, сколько есть способов у игрока
   попасть в правую нижнюю клетку.
 */
public class DoubleDynanic {
    public static void main(String[] args) {
        int n = 1;
        int m = 10;
        long[][] din = new long[n][m];
        din[0][0] = 0;
        for (int i = 1; i < m; i++) {
            din[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            din[i][0] = 1;
        }

        for (int i = 1; i < n; i ++){
            for (int j = 1; j < m; j++){
                din[i][j] = din[i][j - 1] + din[i - 1][j];
            }
        }

        System.out.println(din[n - 1][m - 1]);
    }
}
