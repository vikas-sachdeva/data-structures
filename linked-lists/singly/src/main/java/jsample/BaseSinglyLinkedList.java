package jsample;

import java.util.ArrayList;
import java.util.List;

public class BaseSinglyLinkedList<T> {

    protected Node<T> head;

    public Node<T> getLastNode() {
        Node<T> temp = head;
        if (temp != null) {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
        }
        return temp;
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
        Node<T> temp = head;
        Node<T> previousNode = null;
        while (temp != null && !temp.getData().equals(t)) {
            previousNode = temp;
            temp = temp.getNext();
        }
        if (temp != null) {
            if (previousNode != null) {
                previousNode.setNext(temp.getNext());
            } else {
                head = temp.getNext();
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
}