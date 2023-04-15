import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* Дан ориентированный граф. Найдите расстояние от вершины x до всех остальных вершин графа.
Вход. В первой строке содержатся два натуральных числа n и x – количество вершин в графе
и стартовая вершина соответственно. Далее в n строках по n чисел – матрица смежности графа:
 в i-ой строке на j-ом месте стоит “1”, если вершины i и j соединены ребром, и “0”,
 если ребра между ними нет. На главной диагонали матрицы стоят нули.
Выход. Выведите через пробел числа d1, d2, ..., dn, где di равно -1, если путей между x
и i нет, в противном случае это минимальное расстояние между x и i.
Пример входа
6 5
0 1 1 0 0 0
1 0 0 0 0 0
1 1 0 0 0 0
0 0 0 0 1 0
0 0 1 1 0 0
0 1 0 0 0 0
Output:   2 2 1 1 0 -1
 */
public class Graf_4 {
    static int n, x;
    static int[][] graf;
    static int[] distant;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        graf = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graf[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        distant = new int[n + 1];
        Arrays.fill(distant, -1);

        bfs(x);

        for (int i = 1; i <= n ; i++) {
            System.out.print(distant[i] + " ");
        }
    }

    private static void bfs(int start) {
        distant[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u = 1; u <= n; u++) {
                if (graf[v][u] == 1 && distant[u] == -1) {
                    queue.offer(u);
                    distant[u] = distant[v] + 1;
                }
            }
        }
    }
}
