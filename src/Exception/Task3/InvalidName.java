package Exception.Task3;

public class InvalidName extends Exception {
    String message;

    public InvalidName(String message) {
        super(message);
        this.message = message;
    }
}
