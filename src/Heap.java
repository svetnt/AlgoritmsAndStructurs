
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
                System.out.println("-");
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
                    System.out.print(" ");    // добавление пробелов
                }
            }
            System.out.print(heapArray[i].getValue());
            if (++columNum == itemsPerRow) { //если последний элемент в строке
                countGaps /= 2; // уменьшаем отступы для следующей строки
                itemsPerRow *= 2;
                columNum = 0;
                System.out.println();
            } else { // переходим к следующему элементу
                for (int j = 0; j < countGaps * 2 - 2; j++) {
                    System.out.print(" ");  //отступы
                }
            }
        }
            System.out.println("\n"+lin);
    }

    public boolean insertNode(int value){  // добавление нового значения
        if (currentAmount == maxSize){
            return false;
        }
        Node nodeNew = new Node(value);  //создание вершины с каким-то значением
        heapArray[currentAmount] = nodeNew; //вершину прицепляем в низ дерева
        displaceUp(currentAmount++);  //пытаемся толкнуть вершину вверх
        return true;
    }

    public Node removeNode(int index){  // удаление элемента по индексу массива
        if(index>0 && index<currentAmount){
            Node root = heapArray[index];
            heapArray[index] = heapArray[--currentAmount]; //элементу с переданным индексом присваиваем значение последнего элемента
            heapArray[currentAmount] = null; // удаление последнего элемента
            displaceDown(index); // пытаемся толкнуть элемент вниз
            return root;
        }
        return null;
    }

    public boolean changeNode(int index, int valueNew){ //замена элемента
        if (index<0 || index>=currentAmount){
            return false;
        }
        int valueOld = heapArray[index].getValue();
        heapArray[index].setValue(valueNew);
        if (valueOld<valueNew){
            displaceUp(index);
        } else {
            displaceDown(index);
        }
        return true;
    }

    private void displaceUp(int index){ // проталкивание элемента вверх
        int parentIndex = (index-1)/2; // индекс родителя
        Node bottom = heapArray[index];
        // пока родитель меньше текущего элемента, меняем их местами
        while (index>0 && heapArray[parentIndex].getValue()<bottom.getValue()){
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex-1)/2; // новый индекс родителя
        }
        heapArray[index] = bottom;
    }

    private void displaceDown(int index){  // проталкивание элемента вниз
        int largerChild; // индекс большего ребенка
        Node top = heapArray[index]; // сщхраняем корень, пока у узла есть хотя бы один потомок
        while (index<currentAmount/2){    // пока элемент не окажется в самом низу:
            int leftChild = 2*index+1;   // индекс левого ребенка
            int rightChild = leftChild+1;  // индеск правого ребенка
            // проверяем, какой ребенок больше - левый или правый:
            if (rightChild < currentAmount && heapArray[leftChild].getValue()<heapArray[rightChild].getValue()){
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getValue()>=heapArray[largerChild].getValue()){
                break; // если вершина больше или равна большему ребёнку, то выйти из метода
            }
            heapArray[index] = heapArray[largerChild]; // земенить вершину большим ребёнком
            index = largerChild; // текущий индекс проталкивается вниз
        }
        heapArray[index]=top;  // это конечное место для элемента
    }
}
