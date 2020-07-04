package jsample;

public class SinglyLinkedList<T> extends BaseSinglyLinkedList<T> {

    public void addLast(T t) {
        Node<T> node = new Node<>(t, null);
        Node<T> lastNode = getLastNode();
        if (lastNode == null) {
            head = node;
        } else {
            lastNode.setNext(node);
        }
    }

    public void addFirst(T t) {
        head = new Node<>(t, head);
    }
}