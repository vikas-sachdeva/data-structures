package jsample.exceptions;

public class QueueEmptyException extends RuntimeException {

    public QueueEmptyException(String msg) {
        super(msg);
    }
}