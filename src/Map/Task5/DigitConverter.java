package Map.Task5;

import java.util.*;

public class DigitConverter {
    private static final Map<String, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        System.out.println("Введите число из арабских цифр:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println("Число из римских цифр: " + intToRoman(input));
    }

    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            while (num >= entry.getValue()) {
                int count = num / entry.getValue();
                num %= entry.getValue();
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(entry.getKey());
                }
            }
        }
        return stringBuilder.toString();
    }
}
