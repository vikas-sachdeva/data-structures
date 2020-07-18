package jsample;

public class Hashing<T> {

    public int getHash(T value) {
        return value.hashCode();
    }
}
