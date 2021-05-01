package jsample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graph<T> {

    private Set<Node<T>> set;

    private Queue<Node<T>> queue;

    public List<T> depthFirstTraversal(Node<T> node) {
        set = new HashSet<>();
        List<T> dataList = new ArrayList<>();
        depthFirstTraversal(node, dataList);
        return dataList;
    }

    private void depthFirstTraversal(Node<T> node, List<T> dataList) {
        if (set.contains(node)) {
            return;
        }
        set.add(node);
        dataList.add(node.getData());
        for (Node<T> n : node.getNodes()) {
            if (!set.contains(n)) {
                depthFirstTraversal(n, dataList);
            }
        }
    }

    public List<T> breadthFirstTraversal(Node<T> node) {
        queue = new LinkedList<>();
        set = new HashSet<>();
        List<T> dataList = new ArrayList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            breadthFirstTraversal(queue.remove(), dataList);
        }
        return dataList;
    }

    private void breadthFirstTraversal(Node<T> node, List<T> dataList) {
        if (set.contains(node)) {
            return;
        }
        set.add(node);
        dataList.add(node.getData());
        for (Node<T> n : node.getNodes()) {
            if (!set.contains(n)) {
                queue.add(n);
            }
        }
    }
}