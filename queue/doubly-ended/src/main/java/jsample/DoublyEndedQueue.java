package jsample;

import jsample.exceptions.QueueEmptyException;

import java.util.ArrayList;
import java.util.List;

public class DoublyEndedQueue<T> {

    protected Node<T> head;

    protected Node<T> tail;

    public void enqueTail(T t) {
        Node<T> node = new Node<>(t, null, tail);
        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public void enqueHead(T t) {
        Node<T> node = new Node<>(t, head, null);
        if (head == null) {
            head = tail = node;
        } else {
            head.setPrevious(node);
            head = node;
        }
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

    public T dequeHead() {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is Empty");
        } else {
            T data = head.getData();
            if (head.getNext() == null) {
                head = tail = null;
            } else {
                head = head.getNext();
                head.setPrevious(null);
            }
            return data;
        }
    }

    public T dequeTail() {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is Empty");
        } else {
            T data = tail.getData();
            if (tail.getPrevious() == null) {
                head = tail = null;
            } else {
                tail = tail.getPrevious();
                tail.setNext(null);
            }
            return data;
        }
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

    public List<T> getAllDataInReverseOrder() {
        List<T> list = new ArrayList<>();
        Node<T> temp = tail;
        while (temp != null) {
            list.add(temp.getData());
            temp = temp.getPrevious();
        }
        return list;
    }

    public boolean isEmpty() {
        return head == null;
    }
}