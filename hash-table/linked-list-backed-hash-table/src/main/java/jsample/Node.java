package jsample;

public class Node<T, V> {

    private Node<T, V> next;

    private Entry<T, V> entry;

    public Node(Entry<T, V> entry) {
        this.entry = entry;
    }

    public Node<T, V> getNext() {
        return next;
    }

    public void setNext(Node<T, V> next) {
        this.next = next;
    }

    public Entry<T, V> getEntry() {
        return entry;
    }
}