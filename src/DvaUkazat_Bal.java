import java.util.*;

/* n юношей и m девушек идут на бал. Известно, что на бал будут приглашены несколько
 пар юноша-девушка, причем уровень умений танцевать партнеров в каждой паре должен
 отличаться не более чем на единицу.Для каждого юноши известен уровень его умения танцевать.
  Аналогично, для каждой девушки известен уровень ее умения танцевать.
  Напишите программу, которая определит наибольшее количество пар, которое можно образовать
   из n юношей и m девушек.
 */
public class DvaUkazat_Bal {
    public static void main(String[] args) {
        int boyAmount = 4;
        int gerlAmount = 5;
        List<Integer> boyLevel = new ArrayList<>();
        List<Integer> gerlLevel = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < boyAmount; i++){
            boyLevel.add(sc.nextInt());
        }
        for (int i = 0; i < gerlAmount; i++){
            gerlLevel.add(sc.nextInt());
        }
        Collections.sort(boyLevel);
        Collections.sort(gerlLevel);
        int result = 0;
        while (boyLevel.size() > 0 && gerlLevel.size() > 0){
            int boy = boyLevel.get(0);
            int gerl = gerlLevel.get(0);
            if(Math.abs(boy - gerl) <= 1){
                result++;
                boyLevel.remove(0);
                gerlLevel.remove(0);
            } else {
                if(boy > gerl){
                    gerlLevel.remove(0);
                } else {
                    boyLevel.remove(0);
                }
            }
        }

       /*  На массивах с указателями:
        int[] boyLevel = new int[boyAmount];
        int[] gerlLevel = new int[gerlAmount];for (int i = 0; i < boyAmount; i++){
            boyLevel[i] = sc.nextInt();
        }
        for (int i = 0; i < gerlAmount; i++){
            gerlLevel[i] = sc.nextInt();
        }
        Arrays.sort(boyLevel);
        Arrays.sort(gerlLevel);
        int ukaz = 0;
        int result = 0;
        for (int i = 0; i < boyAmount; i++){
            while (boyLevel[i] +1 >= gerlLevel[ukaz] && ukaz < gerlAmount){
                if(Math.abs(boyLevel[i] - gerlLevel[ukaz]) <= 1){
                    result++;
                    ukaz++;
                    break;
                }
            }
        }*/
        System.out.println(result);
    }
}
