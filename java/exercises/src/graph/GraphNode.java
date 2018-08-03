package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    public T value;
    public List<GraphNode<T>> children = new ArrayList<>();
    public boolean visited = false;

    public GraphNode(T value) {
        this.value = value;
    }
}
