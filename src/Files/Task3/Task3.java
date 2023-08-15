package Files.Task3;

import java.io.*;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("src/Files/Task3/Test1/Test2/Test3");
        file.mkdirs();
        for (int i = 1; i <= 5; i++) {
            File file2 = new File("src/Files/Task3/Test1/Test2/Test3/File" + i + ".txt");
            try {
                file2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Random random = new Random();
        for(File f : file.listFiles()) {
            try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(f)))) {
                for (int i = 0; i < 10; i++) {
                    printWriter.write(random.nextInt(1, 20));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

