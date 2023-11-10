package singleton;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static Logger instance;
    private final LoggingLevel loggingLevel;
    File file = new File("C:\\Users\\Дима\\Desktop\\HomeWork\\Java\\src\\singleton\\test.txt");

    private Logger(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public static Logger getInstance(LoggingLevel logLevel) {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger(logLevel);
                }
            }
        }
        return instance;
    }

    public void writeDownError(String message, LoggingLevel logLevel) {
        if (logLevel.ordinal() >= loggingLevel.ordinal()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(LocalDateTime.now() + " " + logLevel.toString() + " " +
                        message + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
