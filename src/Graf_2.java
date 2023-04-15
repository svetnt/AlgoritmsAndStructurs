import java.util.*;
/* Алгоритм обхода графа в ширину.  Вывести порядок обхода и расстояние от вершины графа
до каждой из вершин
7 6
1 2
2 3
2 4
1 5
5 6
6 7 */
public class Graf_2 {
    static int n, m;
    static List<Integer>[] graf;
    static Queue<Integer> queue;
    static boolean[] used;
    static int[] d, p;
    static List<Integer> patch;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graf = new List[n];
        for (int i = 0; i < n; i++) {
            graf[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++){
            graf[scanner.nextInt() - 1].add(scanner.nextInt() - 1);
        }

        d = new int[n];
      //  p = new int[n];  нужен для восстановления ответа

        used = new boolean[n];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;   p[i] = -1;
                queue.offer(i);
                bfs(queue);
            }
        }
        System.out.println(Arrays.toString(d));
    }

    private static void bfs(Queue queue) {
        if (queue.isEmpty()) {
            return;
        }
        int v = (int) queue.poll();
        System.out.print(v + " ");
        for (int u : graf[v]) {
            if (!used[u]) {
                used[u] = true;
                queue.offer(u);
                d[u] = d[v] +1;
                p[u] = v;
            }
        }
        bfs(queue);
    }
}
