package jsample;

import java.util.ArrayList;
import java.util.List;

public class BaseDoublyLinkedList<T> {

    protected Node<T> head;

    protected Node<T> tail;

    public Node<T> getLastNode() {
        return tail;
    }

    public Node<T> find(T t) {
        Node<T> temp = head;
        while (temp != null && !temp.getData().equals(t)) {
            temp = temp.getNext();
        }
        return temp;
    }

    public boolean contains(T t) {
        return find(t) != null;
    }

    public boolean remove(T t) {
        Node<T> temp = find(t);
        if (temp != null) {
            if (temp == head && temp == tail) {
                head = null;
                tail = null;
            } else if (temp == head) {
                temp.getNext().setPrevious(null);
                head = temp.getNext();
            } else if (temp == tail) {
                temp.getPrevious().setNext(null);
                tail = temp.getPrevious();
            } else {
                temp.getNext().setPrevious(temp.getPrevious());
                temp.getPrevious().setNext(temp.getNext());
            }
            return true;
        } else {
            return false;
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
}