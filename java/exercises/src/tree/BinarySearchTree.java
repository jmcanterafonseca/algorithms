package tree;

// A Binary search tree is a binary tree in which every node fits a specific ordering property
// all left descendents <= n < all right descendents
public class BinarySearchTree extends BinaryTree<Integer> {
    // The only method redefined is rebalance that is called after each insertion
    protected void rebalance(BinaryTreeNode<Integer> startNode) {
        if (startNode == null || startNode.left == null) {
            return;
        }

        BinaryTreeNode<Integer> left = startNode.left;
        BinaryTreeNode<Integer> right = startNode.right;

        Integer leftValue = left.value;
        Integer rightValue = Integer.MAX_VALUE;
        if (right != null) {
           rightValue = right.value;
        }
        Integer parentValue = startNode.value;

        if (leftValue > parentValue) {
            startNode.value = leftValue;
            left.value = parentValue;
            rebalance(startNode);
        }
        else if (rightValue < parentValue) {
            startNode.value = rightValue;
            right.value = parentValue;
            rebalance(startNode);
        }
        else {
            rebalance(startNode.parent);
        }
    }
}
