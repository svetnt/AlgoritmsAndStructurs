import java.util.*;

/* Алгоритм Дейкстры
Нахождение кратчайших путей от одной вершины (стартовой) до всех остальных вершин в
взвешенном графе, при условии, что все ребра в графе имеют неотрицательные веса
Вход. В первой строке содержатся два натуральных числа n и m – количество вершин и ребер
в графе. Далее в m строках по 3 числа - начало, конец и вес ребра.
Выход:

 */
public class Graf_5 {
    static int n, m;
    static List<int[]> edges;
    static List<List<Integer>> graf;

//     class Node{
//        int vertex, weight;
//
//        Node(int vertex, int weight){
//            this.vertex = vertex;
//            this.weight = weight;
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edges.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }

        for (int[] e : edges){
            System.out.println(Arrays.toString(e));
        }

//        for (int start = 0; start < n; start++) {
//            findShortesPatch(start);
//        }
    }

//    private static void findShortesPatch(int start){
//        PriorityQueue<Nod> miniHeap = new PriorityQueue<>(Comparator.comparingInt(nod -> nod.weight));
//        miniHeap.add(new Nod(start, 0));
//        List<Integer> distans = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
//        distans.set(start, 0);
//        boolean[] used = new boolean[n];
//        used[start] = true;
//        int[] prev = new int[n];
//        prev[start] = -1;
//        while (!miniHeap.isEmpty()){
//            Nod nod = miniHeap.poll();
//            int u = nod.vertex;
//            for (int i = 0; i < m; i++) {
//                if (edges.get(i)[0] == u){
//                    int v = edges.get(i)[1];
//                    int wei = edges.get(i)[2];
//                    if (!used[v] && distans.get(u) + wei < distans.get(v)){
//                        distans.set(v, distans.get(u) + wei);
//                        prev[v] = u;
//                        miniHeap.add(new Nod(v, distans.get(v)));
//                    }
//                }
//            }
//            used[u] = true;
//            List<Integer> rout = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                if (i != start && distans.get(i) != Integer.MAX_VALUE){
//                    getRoute(prev, i, rout);
//                    System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
//                            start, i, distans.get(i), rout);
//                    rout.clear();
//                }
//            }
//        }
//    }
//
//    private static void getRoute(int[] prev, int i, List<Integer> route) {
//        if (i >= 0) {
//            getRoute(prev, prev[i], route);
//            route.add(i);
//        }
//    }
}
