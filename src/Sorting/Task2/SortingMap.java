package Sorting.Task2;

import java.util.*;

public class SortingMap {
    private static final Map<String, Integer> map = Map.of(
            "two", 2,
            "five", 5,
            "one", 1,
            "four", 4,
            "three", 3);

    public static void main(String[] args) {
        System.out.println(sortByValue(map));

    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list1 = new ArrayList<>(map.entrySet());
        list1.sort(Map.Entry.comparingByValue());
        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list1) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}
