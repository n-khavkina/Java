package Map.Task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = scanner.nextLine();
        String result = text.replaceAll("[^A-zА-я ]+", "");
        String[] array = result.split(" +");
        System.out.println(Arrays.toString(array));

        Map<String, Integer> map = new HashMap<>();

        for (String word : array) {
            if (map.containsKey(word)) {
                int duplicateCount = map.get(word);
                map.put(word, ++duplicateCount);
            } else {
                map.put(word, 1);
            }
        }
        System.out.println(map);
    }
}
