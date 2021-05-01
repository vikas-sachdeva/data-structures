package jsample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Bst<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (root == null) {
            root = node;
        } else {
            Node<T> parent = findSuitableNode(root, data);
            if (parent.getData().compareTo(data) > 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }
        }
    }

    private Node<T> findSuitableNode(Node<T> node, T data) {
        while (true) {
            if (node.getData().compareTo(data) > 0) {
                if (node.getLeft() == null) {
                    return node;
                } else {
                    node = node.getLeft();
                }
            } else {
                if (node.getRight() == null) {
                    return node;
                } else {
                    node = node.getRight();
                }
            }
        }
    }

    public List<T> levelOrderTraversal() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            list.add(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return list;
    }

    public List<T> reverseLevelOrderTraversal() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        Stack<Node<T>> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            stack.push(temp);
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop().getData());
        }
        return list;
    }

    public List<T> preOrderTraversal() {
        List<T> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
            }
            list.add(node.getData());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            node = node.getLeft();
        }
        return list;
    }

    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Node<T> node = root;
        Stack<Node<T>> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            list.add(node.getData());
            if (node.getRight() != null) {
                node = node.getRight();
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
        }
        return list;
    }
}