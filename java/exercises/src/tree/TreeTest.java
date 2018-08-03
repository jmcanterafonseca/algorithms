package tree;

import java.util.HashMap;
import java.util.StringTokenizer;

public class TreeTest {

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();

        // Here the three is built
        for(String arg: args) {
            StringTokenizer tokenizer = new StringTokenizer(arg);
            String nodeValue = tokenizer.nextToken(":");

            TreeNode<String> newParent = getNode(nodeValue);

            String nodeChildren = tokenizer.nextToken(":");
            StringTokenizer childTokenizer = new StringTokenizer(nodeChildren,",");

            while(childTokenizer.hasMoreElements()) {
                String childValue = childTokenizer.nextToken();
                // We assume that children are always new nodes,
                // otherwise we would have a graph instead of a tree
                TreeNode<String> child = getNode(childValue);
                newParent.addChild(child);
            }

            if (tree.root == null) {
                tree.root = newParent;
            }
        }

        System.out.println("Tree Root: " + tree.root.value);
        System.out.println("Tree Root Children: " + tree.root.children.size());
        System.out.println("B's Children: " + tree.root.children.get(0).children.size());

        System.out.println("First Depth Traversal");
        tree.firstDepthTraversal();

        System.out.println("First Breadth Traversal");
        tree.firstBreadthTraversal();
    }

    private static TreeNode<String> getNode(String nodeValue) {
        TreeNode<String> newNode = nodeMap.get(nodeValue);
        if (newNode == null) {
            newNode = new TreeNode<>(nodeValue);
            nodeMap.put(nodeValue,newNode);
        }

        return newNode;
    }

    private static HashMap<String,TreeNode<String>> nodeMap = new HashMap<>();
}
