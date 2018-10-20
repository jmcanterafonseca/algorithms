package sdeonline;

import tree.BinaryTree;
import tree.BinaryTreeNode;

// Saves all nodes of a Binary Tree into a Linked List
// by using Right node as Next node and Left Node as Previous Node.
public class BinaryTree2LinkedList {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(34);

        tree.root.left = new BinaryTreeNode<>(21, tree.root);
        tree.root.right = new BinaryTreeNode<>(10, tree.root);

        BinaryTreeNode<Integer> right = tree.root.right;
        right.left = new BinaryTreeNode<>(99, right);
        right.right = new BinaryTreeNode<>(180, right);

        DoubleLinkedList out = solution(tree);

        printList(out);
    }

    private static DoubleLinkedList solution(BinaryTree<Integer> tree) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.start = visit(tree.root);

        return list;
    }

    // Main idea is to implement an inorder visit of the tree
    // Each visit to a node constructs a sublist with all the nodes of such subtree
    private static DoubleLinkedListNode<Integer> visit(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return null;
        }

        DoubleLinkedListNode<Integer> leftList = visit(node.left);

        DoubleLinkedListNode<Integer> listNode = new DoubleLinkedListNode<>();
        listNode.value = node.value;

        listNode.previous = leftList;
        if (leftList != null) {
            leftList.next = listNode;
        }

        DoubleLinkedListNode<Integer> rightList = visit(node.right);

        listNode.next = rightList;
        if (rightList != null) {
            rightList.previous = listNode;
        }

        // Ensure we return the list pointing to the real start node
        if (listNode.previous != null) {
            return listNode.previous;
        }
        else {
            return listNode;
        }
    }


    // Auxiliary function just for printing the list
    private static void printList(DoubleLinkedList<Integer> list) {
        if (list.start == null) {
            return;
        }

        System.out.println(list.start.value);
        DoubleLinkedListNode<Integer> node = list.start.next;

        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
