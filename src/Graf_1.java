import java.util.*;

/* В одной неизвестной компьютерной игре "WatchOver" есть герои. Их разнообразное
 количество, целых n штук. Василий для всех героев определил, какой из них сильнее.
 Известно, что если герой A сильнее героя B, а герой  B сильнее героя C, то герой
 A сильнее героя C. Теперь он хочет узнать порядок, в котором герои отсортированы по
  силе. Сначала должен идти самый сильный герой, потом слабее и так далее.
  Сначала на вход программы поступают числа n и m − количество героев в игре и количество
  пар героев для которых известно, какой сильнее. На следующих m строках дано два
  номера героев u,v Герой с номером u сильнее, чем герой с номером v.
  4 3
  1 2
  1 3
  1 4          Ответ 1 4 3 2
 */
public class Graf_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> gr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<Integer>());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            gr.get(sc.nextInt() - 1).add(sc.nextInt() - 1);
        }

        boolean[] used = new boolean[n];
        Stack stack = new Stack();
        for (int i = 0; i < n; i ++) {
            if (!used[i]){
                topoSortUtil(i, used, gr, stack);
            }
        }
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    static void topoSortUtil(int vert, boolean used[], List<List<Integer>> gr, Stack stack) {
        used[vert] = true;
        List<Integer> list = gr.get(vert);
        Collections.sort(list);
        for (Integer el : list) {
            if (!used[el]) {
                topoSortUtil(el, used, gr, stack);
            }
            stack.push(vert);
        }
    }

}

