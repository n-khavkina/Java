package Exception.Task5;

public class InvalidNumberException extends Exception {
    String message;

    public InvalidNumberException(String message) {
        super(message);
        this.message = message;
    }
}
