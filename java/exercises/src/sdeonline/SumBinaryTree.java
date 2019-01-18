package sdeonline;

import tree.BinaryTree;
import tree.BinaryTreeNode;

import java.util.function.Function;

public class SumBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.root = new BinaryTreeNode<>(23);

        tree.root.left = new BinaryTreeNode<>(45);
        tree.root.right = new BinaryTreeNode<>(56);

        tree.root.right.right = new BinaryTreeNode<>(100);

        sumTree(tree);

        tree.visitInOrder(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
               System.out.println(integer);
               return integer;
            }
        });
    }

    public static void sumTree(BinaryTree<Integer> tree) {
        // Just traversing the Tree in post orden solves the problem elegantly
        visit(tree.root);
    }

    // The result of the visit is just the sum of the nodes
    public static int visit(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return node.value;
        }

        int sum1 = visit(node.left);
        int sum2 = visit(node.right);

        int total = sum1 + sum2;

        node.value = total;

        return total;
    }
}
