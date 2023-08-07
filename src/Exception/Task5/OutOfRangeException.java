package Exception.Task5;

public class OutOfRangeException extends Exception {
    String message;

    public OutOfRangeException(String message) {
        super(message);
        this.message = message;
    }
}
