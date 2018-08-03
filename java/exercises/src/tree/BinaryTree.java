package tree;

import java.util.function.Function;

// Binary Tree. Cracking the Coding interview. Chapter 4.
public class BinaryTree<T> {
    public BinaryTreeNode<T> root = null;

    public BinaryTree(T rootValue) {
        root = new BinaryTreeNode<T>(rootValue);
    }

    public BinaryTree() {
    }

    // Inserts a new value by creating a new node and adding it to the first
    // available hole in the tree
    public void insert(T value) {
        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(value);

        if (root == null) {
            root = new BinaryTreeNode<T>(value);
        }
        else {
            insertNode(newNode, root);
        }

        rebalance(newNode.parent);
    }

    protected void insertNode(BinaryTreeNode<T> newNode,BinaryTreeNode<T> startNode) {
        if (startNode.left == null) {
            startNode.left = newNode;
            newNode.parent = startNode;
        }
        else if (startNode.right == null) {
            startNode.right = newNode;
            newNode.parent = startNode;
        }
        else {
            insertNode(newNode, startNode.left);
        }
    }

    // By default no rebalance should happen in a conventional binary tree
    protected void rebalance(BinaryTreeNode<T> startNode) {
    }

    // Visits the tree (in order). First left branch, then current Node, then right branch
    private void visitInOrder(BinaryTreeNode<T> startNode, Function<T,Integer> visitor) {
        if (startNode == null) {
            return;
        }

        visitInOrder(startNode.left, visitor);

        // Visit
        visitor.apply(startNode.value);

        visitInOrder(startNode.right, visitor);
    }

    // Visits the tree (in order). First left branch, then current Node, then right branch
    public void visitInOrder(Function<T,Integer> visitor) {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }

        visitInOrder(root, visitor);
    }

    // Visits the tree (pre order). First current Node, then left branch, right branch
    private void visitPreOrder(BinaryTreeNode<T> startNode) {
        if (startNode == null) {
            return;
        }

        // Visit
        System.out.println(startNode.value);

        visitPreOrder(startNode.left);

        visitPreOrder(startNode.right);
    }

    // Visits the tree (preorder)
    public void visitPreOrder() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }

        visitPreOrder(root);
    }

    // Visits the tree (post order)
    public void visitPostOrder() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }

        visitPostOrder(root);
    }

    // Visits the tree (post order). First left branch, then right branch, finally current node
    private void visitPostOrder(BinaryTreeNode<T> startNode) {
        if (startNode == null) {
            return;
        }

        visitPostOrder(startNode.left);

        visitPostOrder(startNode.right);

        // Visit
        System.out.println(startNode.value);
    }
}
