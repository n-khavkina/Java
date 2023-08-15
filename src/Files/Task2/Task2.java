package Files.Task2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) throws IOException {
        String regex1 = "[\\w]+";
        String regex2 = "[^\\w^\\s]";

        File file = new File("src/Files/Task2/test.txt");
        file.createNewFile();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello, world!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileReader reader = new FileReader(file)) {
            int res = reader.read();
            StringBuilder stringBuilder = new StringBuilder("");
            while (res != -1) {
                Character character = (char) res;
                stringBuilder.append(character);
                res = reader.read();
            }
            System.out.println(stringBuilder);
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(stringBuilder);
            int wordCount = 0;
            while (matcher1.find()) {
                wordCount++;
            }
            System.out.println("Количество слов: " + wordCount);

            int countOfPunctuationMarks = 0;
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(stringBuilder);

            while (matcher2.find()) {
                countOfPunctuationMarks++;
            }
            System.out.println("Количество знаков препинания: " + countOfPunctuationMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
