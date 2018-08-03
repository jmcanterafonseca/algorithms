package graph;

import queue.Queue;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    public List<GraphNode<T>> nodes = new ArrayList<>();

    public void firstDepthTraversal() {
        for(GraphNode<T> node: nodes) {
            doFirstDepthTraversal(node);
        }
    }

    public void doFirstDepthTraversal(GraphNode<T> node) {
        if (!node.visited) {
            System.out.println(node.value);
            node.visited = true;
        }

        for(GraphNode<T> childNode: node.children) {
            if (!childNode.visited) {
                doFirstDepthTraversal(childNode);
            }
        }
    }

    public void firstBreadthTraversal() {
        for(GraphNode<T> node: nodes) {
            doFirstBreadthTraversal(node);
        }
    }

    public void doFirstBreadthTraversal(GraphNode<T> start) {
        Queue<GraphNode<T>> queue = new Queue<>();

        queue.add(start);

        while(!queue.isEmpty()) {
            GraphNode<T> toVisit = queue.remove();

            if (!toVisit.visited) {
                toVisit.visited = true;
                System.out.println(toVisit.value);
            }

            for(GraphNode<T> child: toVisit.children) {
                if (!child.visited) {
                    queue.add(child);
                }
            }
        }
    }
}
