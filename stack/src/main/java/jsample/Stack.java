package jsample;

import jsample.exceptions.StackUnderFlowException;

public class Stack<T> {

    protected Node<T> top;

    public void push(T t) {
        Node<T> node = new Node<>(t, top);
        top = node;
    }

    private Node<T> find(T t) {
        Node<T> temp = top;
        while (temp != null && !temp.getData().equals(t)) {
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean contains(T t) {
        return find(t) != null;
    }

    public T pop() {
        T data = peek();
        top = top.getNext();
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackUnderFlowException("Stack is empty.");
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }
}