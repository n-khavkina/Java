package Test;

public class PasswordConfirmationException extends Exception{
    String msg;

    public PasswordConfirmationException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
