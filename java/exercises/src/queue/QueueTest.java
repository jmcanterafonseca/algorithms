package queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        for(String arg: args) {
           int value = Integer.parseInt(arg);

           queue.add(value);
        }

        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

        // queue.remove();
    }
}
