package singleton;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance(LoggingLevel.DEBUG);
        for (LoggingLevel l : LoggingLevel.values()) {
            logger.writeDownError(l.toString(), l);
        }
    }
}
