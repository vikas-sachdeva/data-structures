package jsample;

import jsample.exceptions.QueueEmptyException;

import java.util.ArrayList;
import java.util.List;

public class SinglyEndedQueue<T> {

    protected Node<T> head;

    protected Node<T> tail;

    public void enque(T t) {
        Node<T> node = new Node<>(t, null);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    private Node<T> find(T t) {
        Node<T> temp = head;
        while (temp != null && !temp.getData().equals(t)) {
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean contains(T t) {
        return find(t) != null;
    }

    public T deque() {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty.");
        }
        T data = head.getData();
        head = head.getNext();
        return data;
    }

    public List<T> getAllData() {
        List<T> list = new ArrayList<>();
        Node<T> temp = head;
        while (temp != null) {
            list.add(temp.getData());
            temp = temp.getNext();
        }
        return list;
    }

    public boolean isEmpty() {
        return head == null;
    }
}