package jsample;

public class HashTable<T, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final double DEFAULT_GROWTH_FACTOR = 0.80;

    private static final double DEFAULT_FILL_FACTOR = 1.5;

    private int initialCapacity;

    private double growthFactor;

    private double fillFactor;

    private Node<T, V>[] nodeArray;

    private Hashing<T> hashing = new Hashing<>();

    private int filledCapacity;

    private int totalCapacity;

    public HashTable(int initialCapacity, double growthFactor, double fillFactor) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Capacity can not be less than 1");
        }
        if (growthFactor <= 0 || growthFactor > 1) {
            throw new IllegalArgumentException("Growth factor can not be less than or equal to 0 and greater than 1");
        }
        if (fillFactor <= 1) {
            throw new IllegalArgumentException("Fill factor can not be less than or equal to 1");
        }
        this.initialCapacity = initialCapacity;
        this.growthFactor = growthFactor;
        this.fillFactor = fillFactor;
        totalCapacity = initialCapacity;
        filledCapacity = 0;
        nodeArray = new Node[initialCapacity];
    }

    public HashTable(int initialCapacity) {
        this(initialCapacity, DEFAULT_GROWTH_FACTOR, DEFAULT_FILL_FACTOR);
    }

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public void put(T key, V value) {
        if (filledCapacity + 1 >= totalCapacity * growthFactor) {
            resize();
        }
        int hashValue = hashing.getHash(key);
        int arrayIndex = hashValue % totalCapacity;
        Entry<T, V> entry = new Entry<>(key, value);
        if (nodeArray[arrayIndex] == null) {
            nodeArray[arrayIndex] = new Node<>(entry);
        } else {
            Node<T, V> temp = nodeArray[arrayIndex];
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<>(entry));
        }
        filledCapacity++;
    }

    private void resize() {
        totalCapacity = (int) (totalCapacity * fillFactor);
        Node<T, V>[] oldNodeArray = nodeArray;
        nodeArray = new Node[totalCapacity];
        filledCapacity = 0;
        for (Node<T, V> node : oldNodeArray) {
            if (node != null) {
                Node<T, V> temp = node;
                put(temp.getEntry().getKey(), temp.getEntry().getValue());
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                    put(temp.getEntry().getKey(), temp.getEntry().getValue());
                }
            }
        }
    }

    public Entry<T, V>[] getEntries() {
        Entry<T, V>[] entries = new Entry[filledCapacity];
        int index = 0;
        for (Node<T, V> tvNode : nodeArray) {
            if (tvNode != null) {
                Node<T, V> node = tvNode;
                entries[index++] = tvNode.getEntry();
                while (node.getNext() != null) {
                    node = node.getNext();
                    entries[index++] = node.getEntry();
                }
            }
        }
        return entries;
    }

    public V getValue(T key) {
        int hashValue = hashing.getHash(key);
        int arrayIndex = hashValue % totalCapacity;
        Node<T, V> node = nodeArray[arrayIndex];
        while (node != null) {
            if (node.getEntry().getKey().equals(key)) {
                return node.getEntry().getValue();
            } else {
                node = node.getNext();
            }
        }
        return null;
    }

    public boolean contains(T key) {
        return getValue(key) != null;
    }

    public boolean remove(T key) {
        int hashValue = hashing.getHash(key);
        int arrayIndex = hashValue % totalCapacity;
        Node<T, V> node = nodeArray[arrayIndex];
        if (node == null) {
            return false;
        }
        if (node.getEntry().getKey().equals(key)) {
            nodeArray[arrayIndex] = node.getNext();
            filledCapacity--;
            return true;
        }
        while (node.getNext() != null) {
            if (node.getNext().getEntry().getKey().equals(key)) {
                node.setNext(node.getNext().getNext());
                filledCapacity--;
                return true;
            } else {
                node = node.getNext();
            }
        }
        return false;
    }
}