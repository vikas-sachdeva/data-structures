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
        List<T> dataList = new ArrayList<>();
        if (root == null) {
            return dataList;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> temp = queue.poll();
            dataList.add(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
        return dataList;
    }

    public List<T> reverseLevelOrderTraversal() {
        List<T> dataList = new ArrayList<>();
        if (root == null) {
            return dataList;
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
            dataList.add(stack.pop().getData());
        }
        return dataList;
    }

    public List<T> preOrderTraversal() {
        List<T> dataList = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();
            }
            dataList.add(node.getData());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            node = node.getLeft();
        }
        return dataList;
    }

    public List<T> inOrderTraversal() {
        List<T> dataList = new ArrayList<>();
        Node<T> node = root;
        Stack<Node<T>> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            dataList.add(node.getData());
            if (node.getRight() != null) {
                node = node.getRight();
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
        }
        return dataList;
    }

    public List<T> postOrderTraversal() {
        List<T> dataList = new ArrayList<>();
        Node<T> node;
        Stack<Node<T>> stack = new Stack<>();
        Stack<Node<T>> reversePostOrderTraversalStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            node = stack.pop();
            reversePostOrderTraversalStack.push(node);
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
        }
        while (!reversePostOrderTraversalStack.isEmpty()) {
            dataList.add(reversePostOrderTraversalStack.pop().getData());
        }
        return dataList;
    }

    public List<T> postOrderTraversalUsing1Stack() {
        List<T> dataList = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                if (node.getRight() != null) {
                    stack.push(node.getRight());
                }
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            if (node.getRight() != null && !stack.isEmpty() && node.getRight() == stack.peek()) {
                Node<T> temp = stack.pop();
                stack.push(node);
                node = temp;
            } else {
                dataList.add(node.getData());
                node = null;
            }
        }
        return dataList;
    }

    private Node<T> find(T data) {
        Node<T> node = root;
        while (node != null) {
            if (node.getData().compareTo(data) > 0) {
                node = node.getLeft();
            } else if (node.getData().compareTo(data) < 0) {
                node = node.getRight();
            } else {
                return node;
            }
        }
        return null;
    }

    public boolean contains(T data) {
        return find(data) != null;

    }

    public int findHeight() {
        if (root == null) {
            throw new IllegalStateException("Tree does not exist");
        }
        Queue<Node<T>> nodeQueue = new LinkedList<>();
        int height = -1;
        nodeQueue.add(root);
        while (true) {
            int nodeCountLevelWise = nodeQueue.size();
            if (nodeCountLevelWise == 0) {
                return height;
            } else {
                height++;
            }
            while (nodeCountLevelWise > 0) {
                Node<T> temp = nodeQueue.remove();
                if (temp.getLeft() != null) {
                    nodeQueue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    nodeQueue.add(temp.getRight());
                }
                nodeCountLevelWise--;
            }
        }
    }

}