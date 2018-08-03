package linkedlist;


import java.util.HashSet;

/* Remove duplicates from a LinkedList */

public class Exercise21 {
    public static void main(String[] args) {
        System.out.println("O(n)");

        LinkedListNode head = buildList(args);
        removeDups(head);
        printLinkedList(head);

        System.out.println("O(n^2)");

        LinkedListNode head2 = buildList(args);
        removeDups2(head2);
        printLinkedList(head2);
    }

    /* O(n) */
    public static void removeDups(LinkedListNode head) {
        HashSet<Integer> hash = new HashSet<>();

        LinkedListNode current = head;
        LinkedListNode previous = null;

        while(current != null) {
            int value = current.value;

            if(hash.contains(value)) {
                // In this case the previous is not updated at all
                previous.next = current.next;
            }
            else {
                hash.add(value);
                // Only in this case the previous is advanced to be the current
                previous = current;
            }

            current = current.next;
        }
    }

    /* O(n^2) */
    public static void removeDups2(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode following = null;
        LinkedListNode prev = null;

        while(current != null) {
            int value = current.value;
            following = current.next;
            // Prev is the previous of the following so in this case "current"
            prev = current;
            while(following != null) {
                if (following.value == value) {
                    prev.next = following.next;
                }
                else {
                        prev = following;
                }
                following = following.next;
            }
            current = current.next;
        }
    }

    public static LinkedListNode buildList(String[] values) {
        LinkedListNode[] nodes = new LinkedListNode[values.length];

        for(int j = 0; j < values.length; j++) {
            nodes[j] = new LinkedListNode();
            if (j != 0) {
                nodes[j - 1].next = nodes[j];
            }
            nodes[j].value = Integer.parseInt(values[j]);
        }

        return nodes[0];
    }

    public static void printLinkedList(LinkedListNode head) {
        LinkedListNode pointer = head;

        while(pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }
}
