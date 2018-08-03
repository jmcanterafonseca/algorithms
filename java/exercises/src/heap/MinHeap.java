package heap;

import tree.BinaryTree;
import tree.BinaryTreeNode;

// Implements a MinHeap.
// A min heap is a complete binary tree where each node is smaller than its children
public class MinHeap extends BinaryTree<Integer> {
    public int getMin() {
        if (root == null) {
            throw new RuntimeException("Min Heap is empty");
        }
        return root.value;
    }

    private BinaryTreeNode<Integer> insertPoint;

    public void insertValue(int value) {
        if(root == null) {
            root = new BinaryTreeNode<Integer>(value);
            insertPoint = root;
        }
        else {
            insertPoint = insertValue(value,insertPoint);
        }
    }

    private BinaryTreeNode<Integer> insertValue(int value,BinaryTreeNode<Integer> insertPoint) {
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(value);

        if (insertPoint.left == null) {
            insertPoint.left = newNode;
        }
        else if (insertPoint.right == null) {
            insertPoint.right = newNode;
        }
        else {
            assert(false);
        }

        newNode.parent = insertPoint;

        rebalanceHeap(insertPoint);

        if (insertPoint.right != null) {
            return newNode;
        }
        else {
            return insertPoint;
        }
    }

    private void rebalanceHeap(BinaryTreeNode<Integer> startPoint) {
        if (startPoint == null || startPoint.left == null) {
            return;
        }

        int parentValue = startPoint.value;
        int leftValue = startPoint.left.value;
        int rightValue = Integer.MAX_VALUE;
        if (startPoint.right != null) {
            rightValue = startPoint.right.value;
        }

        if (parentValue > rightValue) {
            startPoint.value = rightValue;
            startPoint.right.value = parentValue;
            rebalanceHeap(startPoint);
        }
        else if (parentValue > leftValue) {
            startPoint.value = leftValue;
            startPoint.left.value = parentValue;
            rebalanceHeap(startPoint);
        }
        else {
            rebalanceHeap(startPoint.parent);
        }
    }
}
