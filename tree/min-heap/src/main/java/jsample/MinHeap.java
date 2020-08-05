package jsample;

public class MinHeap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final double DEFAULT_GROWTH_FACTOR = 0.80;

    private static final double DEFAULT_FILL_FACTOR = 1.5;

    private double growthFactor;

    private double fillFactor;

    private int nextElementIndex;

    private int totalCapacity;

    private Object[] dataArray;

    public MinHeap(int initialCapacity, double growthFactor, double fillFactor) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Capacity can not be less than 1");
        }
        if (growthFactor <= 0 || growthFactor > 1) {
            throw new IllegalArgumentException("Growth factor can not be less than or equal to 0 and greater than 1");
        }
        if (fillFactor <= 1) {
            throw new IllegalArgumentException("Fill factor can not be less than or equal to 1");
        }
        this.growthFactor = growthFactor;
        this.fillFactor = fillFactor;
        totalCapacity = initialCapacity;
        nextElementIndex = 0;
        dataArray = new Object[initialCapacity];
    }

    public MinHeap(int initialCapacity) {
        this(initialCapacity, DEFAULT_GROWTH_FACTOR, DEFAULT_FILL_FACTOR);
    }

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public void insert(T data) {
        if (nextElementIndex >= totalCapacity * growthFactor) {
            resize();
        }
        dataArray[nextElementIndex] = data;
        heapifyUp(nextElementIndex);
        nextElementIndex++;
    }

    private void resize() {
        totalCapacity = (int) (totalCapacity * fillFactor);
        Object[] newArray = new Object[totalCapacity];
        System.arraycopy(dataArray, 0, newArray, 0, nextElementIndex);
        dataArray = newArray;
    }

    private void heapifyUp(int currentElementIndex) {
        if (currentElementIndex != 0) {
            int parentIndex = (currentElementIndex + 1) / 2 - 1;
            T parent = (T) dataArray[parentIndex];
            T current = (T) dataArray[currentElementIndex];
            if (parent.compareTo(current) > 0) {
                dataArray[parentIndex] = current;
                dataArray[currentElementIndex] = parent;
                heapifyUp(parentIndex);
            }
        }
    }

    private int find(T data) {
        return find(data, 0);
    }

    private int find(T data, int currentElementIndex) {
        if (currentElementIndex >= nextElementIndex) {
            return -1;
        }
        T element = (T) dataArray[currentElementIndex];
        if (data.compareTo(element) == 0) {
            return currentElementIndex;
        } else if (data.compareTo(element) > 0) {
            int result = find(data, (currentElementIndex + 1) * 2 - 1);
            if (result == -1) {
                return find(data, (currentElementIndex + 1) * 2);
            } else {
                return result;
            }
        } else {
            return -1;
        }
    }

    public boolean contains(T data) {
        return find(data) != -1;

    }

    public T extractMin() {
        if (nextElementIndex == 0) {
            throw new IllegalArgumentException("Heap does not have any element.");
        }
        T min = (T) dataArray[0];
        dataArray[0] = dataArray[--nextElementIndex];
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int currentElementIndex) {
        T parent = (T) dataArray[currentElementIndex];
        int leftChildIndex = (currentElementIndex + 1) * 2 - 1;
        int rightChildIndex = (currentElementIndex + 1) * 2;
        if (leftChildIndex >= nextElementIndex) {
            return;
        }
        T leftChild = (T) dataArray[leftChildIndex];
        int smallestChildIndex = leftChildIndex;
        if (rightChildIndex < nextElementIndex && leftChild.compareTo((T) dataArray[rightChildIndex]) > 0) {
            smallestChildIndex = rightChildIndex;
        }
        if (parent.compareTo((T) dataArray[smallestChildIndex]) > 0) {
            dataArray[currentElementIndex] = dataArray[smallestChildIndex];
            dataArray[smallestChildIndex] = parent;
            heapifyDown(smallestChildIndex);
        }
    }
}