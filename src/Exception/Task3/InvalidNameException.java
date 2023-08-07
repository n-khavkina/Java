package Exception.Task3;

public class InvalidNameException extends Exception {
    String message;

    public InvalidNameException(String message) {
        super(message);
        this.message = message;
    }
}
