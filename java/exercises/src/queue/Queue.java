package queue;

public class Queue<T> {
    private class QueueNode<T> {
        public QueueNode(T value) {
            this.value = value;
        }

        public T value;
        public QueueNode next;
    }

    // First node in the queue
    private QueueNode<T> first = null;
    private QueueNode<T> last = null;

    public void add(T element) {
        QueueNode<T> node = new QueueNode<T>(element);
        if (last != null) {
            last.next = node;
        }

        if (first == null) {
            first = node;
        }

        last = node;
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        QueueNode<T> out = first;

        first = first.next;

        // Avoid last to point to wrongly to the last element
        // and enable the garbage collector
        if (first == null) {
            last = null;
        }

        return out.value;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
