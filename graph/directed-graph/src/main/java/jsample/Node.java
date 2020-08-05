package jsample;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data;

    private List<Node<T>> nodes = new ArrayList<>();

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Node<T>> getNodes() {
        return nodes;
    }

    public void addNodes(Node<T>... node) {
        for (Node n : node) {
            this.nodes.add(n);
        }
    }
}
