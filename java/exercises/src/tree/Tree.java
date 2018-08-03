package tree;

import queue.Queue;

import java.util.List;

public class Tree<T> {
    public TreeNode<T> root;

    public void firstDepthTraversal() {
        doFirstDepthTraversal(root);
    }

    public void firstBreadthTraversal() {
        doFirstBreadthTraversal(root);
    }

    private void doFirstDepthTraversal(TreeNode<T> start) {
        List<TreeNode<T>> children = start.children;

        System.out.println(start.value);

        for(TreeNode<T> child: children) {
            doFirstDepthTraversal(child);
        }
    }

    public void doFirstBreadthTraversal(TreeNode<T> start) {
        Queue<TreeNode<T>> queue = new Queue<>();

        queue.add(start);

        while(!queue.isEmpty()) {
            TreeNode<T> toVisit = queue.remove();

            System.out.println(toVisit.value);

            for(TreeNode<T> child: toVisit.children) {
                queue.add(child);
            }
        }
    }
}
