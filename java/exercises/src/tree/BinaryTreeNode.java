package tree;

// Binary Tree Node
public class BinaryTreeNode<T> {
    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode(T value,BinaryTreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    public BinaryTreeNode() {
    }

    public T value;
    public BinaryTreeNode<T> left = null;
    public BinaryTreeNode<T> right = null;

    public BinaryTreeNode<T> parent = null;
}
