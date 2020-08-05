package jsample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {

    private Stack<Node<T>> stack;

    private Set<Node<T>> set;

    private Queue<Node<T>> queue;

    public List<T> dfs(Node<T> node) {
        stack = new Stack<>();
        set = new HashSet<>();
        List<T> dataList = new ArrayList<>();
        dfs(node, dataList);
        return dataList;
    }

    private void dfs(Node<T> node, List<T> dataList) {
        if (set.contains(node)) {
            return;
        }
        set.add(node);
        dataList.add(node.getData());
        for (Node<T> n : node.getNodes()) {
            if (!set.contains(n)) {
                stack.add(n);
            }
        }
        while (!stack.isEmpty()) {
            dfs(stack.pop(), dataList);
        }
    }

    public List<T> bfs(Node<T> node) {
        queue = new LinkedList<>();
        set = new HashSet<>();
        List<T> dataList = new ArrayList<>();
        bfs(node, dataList);
        return dataList;
    }

    private void bfs(Node<T> node, List<T> dataList) {
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
        while (!queue.isEmpty()) {
            bfs(queue.remove(), dataList);
        }
    }
}