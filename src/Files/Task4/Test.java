package Files.Task4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Test {
    static List<String> names = new ArrayList<>(Arrays.asList("Ann", "Jack", "Bob", "Mary", "John", "Larry", "Stephen",
            "Judy", "Ben", "Laura"));
    static List<String> surnames = new ArrayList<>(Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones",
            "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"));
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        File file = new File("src/Files/Task4/InfoAboutPeople.txt");
        file.createNewFile();
        for (int i = 0; i < 10; i++) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                bufferedWriter.write(new Person(names.get(random.nextInt(0, 9)),
                        surnames.get(random.nextInt(0, 9)), random.nextInt(1, 80)) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
