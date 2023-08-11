package Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        File d = null;
        File[] directory;
        File[] files;
        List<String> fileNames = new ArrayList<>();
        try {
            d = new File("src/Generics");
            directory = d.listFiles();
            System.out.println("Названия каталогов:");
            for (File p : directory) {
                System.out.println(p.getName());
                files = p.listFiles();
                for (File file : files) {
                    fileNames.add(file.getName());
                }
            }
        } catch (Exception e) {
            System.out.println("Каталог не найден");
        }
        System.out.println("Названия файлов: ");
        for (String s : fileNames) {
            System.out.println(s);
        }
    }
}