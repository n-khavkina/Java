package Files.Task2;

import java.io.*;
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
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String result = reader.readLine();
            StringBuilder stringBuilder = new StringBuilder("");
            while (result != null) {
                stringBuilder.append(result);
                result = reader.readLine();
            }
            System.out.println(stringBuilder);
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(stringBuilder);
            int wordCount = 0;
            while (matcher1.find()) {
                wordCount++;
            }
            System.out.println("���������� ����: " + wordCount);

            int countOfPunctuationMarks = 0;
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher2 = pattern2.matcher(stringBuilder);

            while (matcher2.find()) {
                countOfPunctuationMarks++;
            }
            System.out.println("���������� ������ ����������: " + countOfPunctuationMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
