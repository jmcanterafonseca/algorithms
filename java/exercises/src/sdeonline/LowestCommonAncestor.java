package sdeonline;

import tree.BinaryTree;
import tree.BinaryTreeNode;

// See http://en.wikipedia.org/wiki/Lowest_common_ancestor
public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(34);

        tree.root.left = new BinaryTreeNode<>(21, tree.root);
        tree.root.right = new BinaryTreeNode<>(10, tree.root);

        BinaryTreeNode<Integer> right = tree.root.right;
        right.left = new BinaryTreeNode<>(99, right);
        right.right = new BinaryTreeNode<>(180, right);


        System.out.println(LCA(tree.root.left,right.right));
    }

    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> n1,BinaryTreeNode<Integer> n2) {
        if (n1.parent == null) {
            return n1;
        }

        if (n2.parent == null) {
            return n2;
        }

        if (n1.parent == n2.parent) {
            return n1.parent;
        }

        if (n1.parent == n2) {
            return n2;
        }

        if(n2.parent == n1) {
            return n1;
        }

        return LCA(n1.parent,n2.parent);
    }
}
