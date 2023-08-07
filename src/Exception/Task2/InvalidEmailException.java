package Exception.Task2;

public class InvalidEmailException extends Exception {
    String message;

    public InvalidEmailException(String message) {
        super(message);
        this.message = message;
    }
}
