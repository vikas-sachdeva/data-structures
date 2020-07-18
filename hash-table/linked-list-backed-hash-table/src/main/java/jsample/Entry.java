package jsample;

import java.util.Objects;
import java.util.StringJoiner;

public class Entry<T, V> {

    private T key;

    private V value;

    public Entry(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Entry.class.getSimpleName() + "[", "]")
                .add("key=" + key)
                .add("value=" + value)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return Objects.equals(key, entry.key) &&
               Objects.equals(value, entry.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}