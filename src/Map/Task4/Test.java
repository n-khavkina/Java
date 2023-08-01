package Map.Task4;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        System.out.println("V = " + convertRomanToInt("V"));
        System.out.println("VI = " + convertRomanToInt("VI"));
        System.out.println("IV = " + convertRomanToInt("IV"));
        System.out.println("VII = " + convertRomanToInt("VII"));
        System.out.println("VIX = " + convertRomanToInt("VIX"));
        System.out.println("XXXIV = " + convertRomanToInt("XXXIV"));
        System.out.println("CDL = " + convertRomanToInt("CDL"));
        System.out.println("CM = " + convertRomanToInt("CM"));
    }

    public static int convertRomanToInt(String romanNumeral) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int end = romanNumeral.length() - 1;
        char[] arr = romanNumeral.toCharArray();
        int result = map.get(arr[end]);
        int arabian;
        for (int i = end - 1; i >= 0; i--) {
            arabian = map.get(arr[i]);
            if (arabian < map.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}

