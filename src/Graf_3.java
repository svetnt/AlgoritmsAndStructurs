import java.util.*;

/* задан связный ориентированный граф с N вершинами и M ребрами (1≤N≤20000,
1≤M≤200000). Найдите компоненты сильной связности заданного графа.
Граф задан следующим образом: первая строка содержит числа N и M. Каждая из следующих
M строк содержит описание ребра – два целых числа из диапазона от 1 до N – номера
начала и конца ребра.
На первой строке выведите число K – количество компонент сильной связности в заданном
графе. На следующей строке выведите N чисел – для каждой вершины выведите номер компоненты
сильной связности, которой принадлежит эта вершина. Компоненты сильной связности должны
 быть занумерованы таким образом, чтобы ответ был лексикографически наименьшей строкой.
Sample Input:
10 14
4 9
7 8
2 5
1 4
9 2
10 6
6 5
8 3
5 9
4 3
8 7
5 1
2 1
6 10
Sample Output:
4
1 1 2 1 1 3 4 4 1 3

 */
public class Graf_3 {
    static int n, m, currentCmp = 0;
    static List<Integer>[] graf, grafRev;
    static boolean[] used;
    static List<Integer> order;
    static int[] result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        result = new int[n];
        graf = new List[n];
        grafRev = new List[n];
        for (int i = 0; i < n; i++) {
            graf[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            grafRev[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graf[x - 1].add(y - 1);
            grafRev[y - 1].add(x - 1);
        }

        used = new boolean[n];
        order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                topSort(i);
            }
        }
        Collections.reverse(order);

        Arrays.fill(used,false);

        for (int i = 0; i < n; i++){
            if (!used[i]){
                ++currentCmp;
                dfs(i);
            }
        }

        System.out.println(Arrays.toString(result));
    }

    private static void topSort(int v) {
        used[v] = true;
        for (Integer i : graf[v]) {
            if (!used[i]) {
                topSort(i);
            }
        }
        order.add(v);
    }

    private static void dfs(int v) {
        used[v] = true;
        result[v] = currentCmp;
        for (Integer i : grafRev[v]) {
            if (!used[i]) {
                dfs(i);
            }
        }
    }

}
