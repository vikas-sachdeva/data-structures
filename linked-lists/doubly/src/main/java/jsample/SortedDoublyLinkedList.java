package jsample;

public class SortedDoublyLinkedList<T extends Comparable> extends BaseDoublyLinkedList<T> {

    public void add(T t) {
        Node<T> node = new Node<>(t, null, null);
        if (head == null) {
            head = tail = node;
        } else {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.getData().compareTo(t) > 0) {
                    break;
                }
                temp = temp.getNext();
            }
            if (temp == null) {
                node.setPrevious(tail);
                tail.setNext(node);
                tail = node;
            } else {
                node.setNext(temp);
                if (temp.getPrevious() == null) {
                    head = node;
                } else {
                    node.setPrevious(temp.getPrevious());
                    temp.getPrevious().setNext(node);
                }
                temp.setPrevious(node);
            }
        }
    }
}