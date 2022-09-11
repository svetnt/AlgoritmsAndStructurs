public class Main {

    public static void main(String[] args) {

        Heap myHeap = new Heap(31);
        myHeap.insertNode(120);
        myHeap.insertNode(40);
        myHeap.insertNode(50);
        myHeap.insertNode(80);
        myHeap.insertNode(20);
        myHeap.insertNode(100);
        myHeap.insertNode(150);
        myHeap.insertNode(30);
        myHeap.insertNode(210);
        myHeap.insertNode(180);
        myHeap.insertNode(10);
        myHeap.insertNode(90);

      //  myHeap.displeyHeap();

       // myHeap.changeNode(0, 16);
        //myHeap.displeyHeap();

        myHeap.removeNode(3);
        myHeap.displeyHeap();
    }
}
