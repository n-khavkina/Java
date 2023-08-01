package Map.Task1;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Toy toy1 = new Toy("Мишка", 3, 500);
        Toy toy2 = new Toy("Зайчик", 3, 400);
        Toy toy3 = new Toy("Динозавр", 5, 1000);

        Map<String, Toy> map = new HashMap<>();
        map.put(toy1.getName(), toy1);
        map.put(toy2.getName(), toy2);
        map.put(toy3.getName(), toy3);

        for (Map.Entry<String, Toy> entry : map.entrySet()) {
            String key = entry.getKey();
            Toy value = entry.getValue();
            System.out.println("\"" + key + "\"" + " " + value);
        }

        System.out.println();
        System.out.println("Названия игрушек: ");
        for (String key : map.keySet()) {
            System.out.println("\"" + key + "\"");
        }
        System.out.println();
        System.out.println("Значения игрушек:");
        for (Toy toy : map.values()) {
            System.out.println(toy);
        }
    }
}
