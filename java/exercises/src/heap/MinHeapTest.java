package heap;

public class MinHeapTest {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        for(String arg: args) {
            Integer value = Integer.parseInt(arg);
            heap.insertValue(value);
        }

        System.out.println("Min Value: " + heap.getMin());

        System.out.println("In Order Traversal");
        heap.visitInOrder(x -> { System.out.println(x); return 0; });

        System.out.println("Pre Order Traversal");
        heap.visitPreOrder();

        System.out.println("Post Order Traversal");
        heap.visitPostOrder();
    }
}
