package jsample;

public class MaxHeap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private static final double DEFAULT_FILL_FACTOR = 0.8;

    private static final double DEFAULT_GROWTH_FACTOR = 1.5;

    private Object[] array;

    private int capacity;

    private double fillFactor;

    private double growthFactor;

    private int nextElementIndex = 0;

    public MaxHeap(int capacity, double fillFactor, double growthFactor) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not be less than 1");
        }
        if (fillFactor <= 0 && fillFactor > 1) {
            throw new IllegalArgumentException("Fill factor can not be less than and equal to 0 and can not be greater than 1");
        }
        if (growthFactor <= 1) {
            throw new IllegalArgumentException("Growth factor can not be less than or equal to 1");
        }
        this.capacity = capacity;
        this.fillFactor = fillFactor;
        this.growthFactor = growthFactor;
        this.array = new Object[capacity];
    }

    public MaxHeap(int capacity) {
        this(capacity, DEFAULT_FILL_FACTOR, DEFAULT_GROWTH_FACTOR);
    }

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public void insert(T data) {
        if (nextElementIndex >= capacity * fillFactor) {
            resize();
        }
        array[nextElementIndex] = data;
        heapifyUp(nextElementIndex);
        nextElementIndex++;
    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }
        T data = (T) array[index];
        int parentIndex = (index - 1) / 2;
        if (data.compareTo((T) array[parentIndex]) > 0) {
            array[index] = array[parentIndex];
            array[parentIndex] = data;
            heapifyUp(parentIndex);
        }
    }

    private void resize() {
        this.capacity = (int) (this.capacity * growthFactor);
        Object[] newArray = new Object[this.capacity];
        System.arraycopy(array, 0, newArray, 0, nextElementIndex);
        array = newArray;
    }

    public T extractMax() {
        if (nextElementIndex == 0) {
            throw new IllegalStateException("Heap does not have any element.");
        }
        T data = (T) array[0];
        array[0] = array[--nextElementIndex];
        heapifyDown(0);
        return data;
    }

    private void heapifyDown(int index) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = (index + 1) * 2;
        if (leftChildIndex >= nextElementIndex) {
            return;
        }
        int greaterElementIndex = leftChildIndex;
        T leftChild = (T) array[leftChildIndex];
        if (rightChildIndex < nextElementIndex && ((T) array[rightChildIndex]).compareTo(leftChild) > 0) {
            greaterElementIndex = rightChildIndex;
        }
        T data = (T) array[index];
        if (data.compareTo((T) array[greaterElementIndex]) < 0) {
            array[index] = array[greaterElementIndex];
            array[greaterElementIndex] = data;
            heapifyDown(greaterElementIndex);
        }
    }

    public int find(T data) {
        return find(data, 0);
    }

    private int find(T data, int index) {
        if (index >= nextElementIndex) {
            return -1;
        }
        T temp = (T) array[index];
        if (data.compareTo(temp) > 0) {
            return -1;
        } else if (data.compareTo(temp) == 0) {
            return index;
        } else {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = (index + 1) * 2;
            int value = find(data, leftChildIndex);
            if (value == -1) {
                return find(data, rightChildIndex);
            } else {
                return value;
            }
        }
    }

    public boolean contains(T data) {
        return find(data) != -1;
    }
}