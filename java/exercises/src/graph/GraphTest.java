package graph;

import tree.Tree;
import tree.TreeNode;

import java.util.HashMap;
import java.util.StringTokenizer;

public class GraphTest {

    private static Graph<String> buildGraph(String[] adjacency) {
        nodeMap.clear();

        Graph<String> graph = new Graph<>();

        // Here the graph is built
        for(String adj: adjacency) {
            StringTokenizer tokenizer = new StringTokenizer(adj);
            String nodeValue = tokenizer.nextToken(":");

            GraphNode<String> newParent = getNode(nodeValue);

            String nodeChildren = tokenizer.nextToken(":");
            StringTokenizer childTokenizer = new StringTokenizer(nodeChildren,",");

            while(childTokenizer.hasMoreElements()) {
                String childValue = childTokenizer.nextToken();
                GraphNode<String> child = getNode(childValue);
                newParent.children.add(child);
            }

            graph.nodes.add(newParent);
        }

        return graph;
    }

    public static void main(String[] args) {
        Graph<String> graph = buildGraph(args);
        System.out.println("First Depth Traversal");
        graph.firstDepthTraversal();

        graph = buildGraph(args);
        System.out.println("First Breadth Traversal");
        graph.firstBreadthTraversal();
    }

    private static GraphNode<String> getNode(String nodeValue) {
        GraphNode<String> newNode = nodeMap.get(nodeValue);
        if (newNode == null) {
            newNode = new GraphNode<>(nodeValue);
            nodeMap.put(nodeValue,newNode);
        }

        return newNode;
    }

    private static HashMap<String,GraphNode<String>> nodeMap = new HashMap<>();
}
