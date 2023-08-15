package Files.Task3.Runner;

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
        StringBuilder stringBuilder = new StringBuilder("");
        int count = 0;
        for (File f : file.listFiles()) {
            if (count == 5) {
                break;
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f))) {
                for (int i = 0; i < 10; i++) {
                    String result = String.valueOf(random.nextInt(0, 9));
                    bufferedWriter.write(result);
                    stringBuilder.append(result);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            count++;
            stringBuilder.append("\n");
        }

        File FinalListOfNumbers = new File("src/Files/Task3/Test1/Test2/Test3/FinalListOfNumbers");
        try {
            FinalListOfNumbers.createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FinalListOfNumbers))) {
                bufferedWriter.write(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder2 = new StringBuilder("");
        for (File f : file.listFiles()) {
            stringBuilder2.append(f.getName() + "\n");
        }

        File listOfFiles = new File("src/Files/Task3/Test1/Test2/Test3/ListOfFiles");
        try {
            listOfFiles.createNewFile();
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(listOfFiles))) {
                bufferedWriter.write(stringBuilder2.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

