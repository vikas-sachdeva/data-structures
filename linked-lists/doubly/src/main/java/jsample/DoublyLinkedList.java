package jsample;

public class DoublyLinkedList<T> extends BaseDoublyLinkedList<T> {

    public void addLast(T t) {
        Node<T> node = new Node<>(t, null, tail);
        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public void addFirst(T t) {
        Node<T> node = new Node<>(t, head, null);
        if (head == null) {
            head = tail = node;
        } else {
            head.setPrevious(node);
            head = node;
        }
    }
}