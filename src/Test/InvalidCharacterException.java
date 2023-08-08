package Test;

public class InvalidCharacterException  extends Exception{
    String msg;

    public InvalidCharacterException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
