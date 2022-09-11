
// Класс описывает кучу
public class Heap {

    private Node[] heapArray;   // массив с вершинами
    private int maxSize;        // размер массива
    private int currentAmount;  // количество узлов

    public Heap(int maxSize){      // конструктор создаёт пустую кучу
        this.maxSize = maxSize;
        this.currentAmount = 0;
        this.heapArray =new Node[maxSize];
    }

    public void displeyHeap(){     // метод выводит кучу в консоль
        System.out.println("Куча состоит из чисел: ");

        for (int i=0; i<currentAmount; i++){
            if (heapArray[i] != null){
                System.out.println(heapArray[i].getValue()+" ");
            } else {
                System.out.println("*");
            }
        }
        System.out.println();

        int countGaps = 32;
        int itemsPerRow = 1;
        int columNum = 0;

        String lin = "**********************************************************";
        System.out.println(lin);
        for (int i=0; i<currentAmount; i++) {
            if (columNum == 0) {   //если первый элемент в текущей строке
                for (int j = 0; j < countGaps; j++) {
                    System.out.println(" ");    // добавление пробелов
                }
            }
            System.out.println(heapArray[i].getValue());
            if (++columNum == itemsPerRow) { //если последний элемент в строке
                countGaps /= 2; // уменьшаем отступы для следующей строки
                itemsPerRow *= 2;
                columNum = 0;
                System.out.println();
            } else { // переходим к следующему элементу
                for (int j = 0; j < countGaps * 2 - 2; j++) {
                    System.out.println(" ");  //отступы
                }
            }
        }
            System.out.println("\n"+lin);
    }
}
