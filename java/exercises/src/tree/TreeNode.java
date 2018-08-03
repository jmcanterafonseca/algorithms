package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T value;

    public List<TreeNode<T>> children = new ArrayList<>();

    public TreeNode(T value) {
        this.value = value;
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    public TreeNode<T> getChild(int index) {
        return children.get(index);
    }

    public void removeChild(int index) {
        TreeNode<T> node = children.get(index);

        if (node.children.size() == 0) {
            children.remove(index);
        }
        else {
            throw new RuntimeException("Child is not empty");
        }
    }
}
