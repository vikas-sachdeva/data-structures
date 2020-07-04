package jsample;

public class SortedSinglyLinkedList<T extends Comparable<T>> extends BaseSinglyLinkedList<T> {

    public void add(T t) {
        Node<T> node = new Node<>(t, null);
        Node<T> temp = head;
        Node<T> previous = null;
        while (temp != null) {
            if (temp.getData().compareTo(t) > 0) {
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }
        if (previous == null) {
            node.setNext(head);
            head = node;
        } else {
            node.setNext(temp);
            previous.setNext(node);
        }
    }
}
