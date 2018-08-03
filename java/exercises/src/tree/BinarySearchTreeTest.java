package tree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        for(String arg: args) {
            Integer value = Integer.parseInt(arg);
            tree.insert(value);
        }

        System.out.println("Tree Root: " + tree.root.value);

        System.out.println("In Order Traversal");
        tree.visitInOrder(x -> { System.out.println(x); return 0; });

        System.out.println("Pre Order Traversal");
        tree.visitPreOrder();

        System.out.println("Post Order Traversal");
        tree.visitPostOrder();
    }
}
