package Map.Task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        Map<Character, Integer> map = getCharsCount(scanner.nextLine());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            System.out.println(("\'" + key + "\'" + " - " + value));
        }
    }

    public static Map<Character, Integer> getCharsCount(String s) {
        String result = s.replaceAll("[^A-zА-я]+", "");
        char[] array = result.toCharArray();
        System.out.println(Arrays.toString(array));

        Map<Character, Integer> map = new HashMap<>();

        for (char c : array) {
            if (map.containsKey(c)) {
                int duplicateCount = map.get(c);
                map.put(c, ++duplicateCount);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
